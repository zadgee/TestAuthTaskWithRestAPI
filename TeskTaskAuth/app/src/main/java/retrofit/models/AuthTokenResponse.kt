package retrofit.models

import authtoken
import com.google.gson.annotations.SerializedName

data class AuthTokenResponse (
    @SerializedName("token")
    val token:String = authtoken
        )



