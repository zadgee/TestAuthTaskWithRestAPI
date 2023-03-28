package retrofit.models

import retrofit2.Response

interface RouteRepository {
    suspend fun getRoute():Response<RouteModel>
}