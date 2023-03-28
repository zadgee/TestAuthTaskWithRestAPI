package retrofit

import retrofit.models.BrandCatalogResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface BrandCatalogAPI {
    @GET("?token=MzgwOTM4ODQ1Mzk06T1Wbh")
    @Headers("token:MzgwOTM4ODQ1Mzk06T1Wbh")
    suspend fun getBrandCatalog():Response<BrandCatalogResponse>
}