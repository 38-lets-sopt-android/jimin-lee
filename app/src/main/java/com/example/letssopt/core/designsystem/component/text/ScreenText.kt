package com.example.letssopt.core.designsystem.component.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme

@Composable
fun ScreenText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier,
        color = LETSSOPTTheme.colors.txtPrimary,
        style = LETSSOPTTheme.typography.h2.bold20,
    )
}

@Preview
@Composable
private fun ScreenTextPreview() {
    LETSSOPTTheme {
        ScreenText(
            text = "이메일로 로그인"
        )
    }
}
