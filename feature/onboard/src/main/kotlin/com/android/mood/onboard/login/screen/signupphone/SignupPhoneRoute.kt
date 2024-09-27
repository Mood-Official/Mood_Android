package com.android.mood.onboard.login.screen.signupphone

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.android.mood.onboard.login.screen.signupphone.state.PhoneIntent
import com.android.mood.onboard.login.screen.signupphone.state.PhoneSideEffect
import kotlinx.coroutines.flow.collectLatest

@Composable
internal fun SignupPhoneRoute(
    navigateToAgree: () -> Unit,
    viewModel: PhoneViewModel = hiltViewModel()
) {

    LaunchedEffect(viewModel) {
        viewModel.sideEffect.collectLatest { sideEffect ->
            when (sideEffect) {
                PhoneSideEffect.NavigateToAgree -> navigateToAgree()
            }
        }
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    SignupPhoneScreen(
        state = state,
        navigateToAgree = { viewModel.intent(PhoneIntent.ClickNextButton) },
        inputPhone = { viewModel.intent(PhoneIntent.InputPhone(it)) },
        inputCertification = { viewModel.intent(PhoneIntent.InputCertificationNumber(it)) },
        validatePhone = { viewModel.intent(PhoneIntent.ValidatePhone(it)) },
        validateCertification = { viewModel.intent(PhoneIntent.ValidateCertificationNumber(it)) }
    )
}