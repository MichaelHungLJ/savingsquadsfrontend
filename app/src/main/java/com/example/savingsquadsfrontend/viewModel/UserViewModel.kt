package com.example.savingsquadsfrontend.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.savingsquadsfrontend.api.LoginRequest
import com.example.savingsquadsfrontend.domain.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor (
    private val userRepository: UserRepository
) : ViewModel() {

    fun loginUser(loginRequest: LoginRequest) {
        viewModelScope.launch {
            val result = userRepository.loginUser(loginRequest)
            if (result.isSuccess) {
                Log.v("Login", "Success")
            }
            else {
                Log.v("Login", "Failed")
            }
        }
    }

    fun logoutUser() {
        viewModelScope.launch {
            val result = userRepository.logoutUser()
            if (result.isSuccess) {
                Log.v("Logout", "Success")
            }
            else {
                Log.v("Logout", "Failed")
            }
        }
    }

    fun getUserVoucher() {
        viewModelScope.launch {
            val result = userRepository.getUserVoucher()
            if (result.isSuccess) {
                Log.v("Voucher", "Success")
            }
        }
    }

}
