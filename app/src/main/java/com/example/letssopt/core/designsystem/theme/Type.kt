package com.example.letssopt.core.designsystem.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.letssopt.R
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme.typography

object PretendardFont {
    val Light = FontFamily(Font(R.font.pretendard_light))
    val Medium = FontFamily(Font(R.font.pretendard_medium))
    val SemiBold = FontFamily(Font(R.font.pretendard_semibold))
    val Regular = FontFamily(Font(R.font.pretendard_regular))
    val Bold = FontFamily(Font(R.font.pretendard_bold))
}

sealed interface TypographyTokens {
    @Immutable
    data class L1(
        val bold36: TextStyle,
    ) : TypographyTokens

    @Immutable
    data class H1(
        val bold24: TextStyle,
    ) : TypographyTokens

    @Immutable
    data class H2(
        val bold20: TextStyle,
    ) : TypographyTokens

    @Immutable
    data class H3(
        val semibold20: TextStyle,
    ) : TypographyTokens

    @Immutable
    data class SubH1(
        val semibold20: TextStyle,
    ) : TypographyTokens

    @Immutable
    data class SubH2(
        val semibold18: TextStyle,
    ) : TypographyTokens

    @Immutable
    data class SubH3(
        val semibold12: TextStyle,
    ) : TypographyTokens

    @Immutable
    data class Body(
        val regular16: TextStyle,
    ) : TypographyTokens

    @Immutable
    data class Body2(
        val regular12: TextStyle,
    ) : TypographyTokens

    @Immutable
    data class Body3(
        val medium12: TextStyle,
    ) : TypographyTokens

    @Immutable
    data class Caption1(
        val regular14: TextStyle,
    ) : TypographyTokens

    @Immutable
    data class Caption2(
        val light12: TextStyle,
    ) : TypographyTokens
}

@Immutable
data class LETSSOPTTypography(
    val l1: TypographyTokens.L1,
    val h1: TypographyTokens.H1,
    val h2: TypographyTokens.H2,
    val h3: TypographyTokens.H3,
    val subhead1: TypographyTokens.SubH1,
    val subhead2: TypographyTokens.SubH2,
    val subhead3: TypographyTokens.SubH3,
    val body: TypographyTokens.Body,
    val body2: TypographyTokens.Body2,
    val body3: TypographyTokens.Body3,
    val caption1: TypographyTokens.Caption1,
    val caption2: TypographyTokens.Caption2,
)

private fun LETSSOPTTextStyle(
    fontFamily: FontFamily,
    fontSize: TextUnit,
    lineHeight: TextUnit = 1.0.em,
    letterSpacing: TextUnit = 0.sp,
): TextStyle = TextStyle(
    fontFamily = fontFamily,
    fontSize = fontSize,
    lineHeight = lineHeight,
    letterSpacing = letterSpacing,
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None,
    ),
)

val defaultLETSSOPTTypography = LETSSOPTTypography(
    l1 = TypographyTokens.L1(
        bold36 = LETSSOPTTextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 36.sp,
        ),
    ),
    h1 = TypographyTokens.H1(
        bold24 = LETSSOPTTextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 24.sp,
        ),
    ),
    h2 = TypographyTokens.H2(
        bold20 = LETSSOPTTextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 20.sp,
        ),
    ),
    h3 = TypographyTokens.H3(
        semibold20 = LETSSOPTTextStyle(
            fontFamily = PretendardFont.SemiBold,
            fontSize = 20.sp,
        ),
    ),
    subhead1 = TypographyTokens.SubH1(
        semibold20 = LETSSOPTTextStyle(
            fontFamily = PretendardFont.SemiBold,
            fontSize = 20.sp,
        ),
    ),
    subhead2 = TypographyTokens.SubH2(
        semibold18 = LETSSOPTTextStyle(
            fontFamily = PretendardFont.SemiBold,
            fontSize = 18.sp,
        ),
    ),
    subhead3 = TypographyTokens.SubH3(
        semibold12 = LETSSOPTTextStyle(
            fontFamily = PretendardFont.SemiBold,
            fontSize = 12.sp,
        ),
    ),
    body = TypographyTokens.Body(
        regular16 = LETSSOPTTextStyle(
            fontFamily = PretendardFont.Regular,
            fontSize = 16.sp,
        ),
    ),
    body2 = TypographyTokens.Body2(
        regular12 = LETSSOPTTextStyle(
            fontFamily = PretendardFont.Regular,
            fontSize = 12.sp,
        ),
    ),
    body3 = TypographyTokens.Body3(
        medium12 = LETSSOPTTextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 12.sp,
        ),
    ),
    caption1 = TypographyTokens.Caption1(
        regular14 = LETSSOPTTextStyle(
            fontFamily = PretendardFont.Regular,
            fontSize = 14.sp,
        ),
    ),
    caption2 = TypographyTokens.Caption2(
        light12 = LETSSOPTTextStyle(
            fontFamily = PretendardFont.Light,
            fontSize = 12.sp,
        ),
    ),
)

val LocalLETSSOPTTypography = staticCompositionLocalOf { defaultLETSSOPTTypography }

@Preview(showBackground = true)
@Composable
fun LETSSOPTTypographyPreview() {
    LETSSOPTTheme {
        Column {
            Text("로고 제목 L1.bold36", style = typography.l1.bold36)
            Text("제목 H1.bold24", style = typography.h1.bold24)
            Text("제목 H2.bold20", style = typography.h2.bold20)
            Text("본문 Body.regular16", style = typography.body.regular16)
            Text("캡션 Caption.regular14", style = typography.caption1.regular14)
        }
    }
}
