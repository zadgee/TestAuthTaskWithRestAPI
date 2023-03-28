package retrofit.models
import com.google.gson.annotations.SerializedName
import devaid
import devavs
import devman
import devmod
import logindata
import passworddata
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthPostAPI {
    @POST("login/")
    @FormUrlEncoded
    suspend fun sendlogindata(
        @Field("login") login: String = logindata,
        @Field("password")password:String= passworddata,
        @Field("devman")devmann: String = devman,
        @Field("devmod") devmodd:String = devmod,
        @Field("devavs") dev_avs: String = devavs,
        @Field("devaid") dev_aid: String = devaid
    ):Response<AuthTokenResponse>
}

