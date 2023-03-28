package screens.authscreen
import retrofit.models.CheckVersionAPI
import retrofit2.Response
import javax.inject.Inject

class AuthRepositoryImpl@Inject constructor( private  val  api:CheckVersionAPI
                                             ) : AuthRepository {
    override suspend fun getVersion(): Response<AuthVersionResponse>{
        return api.checkVersionSuccess()
    }


}
