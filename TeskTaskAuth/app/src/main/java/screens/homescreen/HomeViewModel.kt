package screens.homescreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit.models.MenuResponse
import retrofit.models.UserResponse
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel@Inject constructor(private val userRepository: UserRepository,private val menuRepository: MenuRepository):ViewModel() {
private val _stateuser  = MutableLiveData<Response<UserResponse>>()
    val stateuser :LiveData<Response<UserResponse>> = _stateuser
    private val _statemenu  = MutableLiveData<Response<MenuResponse>>()
    val statemenu :LiveData<Response<MenuResponse>> = _statemenu

  fun realizeuserrepository(){
     viewModelScope.launch {
         try {
             _stateuser.value = userRepository.getUserAPI()
         }catch (e:Exception){
             Log.e("Response error","Something went wrong with response")
         }
     }
  }
    fun realizemenurepository(){
        viewModelScope.launch {
            try {
                _statemenu.value = menuRepository.getMenuLayout()
            }catch (e:Exception){
                Log.e("Response error","${e.localizedMessage}")
            }
        }
    }
}