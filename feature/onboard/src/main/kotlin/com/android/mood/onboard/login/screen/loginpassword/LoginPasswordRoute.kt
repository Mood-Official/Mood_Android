package com.android.mood.onboard.login.screen.loginpassword

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.android.mood.designsystem.component.actionbar.ActionBar
import com.android.mood.onboard.login.screen.loginpassword.state.LoginPasswordIntent
import com.android.mood.onboard.login.screen.loginpassword.state.LoginPasswordSideEffect
import kotlinx.coroutines.flow.collectLatest

@Composable
internal fun LoginPasswordRoute(
    navigateToHome: () -> Unit,
    navigateBack: () -> Unit,
    viewModel: LoginPasswordViewModel = hiltViewModel()
) {
    LaunchedEffect(viewModel) {
        viewModel.sideEffect.collectLatest { sideEffect ->
            when (sideEffect) {
                LoginPasswordSideEffect.NavigateToHome -> {
                    navigateToHome()
                }
            }
        }
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            ActionBar(onBack = { navigateBack() })
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            LoginPasswordScreen(
                state = state,
                inputPassword = { viewModel.intent(LoginPasswordIntent.InputPassword(it)) },
                onClick = { viewModel.intent(LoginPasswordIntent.ClickNextButton(it)) }
            )
        }
    }
}