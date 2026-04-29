package com.example.letssopt.core.extension

import androidx.navigation.NavController
import androidx.navigation.navOptions


fun NavController.clearBackStackNavOptions() = navOptions {
    popUpTo(0) {
        inclusive = true
    }
    launchSingleTop = true
}

fun NavController.clearBackStackWithRestoreNavOptions() = navOptions {
    popUpTo(0) {
        saveState = true
        inclusive = true
    }
    launchSingleTop = true
    restoreState = true
}
