package com.example.savingsquadsfrontend.api

import java.lang.RuntimeException

class UserRepository (
    private val apiService: ApiService,
    private val tokenStorage: TokenStorage,
    ) {
    suspend fun loginUser( loginRequest: LoginRequest) : Result<LoginResponse> {
        return try {
            val response = apiService.loginUser(loginRequest)
            if (response.isSuccessful) {
                tokenStorage.storeToken(response.body()!!.jwt)
                Result.success(response.body()!!)
            }
            else {
                Result.failure(RuntimeException("error message"))
            }
        } catch (e : Exception) {
            Result.failure(e)
        }
    }

    suspend fun logoutUser(): Result<LogoutResponse> {
        return try {
            val response = apiService.logoutUser()
            if (response.isSuccessful) {
                tokenStorage.clearToken()
                Result.success(response.body()!!)
            } else {
                // handle error response
                Result.failure(RuntimeException("error message"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }


}
