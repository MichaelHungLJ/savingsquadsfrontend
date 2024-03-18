package com.example.savingsquadsfrontend.model

import android.util.Log
import com.example.savingsquadsfrontend.api.ApiService
import com.example.savingsquadsfrontend.api.LoginRequest
import com.example.savingsquadsfrontend.api.LoginResponse
import com.example.savingsquadsfrontend.api.LogoutResponse
import com.example.savingsquadsfrontend.api.Voucher
import com.example.savingsquadsfrontend.api.VoucherResponse
import com.example.savingsquadsfrontend.domain.UserRepository
import java.lang.RuntimeException
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
) : UserRepository {

    override suspend fun loginUser( loginRequest: LoginRequest) : Result<LoginResponse> {
        return try {
            val response = apiService.loginUser(loginRequest)
            if (response.isSuccessful) {
                Log.v("Login", "Success ${response.body()}")
                Result.success(response.body()!!)
            }
            else {
                Log.v("Login","${response.message()}" )
                Result.failure(RuntimeException("Login: ${response.message()}"))
            }
        } catch (e : Exception) {
            Log.v("Login","Exception: ${e.message}")
            Result.failure(e)
        }
    }

    override suspend fun logoutUser(): Result<LogoutResponse> {
        return try {
            val response = apiService.logoutUser()
            if (response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                // handle error response
                Result.failure(RuntimeException("error message"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getUserVoucher(): Result<List<Voucher>?> {
        return try {
            val response = apiService.getUserVouchers()
            if (response.isSuccessful) {
                // Now we extract the list from the wrapper
                val vouchersList = response.body()?.vouchers
                Log.v("Voucher", "Response Size: ${vouchersList?.size ?: "No size"}")
                Result.success(vouchersList)
            } else {
                Log.v("Voucher", "Error: ${response.errorBody()?.string() ?: "Unknown error"}")
                Result.failure(RuntimeException("Voucher fetch error: ${response.message()}"))
            }
        } catch (e: Exception) {
            Log.v("Voucher", "Exception: ${e.message}")
            Result.failure(e)
        }
    }
}
