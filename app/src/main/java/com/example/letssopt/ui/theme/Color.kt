package com.example.letssopt.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val PrimaryRed = Color(0xFFE8003C)
val Background = Color(0xFF141414)
val Surface = Color(0xFF2A2A2A)
val TextPrimary = Color(0xFFFFFFFF)
val TextSecondary = Color(0xFF999999)
val PlaceHolder = Color(0xFF666666)
val Disabled = Color(0xFF333333)

@Immutable
data class LETSSOPTColors(
    val primaryRed: Color,
    val background: Color,
    val surface: Color,
    val txtPrimary: Color,
    val txtSecondary: Color,
    val placeholder: Color,
    val disabled: Color,
)

val defaultLETSSOPTColors = LETSSOPTColors(
    primaryRed = PrimaryRed,
    background = Background,
    surface = Surface,
    txtPrimary = TextPrimary,
    txtSecondary = TextSecondary,
    placeholder = PlaceHolder,
    disabled = Disabled,
)

val LocalLETSSOPTColors = staticCompositionLocalOf { defaultLETSSOPTColors }
