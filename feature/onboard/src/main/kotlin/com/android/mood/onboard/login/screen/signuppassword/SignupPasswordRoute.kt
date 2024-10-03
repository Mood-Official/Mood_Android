package com.android.mood.onboard.login.screen.signuppassword

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
import com.android.mood.onboard.login.screen.signuppassword.state.PasswordIntent
import com.android.mood.onboard.login.screen.signuppassword.state.PasswordSideEffect
import kotlinx.coroutines.flow.collectLatest

@Composable
internal fun SignupPasswordRoute(
    navigateToNickname: () -> Unit,
    navigateBack: () -> Unit,
    viewModel: PasswordViewModel = hiltViewModel()
) {
    LaunchedEffect(viewModel) {
        viewModel.sideEffect.collectLatest { sideEffect ->
            when (sideEffect) {
                PasswordSideEffect.NavigateToName -> navigateToNickname()
            }
        }
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            ActionBar(onBack = { navigateBack() }, title = "회원가입")
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            SignupPasswordScreen(
                state = state,
                navigateToNickname = { viewModel.intent(PasswordIntent.ClickNextButton) },
                validatePassword = { password ->
                    viewModel.intent(
                        PasswordIntent.ValidatePassword(
                            password
                        )
                    )
                },
                validateRepeatedPassword = { password, repeatedPassword ->
                    viewModel.intent(
                        PasswordIntent.ValidateRepeatedPassword(
                            password,
                            repeatedPassword
                        )
                    )
                },
            )
        }
    }
}