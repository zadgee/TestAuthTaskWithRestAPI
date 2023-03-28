package retrofit.models

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface UsersApi {
    @GET("?token=MzgwOTM4ODQ1Mzk06T1Wbh")
    @Headers("token:token=MzgwOTM4ODQ1Mzk06T1Wbh")
    suspend fun getUser():Response<UserResponse>

}