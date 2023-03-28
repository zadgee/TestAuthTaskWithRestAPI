package screens.authscreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import logindata
import passworddata
import retrofit.models.AuthPostAPI
import retrofit.models.AuthRequestData
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val repository:AuthRepository,private val api: AuthPostAPI) : ViewModel() {
    private val _versionstate = MutableLiveData<Response<AuthVersionResponse>>()
    val versionstate:LiveData<Response<AuthVersionResponse>> = _versionstate

    init {
       viewModelScope.launch {
           _versionstate.value = repository.getVersion()
       }
    }

 fun checkVersionInitialization(){
     viewModelScope.launch {
         _versionstate.value = repository.getVersion()
     }
 }



    fun sendLoginAndpassdata(login:String, password:String){
        viewModelScope.launch {
       try {
       val response = api.sendlogindata(login, password)
           if(response.isSuccessful){
               response.body()?.token
               response.code()
           }else{
               response.errorBody()?.string()
               response.code()
           }
       }catch (e:Exception){
           Log.e("Error postresponse","${e.localizedMessage}")
       }
        }
    }
}