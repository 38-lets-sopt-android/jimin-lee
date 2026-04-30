package com.example.letssopt.presentation.signup.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.letssopt.core.navigation.Route
import com.example.letssopt.presentation.login.navigation.navigateToLogin
import com.example.letssopt.presentation.signup.SignUpRoute
import kotlinx.serialization.Serializable

fun NavController.navigateToSignUp(
    navOptions: NavOptions? = null,
){
    navigate(
        route = SignUp,
        navOptions = navOptions,
    )
}

fun NavGraphBuilder.signUpGraph(
    navController: NavController,
    innerPadding: PaddingValues,
) {
    composable<SignUp> {
        SignUpRoute(
            navigateToLogin = navController::navigateToLogin,
            modifier = Modifier.padding(innerPadding),
        )
    }
}

@Serializable
data object SignUp : Route
