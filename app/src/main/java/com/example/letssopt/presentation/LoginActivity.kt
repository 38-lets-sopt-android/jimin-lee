package com.example.letssopt.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(
                        btnEnabled = true,
                        onSignUpTxtClick = {},
                        onLoginBtnClick = {},
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(
    btnEnabled: Boolean,
    onSignUpTxtClick: () -> Unit,
    onLoginBtnClick: () -> Unit,
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
            text = "이메일로 로그인",
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

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "아직 계정이 없으신가요? 회원가입",
            modifier = Modifier
                .clickable(
                    onClick = onSignUpTxtClick,
                ),
            color = LETSSOPTTheme.colors.txtSecondary,
            style = LETSSOPTTheme.typography.caption.regular14,
        )

        Spacer(modifier = Modifier.height(20.dp))

        LetsSoptButton(
            btnText = "로그인",
            enabled = btnEnabled,
            onClick = onLoginBtnClick,
            modifier = Modifier,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LETSSOPTTheme {
        LoginScreen(
            btnEnabled = true,
            onSignUpTxtClick = {},
            onLoginBtnClick = {},
        )
    }
}
