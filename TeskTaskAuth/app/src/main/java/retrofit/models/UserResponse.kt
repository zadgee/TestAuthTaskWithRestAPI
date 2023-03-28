package retrofit.models

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("userId") val id:Int,
    @SerializedName("firstname") val name:String,
@SerializedName("lastname") val surname:String,
@SerializedName("pmFirstname") val pmfirtst:String,
@SerializedName("pmLastname") val pmlast:String,
@SerializedName("pmTelephone") val pmphone:String,
@SerializedName("tsFirstname") val tsfirst:String,
@SerializedName("tsLastname") val tslast:String,
@SerializedName("tsTelephone") val tsphone:String,
@SerializedName("balance") val balance :Int,
@SerializedName("bonusToday") val bonusToday:Int,
@SerializedName("bonusTotal") val bonustotal: Int,
@SerializedName("bonusTitle") val bonustitle: String
)