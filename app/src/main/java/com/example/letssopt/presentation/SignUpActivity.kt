package com.example.letssopt.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.component.LetsSoptButton
import com.example.letssopt.component.LetsSoptTextField
import com.example.letssopt.component.text.LogoText
import com.example.letssopt.component.text.ScreenText
import com.example.letssopt.ui.theme.LETSSOPTTheme
import com.example.letssopt.utils.IntentKeys

private val emailRegex = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
private val passwordRegex = Regex("^.{8,12}$")

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var passwordConfirm by remember { mutableStateOf("") }

            LETSSOPTTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = WindowInsets(),
                ) { innerPadding ->
                    SignUpScreen(
                        email = email,
                        password = password,
                        passwordConfirm = passwordConfirm,
                        onEmailChange = { email = it },
                        onPasswordChange = { password = it },
                        onPasswordConfirmChange = { passwordConfirm = it },
                        onSignUpBtnClick = {
                            checkValidation(
                                email = email,
                                password = password,
                                passwordConfirm = passwordConfirm,
                            )
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun checkValidation(
        email: String,
        password: String,
        passwordConfirm: String,
    ) {
        val isEmailValid = email.matches(emailRegex)
        val isPasswordValid = password.matches(passwordRegex)
        val isPasswordMatch = password == passwordConfirm

        when {
            !isEmailValid -> {
                Toast.makeText(this, "이메일 형식이 잘못되었습니다", Toast.LENGTH_SHORT).show()
            }

            !isPasswordValid -> {
                Toast.makeText(this, "비밀번호는 8~12자로 입력해주세요", Toast.LENGTH_SHORT).show()
            }

            !isPasswordMatch -> {
                Toast.makeText(this, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show()
            }

            else -> {
                val intent = Intent(this, LoginActivity::class.java).apply {
                    putExtra(IntentKeys.KEY_EMAIL, email)
                    putExtra(IntentKeys.KEY_PW, password)
                }

                Toast.makeText(this, "회원가입이 완료되었습니다", Toast.LENGTH_SHORT).show()

                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}

@Composable
private fun SignUpScreen(
    email: String,
    password: String,
    passwordConfirm: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordConfirmChange: (String) -> Unit,
    onSignUpBtnClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current
    val passwordVisualTransformation = remember { PasswordVisualTransformation() }

    val isBtnEnabled = email.isNotEmpty() && password.isNotEmpty() && passwordConfirm.isNotEmpty()

    Column (
        modifier = modifier
            .fillMaxSize()
            .background(
                color = LETSSOPTTheme.colors.background,
            )
            .imePadding()
            .padding(horizontal = 20.dp)
            .padding(top = 60.dp, bottom = 26.dp),
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(scrollState),
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
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(focusDirection = FocusDirection.Down)
                    }
                ),
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
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(focusDirection = FocusDirection.Down)
                    }
                ),
            )

            Spacer(modifier = Modifier.height(18.dp))

            LetsSoptTextField(
                title = "비밀번호 확인",
                value = passwordConfirm,
                onValueChange = onPasswordConfirmChange,
                placeholder = "비밀번호를 다시 입력하세요",
                modifier = Modifier,
                visualTransformation = passwordVisualTransformation,
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                    }
                ),
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        LetsSoptButton(
            btnText = "회원가입",
            enabled = isBtnEnabled,
            onClick = onSignUpBtnClick,
            modifier = Modifier
                .navigationBarsPadding(),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpScreenPreview() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }

    LETSSOPTTheme {
        SignUpScreen(
            email = email,
            password = password,
            passwordConfirm = passwordConfirm,
            onEmailChange = { email = it },
            onPasswordChange = { password = it },
            onPasswordConfirmChange = { passwordConfirm = it },
            onSignUpBtnClick = {},
        )
    }
}
