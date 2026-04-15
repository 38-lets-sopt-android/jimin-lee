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
            putString(IntentKeys.KEY_EMAIL, email)
            putString(IntentKeys.KEY_PW, password)
            apply()
        }
    }

    fun getUserInfo(): UserInfo {
        return UserInfo(
            email = pref.getString(IntentKeys.KEY_EMAIL, "") ?: "",
            password = pref.getString(IntentKeys.KEY_PW, "") ?: "",
        )
    }
}

