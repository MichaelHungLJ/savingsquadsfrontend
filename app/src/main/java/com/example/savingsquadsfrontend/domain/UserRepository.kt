package com.example.savingsquadsfrontend.domain

import com.example.savingsquadsfrontend.api.LoginRequest
import com.example.savingsquadsfrontend.api.LoginResponse
import com.example.savingsquadsfrontend.api.LogoutResponse

interface UserRepository {

    suspend fun loginUser(loginRequest: LoginRequest) : Result<LoginResponse>

    suspend fun logoutUser() : Result<LogoutResponse>

    suspend fun authenticate()

}
