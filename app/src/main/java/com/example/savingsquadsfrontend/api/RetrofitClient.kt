package com.example.savingsquadsfrontend.api

import android.content.Context
import android.media.session.MediaSession.Token
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private lateinit var tokenStorage: TokenStorage

    private val BASE_URL = "http://localhost:3000"

    fun init(tokenStorage: TokenStorage) {
        this.tokenStorage = tokenStorage
    }
    private fun getJWTToken() : String {
        return tokenStorage.getToken() ?: ""
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            val httpPath = original.url()
            val requestBuilder = original.newBuilder()

            if (!httpPath.encodedPath().endsWith("/v1/users/login")) {
                val jwtToken = getJWTToken()
                requestBuilder.addHeader("Authorization", "Bearer $jwtToken")
            }
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(ApiService::class.java)
}
