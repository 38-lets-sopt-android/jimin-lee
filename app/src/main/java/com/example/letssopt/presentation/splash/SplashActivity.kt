package com.example.letssopt.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.letssopt.core.designsystem.component.text.LogoText
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.core.utils.PreferencesUtil
import com.example.letssopt.presentation.login.LoginActivity
import com.example.letssopt.presentation.main.MainActivity
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SplashRoute(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SplashRoute(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val prefs = PreferencesUtil(context)
    val userInfo = prefs.getUserInfo()

    LaunchedEffect(Unit) {
        delay(2000L)
        if(userInfo.email.isNotEmpty() && userInfo.password.isNotEmpty()) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        } else {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
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
