package screens.homescreen

import retrofit.models.UserResponse
import retrofit.models.UsersApi
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl@Inject constructor(private val api: UsersApi) : UserRepository {
    override suspend fun getUserAPI(): Response<UserResponse> {
        return api.getUser()
    }
}