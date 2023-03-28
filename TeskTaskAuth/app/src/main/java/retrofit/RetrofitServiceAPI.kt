package retrofit
import retrofit.models.RouteModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers


interface RetrofitServiceAPI {
    @GET("?appName=cuton&v=36")
    @Headers("appName:cuton","v:36")
    suspend fun getroutes():Response<RouteModel>
}