package di
import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit.AuthAPI
import retrofit.BrandCatalogAPI
import retrofit.CheckVersion
import retrofit.RetrofitServiceAPI
import retrofit.models.*
import screens.authscreen.AuthRepository
import screens.authscreen.AuthRepositoryImpl
import screens.catalogscreen.CatalogRepository
import screens.catalogscreen.CatalogRepositoryImpl
import screens.homescreen.MenuRepository
import screens.homescreen.MenuRepositoryImpl
import screens.homescreen.UserRepository
import screens.homescreen.UserRepositoryImpl


@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {
@Provides
@ViewModelScoped
fun providerepo(api:RetrofitServiceAPI):RouteRepository{
return RouteRepositoryImpl(
   api
)
}

@Provides
fun providecontext(app:Application):Context{
   return app
}

   @Provides
   @ViewModelScoped
   fun provideauthrepository(api: CheckVersionAPI):AuthRepository{
      return AuthRepositoryImpl(
         api
      )
   }
   @Provides
   @ViewModelScoped
   fun provideuserrepo(api: UsersApi):UserRepository{
      return UserRepositoryImpl(
         api
      )
   }
   @Provides
   @ViewModelScoped
   fun providecatalogrepo(api: MenuAPI):MenuRepository{
      return MenuRepositoryImpl(
         api
      )
   }
   @Provides
   @ViewModelScoped
   fun providebrandscatalorepo(api:BrandCatalogAPI):CatalogRepository{
      return CatalogRepositoryImpl(
         api
      )
   }
}