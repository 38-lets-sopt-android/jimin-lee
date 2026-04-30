package com.example.letssopt.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.core.designsystem.component.LetsSoptButton
import com.example.letssopt.core.designsystem.component.LetsSoptTextField
import com.example.letssopt.core.designsystem.component.text.LogoText
import com.example.letssopt.core.designsystem.component.text.ScreenText
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.core.extension.noRippleClickable
import com.example.letssopt.core.extension.toast
import com.example.letssopt.core.utils.PreferencesUtil
import com.example.letssopt.presentation.login.LoginContract.SideEffect.NavigateToHome
import com.example.letssopt.presentation.login.LoginContract.SideEffect.NavigateToSignUp
import com.example.letssopt.presentation.login.LoginContract.SideEffect.OnShowToast

@Composable
fun LoginRoute(
    navigateToSignUp: () -> Unit,
    navigateToHome: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = viewModel()
) {
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val lifecycleOwner = LocalLifecycleOwner.current

    val prefs = PreferencesUtil(context)
    val savedUserInfo = prefs.getUserInfo()

    LaunchedEffect(Unit) {
        lifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            viewModel.sideEffect.collect { effect ->
                when (effect) {
                    is OnShowToast -> {
                        context.toast(effect.message)
                    }
                    NavigateToHome -> navigateToHome()
                    NavigateToSignUp -> navigateToSignUp()
                }
            }
        }
    }

    LoginScreen(
        email = uiState.email,
        password = uiState.password,
        onEmailChange = viewModel::updateEmailText,
        onPasswordChange = viewModel::updatePasswordText,
        onSignUpTxtClick = navigateToSignUp,
        onLoginBtnClick = { viewModel.validateLogin(savedUserInfo) },
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
                style = LETSSOPTTheme.typography.caption1.regular14,
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
