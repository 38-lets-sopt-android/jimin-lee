package com.example.letssopt.core.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.letssopt.data.model.UserInfo

class PreferencesUtil(
    context: Context,
) {

    private val pref: SharedPreferences =
        context.getSharedPreferences(PrefKeys.PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun setUserInfo(
        email: String,
        password: String,
    ) {
        pref.edit {
            putString(PrefKeys.KEY_PREFERENCES_EMAIL, email)
            putString(PrefKeys.KEY_PREFERENCES_PW, password)
        }
    }

    fun getUserInfo(): UserInfo {
        return UserInfo(
            email = pref.getString(PrefKeys.KEY_PREFERENCES_EMAIL, "") ?: "",
            password = pref.getString(PrefKeys.KEY_PREFERENCES_PW, "") ?: "",
        )
    }

    object PrefKeys {
        const val PREFERENCE_NAME = "MyPref"
        const val KEY_PREFERENCES_EMAIL = "emailKey"
        const val KEY_PREFERENCES_PW = "passwordKey"
    }
}

