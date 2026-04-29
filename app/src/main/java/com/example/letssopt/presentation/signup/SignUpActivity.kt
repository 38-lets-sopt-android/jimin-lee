package com.example.letssopt.presentation.signup

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
import com.example.letssopt.core.extension.toast
import com.example.letssopt.core.utils.PreferencesUtil

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            LETSSOPTTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = WindowInsets(),
                ) { innerPadding ->
                    SignUpRoute(
                        onSignUpSuccess = {
                            setResult(RESULT_OK)
                            finish()
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
fun SignUpRoute(
    onSignUpSuccess: () -> Unit,
    onShowToast: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = viewModel(),
) {
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val prefs = PreferencesUtil(context)

    SignUpScreen(
        isBtnEnabled = viewModel.isBtnEnabled,
        email = uiState.email,
        password = uiState.password,
        passwordConfirm = uiState.passwordConfirm,
        onEmailChange = viewModel::updateEmailText,
        onPasswordChange = viewModel::updatePasswordText,
        onPasswordConfirmChange = viewModel::updatePasswordConfirmText,
        onSignUpBtnClick = {
            viewModel.checkValidation(
                onFailure = onShowToast,
                onSuccess = {
                    prefs.setUserInfo(
                        email = uiState.email,
                        password = uiState.password,
                    )
                    onShowToast("회원가입이 완료되었습니다")
                    onSignUpSuccess()
                },
            )
        },
        modifier = modifier,
    )
}

@Composable
private fun SignUpScreen(
    isBtnEnabled: Boolean,
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
            isBtnEnabled = true,
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
