package com.example.letssopt.presentation.login

import android.content.Intent
import android.os.Bundle
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.core.designsystem.component.LetsSoptButton
import com.example.letssopt.core.designsystem.component.LetsSoptTextField
import com.example.letssopt.core.designsystem.component.text.LogoText
import com.example.letssopt.core.designsystem.component.text.ScreenText
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.core.extension.noRippleClickable
import com.example.letssopt.core.extension.toast
import com.example.letssopt.core.utils.PreferencesUtil
import com.example.letssopt.presentation.login.LoginContract.LoginResult
import com.example.letssopt.presentation.main.MainActivity
import com.example.letssopt.presentation.signup.SignUpActivity

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = WindowInsets(),
                ) { innerPadding ->
                    LoginRoute(
                        onSignUpTxtClick = {
                            val intent = Intent(this, SignUpActivity::class.java)
                            startActivity(intent)
                        },
                        onLoginSuccess = {
                            val intent = Intent(this, MainActivity::class.java).apply {
                                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                            }
                            startActivity(intent)
                        },
                        onShowToast = { toast(it) },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
private fun LoginRoute(
    onSignUpTxtClick: () -> Unit,
    onLoginSuccess: () -> Unit,
    onShowToast: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = viewModel()
) {
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val prefs = PreferencesUtil(context)
    val savedUserInfo = prefs.getUserInfo()

    LoginScreen(
        email = uiState.email,
        password = uiState.password,
        onEmailChange = viewModel::updateEmailText,
        onPasswordChange = viewModel::updatePasswordText,
        onSignUpTxtClick = onSignUpTxtClick,
        onLoginBtnClick = {
            when(viewModel.validateLogin(savedUserInfo = savedUserInfo)) {
                LoginResult.EmptyFailure -> {
                    onShowToast("아이디와 비밀번호를 입력해주세요")
                }
                LoginResult.InvalidFailure -> {
                    onShowToast("아이디 또는 비밀번호가 일치하지 않습니다")
                }
                LoginResult.Success -> {
                    onShowToast("로그인에 성공했습니다")
                    onLoginSuccess()
                }
            }
        },
        modifier = modifier,
    )
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
