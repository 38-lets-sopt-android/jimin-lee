package com.example.letssopt.presentation.splash.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.core.navigation.Route
import com.example.letssopt.presentation.home.navigation.navigateToHome
import com.example.letssopt.presentation.login.navigation.navigateToLogin
import com.example.letssopt.presentation.splash.SplashRoute
import kotlinx.serialization.Serializable

fun NavGraphBuilder.splashGraph(
    navController: NavController,
    innerPadding: PaddingValues,
) {
    composable<Splash> {
        SplashRoute(
            navigateToHome = navController::navigateToHome,
            navigateToLogin = navController::navigateToLogin,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Serializable
data object Splash : Route
