package com.example.savingsquadsfrontend.di

import android.content.Context
import com.example.savingsquadsfrontend.api.ApiService
import com.example.savingsquadsfrontend.api.TokenStorage
import com.example.savingsquadsfrontend.domain.UserRepository
import com.example.savingsquadsfrontend.model.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserRepository(apiService: ApiService, tokenStorage: TokenStorage): UserRepository {
        return UserRepositoryImpl(apiService, tokenStorage)
    }

    private val BASE_URL = "http://10.0.2.2:3000"

    @Provides
    @Singleton
    fun provideTokenStorage(@ApplicationContext context: Context): TokenStorage {
        return TokenStorage(context)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(tokenStorage: TokenStorage): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val httpPath = original.url()
                val requestBuilder = original.newBuilder()

                if (!httpPath.encodedPath().endsWith("/v1/users/login")) {
                    val jwtToken = tokenStorage.getToken() ?: ""
                    requestBuilder.addHeader("Authorization", "Bearer $jwtToken")
                }
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}
