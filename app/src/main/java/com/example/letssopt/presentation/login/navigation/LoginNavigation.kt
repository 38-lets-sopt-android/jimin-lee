package com.example.letssopt.presentation.login.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.letssopt.core.navigation.Route
import com.example.letssopt.presentation.login.LoginRoute
import kotlinx.serialization.Serializable

fun NavController.navigateToLogin(
    navOptions: NavOptions? = null,
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
            onSignUpTxtClick = {},
            onLoginSuccess = {},
            onShowToast = {},
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Serializable
data object Login : Route
