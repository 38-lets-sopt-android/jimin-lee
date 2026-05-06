package com.example.letssopt.presentation.login.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.letssopt.core.extension.clearBackStackNavOptions
import com.example.letssopt.core.navigation.Route
import com.example.letssopt.presentation.home.navigation.navigateToHome
import com.example.letssopt.presentation.login.LoginRoute
import com.example.letssopt.presentation.signup.navigation.navigateToSignUp
import kotlinx.serialization.Serializable

fun NavController.navigateToLogin(
    navOptions: NavOptions? = clearBackStackNavOptions(),
){
    navigate(
        route = Login,
        navOptions = navOptions,
    )
}

fun NavGraphBuilder.loginGraph(
    navController: NavController,
    innerPadding: PaddingValues,
) {
    composable<Login> {
        LoginRoute(
            navigateToSignUp = navController::navigateToSignUp,
            navigateToHome = navController::navigateToHome,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Serializable
data object Login : Route
