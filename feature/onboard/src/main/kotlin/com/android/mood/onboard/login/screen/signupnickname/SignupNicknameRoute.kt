package com.android.mood.onboard.login.screen.signupnickname

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
import com.android.mood.onboard.login.screen.signupnickname.state.NickNameIntent
import com.android.mood.onboard.login.screen.signupnickname.state.NickNameSideEffect
import kotlinx.coroutines.flow.collectLatest

@Composable
internal fun SignupNicknameRoute(
    navigateToPhone: () -> Unit,
    navigateBack: () -> Unit,
    viewModel: NicknameViewModel = hiltViewModel()
) {

    LaunchedEffect(viewModel) {
        viewModel.sideEffect.collectLatest { sideEffect ->
            when (sideEffect) {
                NickNameSideEffect.NavigateToPhone -> navigateToPhone()
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
            SignupNicknameScreen(
                state = state,
                navigateToPhone = { viewModel.intent(NickNameIntent.ClickNextButton) },
                validateName = { viewModel.intent(NickNameIntent.ValidateName(it)) },
                validateBirthday = { viewModel.intent(NickNameIntent.ValidateBirthday(it)) },
                validateNickName = { viewModel.intent(NickNameIntent.ValidateNickName(it)) },
                inputName = { viewModel.intent(NickNameIntent.InputName(it)) },
                inputBirthday = { viewModel.intent(NickNameIntent.InputBirthday(it)) },
                inputNickName = { viewModel.intent(NickNameIntent.InputNickName(it)) },
            )
        }
    }
}