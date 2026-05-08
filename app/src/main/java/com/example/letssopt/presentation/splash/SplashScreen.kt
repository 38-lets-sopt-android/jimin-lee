package com.example.letssopt.presentation.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.letssopt.core.designsystem.component.text.LogoText
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.core.utils.PreferencesUtil
import kotlinx.coroutines.delay

@Composable
fun SplashRoute(
    navigateToHome: () -> Unit,
    navigateToLogin: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val prefs = PreferencesUtil(context)

    LaunchedEffect(Unit) {
        delay(2000L)
        if(prefs.getAutoLogin() && prefs.getUserId() != -1) {
            navigateToHome()
        } else {
            navigateToLogin()
        }
    }

    SplashScreen(
        modifier = modifier,
    )
}

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = LETSSOPTTheme.colors.background,
            ),
        contentAlignment = Alignment.Center,
    ) {
        LogoText()
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    LETSSOPTTheme {
        SplashScreen()
    }
}
