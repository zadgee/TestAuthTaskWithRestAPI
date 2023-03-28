package retrofit.models

import com.google.gson.annotations.SerializedName

data class MenuResponse(
    @SerializedName("items")
    val items:ItemsMenu
)
data class ItemsMenu(
    @SerializedName("itemsId")
    val id:Int,
    @SerializedName("itemName")
    val name:String,
    @SerializedName("itemImage")
    val image:String
)