package com.example.letssopt.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.core.designsystem.component.LetsSoptButton
import com.example.letssopt.core.designsystem.component.LetsSoptTextField
import com.example.letssopt.core.designsystem.component.text.LogoText
import com.example.letssopt.core.designsystem.component.text.ScreenText
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.core.utils.IntentKeys
import com.example.letssopt.core.extension.noRippleClickable

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            var emailResult by remember { mutableStateOf("") }
            var passwordResult by remember { mutableStateOf("") }

            val launcher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.StartActivityForResult()
            ) { result ->
                if (result.resultCode == RESULT_OK) {
                    emailResult = result.data?.getStringExtra(IntentKeys.KEY_EMAIL) ?: ""
                    passwordResult = result.data?.getStringExtra(IntentKeys.KEY_PW) ?: ""
                }
            }

            LETSSOPTTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = WindowInsets(),
                ) { innerPadding ->
                    LoginScreen(
                        email = email,
                        password = password,
                        onEmailChange = { email = it },
                        onPasswordChange = { password = it },
                        onSignUpTxtClick = {
                            val intent = Intent(this, SignUpActivity::class.java)
                            launcher.launch(intent)
                        },
                        onLoginBtnClick = {
                            handleLoginResult(
                                email = email,
                                password = password,
                                emailResult = emailResult,
                                passwordResult = passwordResult,
                            )
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun handleLoginResult(
        email: String,
        password: String,
        emailResult: String,
        passwordResult: String,
    ) {

        when {
            email.isBlank() || password.isBlank() -> {
                Toast.makeText(this, "아이디와 비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
            }

            email != emailResult || password != passwordResult -> {
                Toast.makeText(this, "아이디 또는 비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show()
            }

            else -> {
                Toast.makeText(this, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                }
                startActivity(intent)
            }
        }
    }
}

@Composable
private fun LoginScreen(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onSignUpTxtClick: () -> Unit,
    onLoginBtnClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current
    val passwordVisualTransformation = remember { PasswordVisualTransformation() }

    Column(
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
                text = "이메일로 로그인",
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(36.dp))

            LetsSoptTextField(
                title = "이메일",
                value = email,
                onValueChange = onEmailChange,
                placeholder = "이메일 주소를 입력하세요",
                modifier = Modifier,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                ),
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
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                    }
                ),
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "아직 계정이 없으신가요? 회원가입",
                modifier = Modifier
                    .noRippleClickable(
                        onClick = onSignUpTxtClick,
                    ),
                color = LETSSOPTTheme.colors.txtSecondary,
                style = LETSSOPTTheme.typography.caption.regular14,
            )

            Spacer(modifier = Modifier.height(20.dp))

            LetsSoptButton(
                btnText = "로그인",
                enabled = true,
                onClick = onLoginBtnClick,
                modifier = Modifier
                    .navigationBarsPadding(),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    LETSSOPTTheme {
        LoginScreen(
            email = email,
            password = password,
            onEmailChange = { email = it },
            onPasswordChange = { password = it },
            onSignUpTxtClick = {},
            onLoginBtnClick = {},
        )
    }
}
