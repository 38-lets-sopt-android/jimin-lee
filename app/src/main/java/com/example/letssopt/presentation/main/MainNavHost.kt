package com.example.letssopt.presentation.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.letssopt.presentation.home.navigation.homeGraph
import com.example.letssopt.presentation.login.navigation.loginGraph
import com.example.letssopt.presentation.profile.navigation.profileGraph
import com.example.letssopt.presentation.purchase.navigation.purchaseGraph
import com.example.letssopt.presentation.search.navigation.searchGraph
import com.example.letssopt.presentation.signup.navigation.signUpGraph
import com.example.letssopt.presentation.splash.navigation.splashGraph
import com.example.letssopt.presentation.storage.navigation.storageGraph
import com.example.letssopt.presentation.webtoon.navigation.webtoonGraph

@Composable
fun MainNavHost(
    appState: MainAppState,
    innerPadding: PaddingValues,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = appState.startDestination,
        modifier = Modifier,
        enterTransition = {
            fadeIn(
                animationSpec = tween(500)
            )
        },
        exitTransition = {
            fadeOut(
                animationSpec = tween(500)
            )
        },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
    ) {
        splashGraph(
            navController = navController,
            innerPadding = innerPadding,
        )

        loginGraph(
            navController = navController,
            innerPadding = innerPadding,
        )

        signUpGraph(
            navController = navController,
            innerPadding = innerPadding,
        )

        homeGraph(
            navController = navController,
            innerPadding = innerPadding,
        )

        purchaseGraph(
            navController = navController,
            innerPadding = innerPadding,
        )

        webtoonGraph(
            navController = navController,
            innerPadding = innerPadding,
        )

        searchGraph(
            navController = navController,
            innerPadding = innerPadding,
        )

        storageGraph(
            navController = navController,
            innerPadding = innerPadding,
        )

        profileGraph(
            navController = navController,
            innerPadding = innerPadding,
        )
    }
}
