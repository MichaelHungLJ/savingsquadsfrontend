package com.example.savingsquadsfrontend.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import java.util.Date

interface ApiService {

    @POST("/v1/users/login")
    suspend fun loginUser(
        @Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("/v1/users/logout")
    suspend fun logoutUser(): Response<LogoutResponse>

    @GET("/v1/users/vouchers")
    suspend fun getUserVouchers(): Response<VoucherResponse>
}



data class LoginRequest (
    val email : String,
    val password: String,
)

data class LoginResponse (
    val message : String,
)

data class LogoutResponse (
    val message: String
)

data class VoucherResponse (
    val vouchers: List<Voucher>?
)

data class Voucher (
    val code: String,
    val description: String,
    val discount: Int,
    val isPercentage: Boolean,
    val starts: Date, // or LocalDateTime or ZonedDateTime based on your time API
    val expires: Date, // or LocalDateTime or ZonedDateTime based on your time API
    val active: Boolean,
    val userUsageRemaining: Int,
    val minSpend: Int,
    val category: String
)

