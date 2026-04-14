package com.example.letssopt.core.designsystem.component.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme

@Composable
fun LogoText(
    modifier: Modifier = Modifier,
) {
    Text(
        text = "watcha",
        modifier = modifier,
        color = LETSSOPTTheme.colors.primaryRed,
        style = LETSSOPTTheme.typography.l1.bold36,
    )
}

@Preview
@Composable
private fun LogoTextPreview() {
    LETSSOPTTheme {
        LogoText()
    }
}
