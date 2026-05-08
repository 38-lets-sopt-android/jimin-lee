package com.example.letssopt.presentation.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.presentation.user.component.UserListItem

@Composable
fun UserRoute(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val viewModel: UserViewModel = viewModel(
        factory = UserViewModelFactory(context)
    )

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    UserScreen(
        uiState = uiState,
        modifier = modifier,
    )
}

@Composable
fun UserScreen(
    uiState: UserContract.State,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = LETSSOPTTheme.colors.background,
            )
            .padding(top = 70.dp, bottom = 20.dp)
    ) {

        Text(
            text = "친구들",
            modifier = Modifier.padding(start = 27.dp, bottom = 42.dp),
            color = LETSSOPTTheme.colors.txtPrimary,
            style = LETSSOPTTheme.typography.subhead1.semibold20,
        )

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            item { Spacer(modifier = Modifier.height(100.dp)) }

            items(
                items = uiState.userList,
                key = { user -> user.id }
            ) { user ->
                UserListItem(
                    id = user.id,
                    name = user.name,
                    part = user.part,
                )
            }
        }
    }
}

@Preview
@Composable
private fun UserScreenPreview() {
    LETSSOPTTheme {
        UserScreen(
            uiState = UserContract.State()
        )
    }
}
