package retrofit.models

import com.google.gson.annotations.SerializedName

data class BrandCatalogResponse(
    @SerializedName("brands")
    val brands:BrandItems
)
data class BrandItems(
    @SerializedName("7")
    val apple:BrandsDetails,
    @SerializedName("47")
    val samsung:BrandsDetails,
    @SerializedName("57")
    val xiaomi:BrandsDetails
)

data class BrandsDetails(
    @SerializedName("brandId")
    val id:Int,
    @SerializedName("brandName")
    val name : String,
    @SerializedName("brandImage")
    val image:String
)