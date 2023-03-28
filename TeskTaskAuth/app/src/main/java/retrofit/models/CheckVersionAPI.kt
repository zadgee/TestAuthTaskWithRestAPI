package retrofit.models

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import screens.authscreen.AuthVersionResponse

interface CheckVersionAPI{
    @GET("latest?v=36")
    @Headers("v:36")
    suspend fun checkVersionSuccess():Response<AuthVersionResponse> // success
}
