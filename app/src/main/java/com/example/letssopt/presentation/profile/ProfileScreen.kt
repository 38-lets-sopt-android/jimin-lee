package com.example.letssopt.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.core.designsystem.component.LetsSoptButton
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.presentation.profile.component.ProfileLabeledText

@Composable
fun ProfileRoute(
    modifier: Modifier = Modifier,
) {
    ProfileScreen(
        modifier = modifier,
    )
}


@Composable
fun ProfileScreen(
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
            content = "ㅇㅇ"
        )

        Spacer(modifier = Modifier.height(30.dp))

        ProfileLabeledText(
            label = "이름",
            content = "ㅇㅇ"
        )

        Spacer(modifier = Modifier.height(30.dp))

        ProfileLabeledText(
            label = "이메일",
            content = "ㅇㅇ"
        )

        Spacer(modifier = Modifier.height(30.dp))

        ProfileLabeledText(
            label = "나이",
            content = "ㅇㅇ"
        )

        Spacer(modifier = Modifier.height(30.dp))

        ProfileLabeledText(
            label = "파트",
            content = "ㅇㅇ"
        )

        Spacer(modifier = Modifier.height(30.dp))

        LetsSoptButton(
            btnText = "다른 유저들 보러가기",
            enabled = true,
            onClick = {},
            isAuthScreen = false,
        )

    }

}

@Preview
@Composable
private fun ProfileScreenPreview() {
    LETSSOPTTheme {
        ProfileScreen()
    }
}
