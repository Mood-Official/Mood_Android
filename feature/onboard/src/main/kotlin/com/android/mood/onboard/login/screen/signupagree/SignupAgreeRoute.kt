package com.android.mood.onboard.login.screen.signupagree

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
import com.android.mood.onboard.login.screen.signupagree.state.AgreeIntent
import com.android.mood.onboard.login.screen.signupagree.state.AgreeSideEffect
import kotlinx.coroutines.flow.collectLatest

@Composable
internal fun SignupAgreeRoute(
    viewModel: AgreeViewModel = hiltViewModel(),
    navigateBack: () -> Unit,
    navigateToHome: () -> Unit,
) {

    LaunchedEffect(viewModel) {
        viewModel.sideEffect.collectLatest { sideEffect ->
            when (sideEffect) {
                AgreeSideEffect.Finish -> navigateToHome()
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
            SignupAgreeScreen(
                state = state,
                navigateToHome = { viewModel.intent(AgreeIntent.ClickNextButton) },
                toggleAgreeItem = { isAllAgree: Boolean, age: Boolean, service: Boolean, privacy: Boolean, marketing: Boolean ->
                    viewModel.intent(
                        AgreeIntent.ToggleAgreeItem(
                            isAllAgree,
                            age,
                            service,
                            privacy,
                            marketing
                        )
                    )
                }
            )
        }
    }
}