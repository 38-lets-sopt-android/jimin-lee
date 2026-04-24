package com.example.letssopt.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Black = Color(0xFF000000)
val PrimaryRed = Color(0xFFE8003C)
val Background = Color(0xFF141414)
val Surface = Color(0xFF2A2A2A)
val TextPrimary = Color(0xFFFFFFFF)
val TextSecondary = Color(0xFF999999)
val TextTertiary = Color(0xFFBABAC1)
val PlaceHolder = Color(0xFF666666)
val Disabled = Color(0xFF333333)

@Immutable
data class LETSSOPTColors(
    val Black: Color,
    val primaryRed: Color,
    val background: Color,
    val surface: Color,
    val txtPrimary: Color,
    val txtSecondary: Color,
    val txtTertiary: Color,
    val placeholder: Color,
    val disabled: Color,
)

val defaultLETSSOPTColors = LETSSOPTColors(
    Black = Black,
    primaryRed = PrimaryRed,
    background = Background,
    surface = Surface,
    txtPrimary = TextPrimary,
    txtSecondary = TextSecondary,
    txtTertiary = TextTertiary,
    placeholder = PlaceHolder,
    disabled = Disabled,
)

val LocalLETSSOPTColors = staticCompositionLocalOf { defaultLETSSOPTColors }
