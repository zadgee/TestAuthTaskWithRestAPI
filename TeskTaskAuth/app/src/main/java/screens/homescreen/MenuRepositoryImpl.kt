package screens.homescreen

import retrofit.models.MenuAPI
import retrofit.models.MenuResponse
import retrofit2.Response
import javax.inject.Inject

class MenuRepositoryImpl@Inject constructor(private val api:MenuAPI) : MenuRepository {
    override suspend fun getMenuLayout(): Response<MenuResponse> {
      return  api.getCatalogLayout()
    }
}