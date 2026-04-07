package com.example.letssopt.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.ui.theme.LETSSOPTTheme
import com.example.letssopt.utils.noRippleClickable

@Composable
fun LetsSoptButton(
    btnText: String,
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = if (enabled) LETSSOPTTheme.colors.primaryRed else LETSSOPTTheme.colors.disabled,
                shape = RoundedCornerShape(8.dp),
            )
            .noRippleClickable(
                onClick = onClick
            )
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = btnText,
            modifier = Modifier,
            style = LETSSOPTTheme.typography.body.regular16,
            color = if (enabled) LETSSOPTTheme.colors.txtPrimary else LETSSOPTTheme.colors.placeholder
        )
    }
}

@Preview
@Composable
private fun LetsSoptButtonPreview() {
    LETSSOPTTheme {
        Column {
            LetsSoptButton(
                btnText = "로그인",
                enabled = true,
                onClick = {}
            )

            Spacer(modifier = Modifier.height(10.dp))

            LetsSoptButton(
                btnText = "로그인",
                enabled = false,
                onClick = {}
            )
        }
    }
}
