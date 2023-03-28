package di
import androidx.annotation.MenuRes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit.*
import retrofit.models.AuthPostAPI
import retrofit.models.CheckVersionAPI
import retrofit.models.UsersApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit.models.MenuAPI
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor() =
        HttpLoggingInterceptor().apply {
           this.level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    fun provideHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()


    @Provides
    @Singleton
    @Route
    fun provideInstance(okHttpClient: OkHttpClient):Retrofit =
        Retrofit.Builder()
            .baseUrl("https://cr-test-ribu2uaqea-ey.a.run.app/routes/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()


    @Provides
  @Singleton
    fun provideRetrofit( @Route retrofit: Retrofit):RetrofitServiceAPI=
        retrofit.create(RetrofitServiceAPI::class.java)





   @Provides
   @Singleton
   @CheckVersion
   fun provideversionInstance(okHttpClientVersion: OkHttpClient):Retrofit=
       Retrofit.Builder()
           .client(okHttpClientVersion)
           .addConverterFactory(GsonConverterFactory.create())
           .baseUrl("https://ca-test-ribu2uaqea-ey.a.run.app/app/version/")
           .build()

    @Provides
    @Singleton
    fun provideRetrofitVersionClient(@CheckVersion retrofit: Retrofit):CheckVersionAPI =
        retrofit.create(CheckVersionAPI::class.java)


    @Provides
    @Singleton
    @AuthAPI
    fun provideOkttpClient(okHttpClient: OkHttpClient):Retrofit =
      Retrofit.Builder()
          .baseUrl("https://ca-test-ribu2uaqea-ey.a.run.app/users/")
          .addConverterFactory(GsonConverterFactory.create())
          .client(okHttpClient)
          .build()

    @Provides
    @Singleton
    fun provideAuthAPIclient(@AuthAPI retrofit: Retrofit) : AuthPostAPI =
        retrofit.create(AuthPostAPI::class.java)


//    @Provides
//    @Singleton
//    @Brands
//    fun provideOkhttpbrand(okHttpClient: OkHttpClient):Retrofit=
//        Retrofit.Builder()
//            .baseUrl("https://ca-test-ribu2uaqea-ey.a.run.app/catalog/brands/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(okHttpClient)
//            .build()
//
//    @Provides
//    @Singleton
//    fun provideRetrofitBrands(@Brands retrofit: Retrofit):// =
//        retrofit.create(//::class.java)

@Provides
@Singleton
@USERAPI
fun provideuserokhttp(okHttpClient: OkHttpClient):Retrofit =
    Retrofit.Builder()
        .baseUrl("https://ca-test-ribu2uaqea-ey.a.run.app/users/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()


    @Provides
    @Singleton
    fun  provideRetrofitUsers(@USERAPI retrofit: Retrofit):UsersApi=
        retrofit.create(UsersApi::class.java)


    @Provides
    @Singleton
   @MenuAPIAnnotation
    fun providemenuokhttp(okHttpClient: OkHttpClient):Retrofit =
        Retrofit.Builder()
            .baseUrl("https://ca-test-ribu2uaqea-ey.a.run.app/home/menu/items/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

   @Provides
   @Singleton
   fun provideMenuApi(@MenuAPIAnnotation retrofit: Retrofit):MenuAPI =
    retrofit.create(MenuAPI::class.java)


    @Provides
    @Singleton
    @BrandsAPI
    fun providebrandsokhttp(okHttpClient: OkHttpClient):Retrofit =
        Retrofit.Builder()
            .baseUrl("https://ca-test-ribu2uaqea-ey.a.run.app/catalog/brands/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()


    @Provides
    @Singleton
    fun providebrandAPI(@BrandsAPI retrofit: Retrofit):BrandCatalogAPI =
        retrofit.create(BrandCatalogAPI::class.java)
   }