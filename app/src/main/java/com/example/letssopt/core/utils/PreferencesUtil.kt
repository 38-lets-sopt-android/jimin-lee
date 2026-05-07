package com.example.letssopt.core.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class PreferencesUtil(
    context: Context,
) {

    private val pref: SharedPreferences =
        context.getSharedPreferences(PrefKeys.PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun setAutoLogin(
        isAutoLogin: Boolean
    ) = pref.edit {
        putBoolean(PrefKeys.KEY_PREFERENCES_AUTO_LOGIN, isAutoLogin)
    }


    fun getAutoLogin(): Boolean {
        return pref.getBoolean(PrefKeys.KEY_PREFERENCES_AUTO_LOGIN, false)
    }

    object PrefKeys {
        const val PREFERENCE_NAME = "MyPref"
        const val KEY_PREFERENCES_AUTO_LOGIN = "auto_login"
    }
}

