package com.example.letssopt.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object LETSSOPTTheme {
    val colors: LETSSOPTColors
        @Composable
        @ReadOnlyComposable
        get() = LocalLETSSOPTColors.current

    val typography: LETSSOPTTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalLETSSOPTTypography.current
}

@Composable
fun ProvideLETSSOPTColorsAndTypography(
    colors: LETSSOPTColors,
    typography: LETSSOPTTypography,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalLETSSOPTColors provides colors,
        LocalLETSSOPTTypography provides typography,
        content = content,
    )
}

@Composable
fun LETSSOPTTheme(
    content: @Composable () -> Unit
) {
    ProvideLETSSOPTColorsAndTypography(
        colors = defaultLETSSOPTColors,
        typography = defaultLETSSOPTTypography,
    ) {
        MaterialTheme(
            content = content,
        )
    }
}
