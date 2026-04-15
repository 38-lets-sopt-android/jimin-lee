package com.example.letssopt.core.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.letssopt.data.model.UserInfo

class PreferencesUtil(
    context: Context,
) {

    private val prefName = "MyPref"
    private val pref: SharedPreferences =
        context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

    fun setUserInfo(
        email: String,
        password: String,
    ) {
        pref.edit().apply {
            putString(PrefKeys.KEY_EMAIL, email)
            putString(PrefKeys.KEY_PW, password)
            apply()
        }
    }

    fun getUserInfo(): UserInfo {
        return UserInfo(
            email = pref.getString(PrefKeys.KEY_EMAIL, "") ?: "",
            password = pref.getString(PrefKeys.KEY_PW, "") ?: "",
        )
    }

    object PrefKeys {
        const val KEY_EMAIL = "emailKey"
        const val KEY_PW = "passwordKey"
    }
}

