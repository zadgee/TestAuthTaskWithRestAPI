package screens.authscreen
import retrofit2.Response

interface AuthRepository {
    suspend fun getVersion():Response<AuthVersionResponse>
}