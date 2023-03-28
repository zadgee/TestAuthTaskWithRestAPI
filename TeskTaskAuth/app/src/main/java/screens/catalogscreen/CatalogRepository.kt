package screens.catalogscreen

import retrofit.models.BrandCatalogResponse
import retrofit2.Response

interface CatalogRepository {
    suspend fun getBrandsAPI():Response<BrandCatalogResponse>
}