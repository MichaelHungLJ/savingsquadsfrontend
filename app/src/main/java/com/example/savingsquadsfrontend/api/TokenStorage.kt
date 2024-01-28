package com.example.savingsquadsfrontend.api

import android.content.Context
import android.content.SharedPreferences

class TokenStorage (context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences("prefs_name", Context.MODE_PRIVATE)

    fun storeToken(token:String) {
        prefs.edit().putString("jwt", token).apply()
    }

    fun getToken() : String? {
        return prefs.getString("jwt", null)
    }

    fun clearToken() {
        prefs.edit().remove("jwt").apply()
    }
}
