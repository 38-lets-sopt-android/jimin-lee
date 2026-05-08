package com.example.letssopt.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.core.designsystem.component.LetsSoptButton
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.presentation.profile.component.ProfileLabeledText

@Composable
fun ProfileRoute(
    navigateToUser: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val viewModel: ProfileViewModel = viewModel(
        factory = ProfileViewModelFactory(context)
    )
    
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ProfileScreen(
        uiState = uiState,
        navigateToUser = navigateToUser,
        modifier = modifier,
    )
}


@Composable
fun ProfileScreen(
    uiState: ProfileContract.State,
    navigateToUser: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = LETSSOPTTheme.colors.background,
            )
            .padding(top = 70.dp)
            .padding(horizontal = 20.dp),
    ) {
        Text(
            text = "프로필",
            modifier = Modifier.padding(start = 7.dp),
            color = LETSSOPTTheme.colors.txtPrimary,
            style = LETSSOPTTheme.typography.subhead1.semibold20,
        )

        Spacer(modifier = Modifier.height(68.dp))

        ProfileLabeledText(
            label = "아이디",
            content = uiState.id
        )

        Spacer(modifier = Modifier.height(30.dp))

        ProfileLabeledText(
            label = "이름",
            content = uiState.name
        )

        Spacer(modifier = Modifier.height(30.dp))

        ProfileLabeledText(
            label = "이메일",
            content = uiState.email
        )

        Spacer(modifier = Modifier.height(30.dp))

        ProfileLabeledText(
            label = "나이",
            content = uiState.age
        )

        Spacer(modifier = Modifier.height(30.dp))

        ProfileLabeledText(
            label = "파트",
            content = uiState.part
        )

        Spacer(modifier = Modifier.height(30.dp))

        LetsSoptButton(
            btnText = "다른 유저들 보러가기",
            enabled = true,
            onClick = navigateToUser,
            isAuthScreen = false,
        )

    }

}

@Preview
@Composable
private fun ProfileScreenPreview() {
    LETSSOPTTheme {
        ProfileScreen(
            uiState = ProfileContract.State(),
            navigateToUser = {},
        )
    }
}
