package retrofit.models

import android.util.Log
import retrofit.RetrofitServiceAPI
import retrofit2.Response
import javax.inject.Inject

class RouteRepositoryImpl@Inject constructor(private val api: RetrofitServiceAPI) : RouteRepository {
    override suspend fun getRoute() : Response<RouteModel> {
        val response = api.getroutes()
        try{
            if(response.isSuccessful){
                return response
            }
        }catch (e:Exception){
            Log.e("TAGINTERNET","Something went wrong with ${response} or Internet is turned off")
        }
        return api.getroutes()
        }

    }

