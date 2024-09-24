package com.android.mood.onboard.login.screen.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.android.mood.onboard.login.screen.login.state.LoginIntent
import com.android.mood.onboard.login.screen.login.state.LoginSideEffect
import kotlinx.coroutines.flow.collectLatest

@Composable
internal fun LoginRoute(
    navigateToPassword: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    LaunchedEffect(viewModel) {
        viewModel.sideEffect.collectLatest { sideEffect ->
            when (sideEffect) {
                LoginSideEffect.NavigateToPassword -> navigateToPassword()
            }
        }
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    LoginScreen(
        state = state,
        validateEmail = { viewModel.intent(LoginIntent.ValidateEmail(it)) },
        navigateToPassword = { viewModel.intent(LoginIntent.ClickEmailButton) }
    )
}