package com.example.savingsquadsfrontend.domain

import com.example.savingsquadsfrontend.api.LoginRequest
import com.example.savingsquadsfrontend.api.LoginResponse
import com.example.savingsquadsfrontend.api.LogoutResponse
import com.example.savingsquadsfrontend.api.Voucher
import com.example.savingsquadsfrontend.api.VoucherResponse

interface UserRepository {

    suspend fun loginUser(loginRequest: LoginRequest) : Result<LoginResponse>

    suspend fun logoutUser() : Result<LogoutResponse>

    suspend fun getUserVoucher() : Result<List<Voucher>?>

}
