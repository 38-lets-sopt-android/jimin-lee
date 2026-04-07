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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
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

            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var passwordCheck by remember { mutableStateOf("") }

            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignUpScreen(
                        email = email,
                        password = password,
                        passwordCheck = passwordCheck,
                        onEmailChange = { email = it },
                        onPasswordChange = { password = it },
                        onPasswordCheckChange = { passwordCheck = it },
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
    email: String,
    password: String,
    passwordCheck: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordCheckChange: (String) -> Unit,
    onSignUpBtnClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val passwordVisualTransformation = remember { PasswordVisualTransformation() }

    val isBtnEnabled = email.isNotEmpty() && password.isNotEmpty() && passwordCheck.isNotEmpty()

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
            value = email,
            onValueChange = onEmailChange,
            placeholder = "이메일 주소를 입력하세요",
            modifier = Modifier,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        )

        Spacer(modifier = Modifier.height(18.dp))

        LetsSoptTextField(
            title = "비밀번호",
            value = password,
            onValueChange = onPasswordChange,
            placeholder = "비밀번호를 입력하세요",
            modifier = Modifier,
            visualTransformation = passwordVisualTransformation,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        )

        Spacer(modifier = Modifier.height(18.dp))

        LetsSoptTextField(
            title = "비밀번호 확인",
            value = passwordCheck,
            onValueChange = onPasswordCheckChange,
            placeholder = "비밀번호를 다시 입력하세요",
            modifier = Modifier,
            visualTransformation = passwordVisualTransformation,
        )

        Spacer(modifier = Modifier.weight(1f))

        LetsSoptButton(
            btnText = "회원가입",
            enabled = isBtnEnabled,
            onClick = onSignUpBtnClick,
            modifier = Modifier,
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun SignUpScreenPreview() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordCheck by remember { mutableStateOf("") }

    LETSSOPTTheme {
        SignUpScreen(
            email = email,
            password = password,
            passwordCheck = passwordCheck,
            onEmailChange = { email = it },
            onPasswordChange = { password = it },
            onPasswordCheckChange = { passwordCheck = it },
            onSignUpBtnClick = {},
        )
    }
}
