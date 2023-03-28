package retrofit.models

import com.google.gson.annotations.SerializedName
import devaid
import devavs
import devman
import devmod
import logindata
import passworddata


data class AuthRequestData(
    @SerializedName("login")
    val login:String = logindata ,
    @SerializedName("password")
    val password:String = passworddata,
    @SerializedName("devman")
    val devmann:String = devman,
    @SerializedName("devmod")
    val dev_mod : String = devmod,
    @SerializedName("devavs")
    val dev_avs:String=devavs,
    @SerializedName("devaid")
    val dev_aid :String = devaid
)

