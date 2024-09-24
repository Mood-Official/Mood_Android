package com.android.mood.onboard.login.screen.signupagree

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.android.mood.onboard.login.screen.signupagree.state.AgreeSideEffect
import kotlinx.coroutines.flow.collectLatest

@Composable
internal fun SignupAgreeRoute(
    viewModel: AgreeViewModel = hiltViewModel()
) {

    LaunchedEffect(viewModel) {
        viewModel.sideEffect.collectLatest { sideEffect ->
            when (sideEffect) {
                AgreeSideEffect.Finish -> {}
            }
        }
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    SignupAgreeScreen(state = state)
}