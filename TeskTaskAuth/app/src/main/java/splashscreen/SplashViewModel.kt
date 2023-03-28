package splashscree
import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.*
import android.net.NetworkCapabilities.*
import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit.models.RouteModel
import retrofit.models.RouteRepository
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SplashViewModel@Inject constructor(private val repository: RouteRepository,
                                         private val app:Application
                                         )
    :ViewModel() {
   val _state = MutableLiveData<Response<RouteModel>>()
    val state : LiveData<Response<RouteModel>> = _state

    init {
        initResponse()
    }


 @SuppressLint("SuspiciousIndentation")
 fun initResponse(){
    viewModelScope.launch {
       _state.value = repository.getRoute()

    }
}

}