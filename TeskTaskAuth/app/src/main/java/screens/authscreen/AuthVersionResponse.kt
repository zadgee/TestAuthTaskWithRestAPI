package screens.authscreen

import com.google.gson.annotations.SerializedName

data class AuthVersionResponse(
    @SerializedName("answer")
    val answer:Int
)
