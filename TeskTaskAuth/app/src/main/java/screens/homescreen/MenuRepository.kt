package screens.homescreen

import retrofit.models.MenuResponse
import retrofit2.Response

interface MenuRepository {
    suspend fun getMenuLayout():Response<MenuResponse>
}