package com.example.letssopt.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.component.LetsSoptButton
import com.example.letssopt.component.LetsSoptTextField
import com.example.letssopt.component.text.LogoText
import com.example.letssopt.component.text.ScreenText
import com.example.letssopt.ui.theme.LETSSOPTTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignUpScreen(
                        btnEnabled = true,
                        onSignUpBtnClick = {},
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
private fun SignUpScreen(
    btnEnabled: Boolean,
    onSignUpBtnClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = LETSSOPTTheme.colors.background,
            )
            .padding(horizontal = 20.dp)
            .padding(top = 60.dp, bottom = 26.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LogoText()

        Spacer(modifier = Modifier.height(26.dp))

        ScreenText(
            text = "회원가입",
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(36.dp))

        LetsSoptTextField(
            title = "이메일",
            state = rememberTextFieldState(),
            placeholder = "이메일 주소를 입력하세요",
            modifier = Modifier,
        )

        Spacer(modifier = Modifier.height(18.dp))

        LetsSoptTextField(
            title = "비밀번호",
            state = rememberTextFieldState(),
            placeholder = "비밀번호를 입력하세요",
            modifier = Modifier,
        )

        Spacer(modifier = Modifier.height(18.dp))

        LetsSoptTextField(
            title = "비밀번호 확인",
            state = rememberTextFieldState(),
            placeholder = "비밀번호를 다시 입력하세요",
            modifier = Modifier,
        )

        Spacer(modifier = Modifier.weight(1f))

        LetsSoptButton(
            btnText = "회원가입",
            enabled = btnEnabled,
            onClick = onSignUpBtnClick,
            modifier = Modifier,
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun SignUpScreenPreview() {
    LETSSOPTTheme {
        SignUpScreen(
            btnEnabled = true,
            onSignUpBtnClick = {},
        )
    }
}
