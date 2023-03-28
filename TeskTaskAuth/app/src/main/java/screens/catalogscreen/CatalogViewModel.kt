package screens.catalogscreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit.models.BrandCatalogResponse
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel@Inject constructor(private val repository: CatalogRepository):ViewModel() {
private val _brandsstate = MutableLiveData<Response<BrandCatalogResponse>>()
    val brandstate : LiveData<Response<BrandCatalogResponse>> = _brandsstate

    fun  initializebrandlist(){
        viewModelScope.launch {
            try {
                _brandsstate.value = repository.getBrandsAPI()
            }catch (e:Exception){
                Log.e("Failed response","Something went wrong with response")
            }
        }
    }
}