package screens.catalogscreen

import retrofit.BrandCatalogAPI
import retrofit.models.BrandCatalogResponse
import retrofit2.Response
import javax.inject.Inject

class CatalogRepositoryImpl@Inject constructor(private val api:BrandCatalogAPI) : CatalogRepository {
    override suspend fun getBrandsAPI(): Response<BrandCatalogResponse> {
       return api.getBrandCatalog()
    }
}