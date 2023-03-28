package screens.homescreen

import retrofit.models.UserResponse
import retrofit2.Response

interface UserRepository {
    suspend fun getUserAPI():Response<UserResponse>
}