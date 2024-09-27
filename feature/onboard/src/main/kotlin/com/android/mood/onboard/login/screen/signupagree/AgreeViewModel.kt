package com.android.mood.onboard.login.screen.signupagree

import androidx.lifecycle.SavedStateHandle
import com.android.mood.common.android.base.BaseViewModel
import com.android.mood.onboard.login.screen.signupagree.state.AgreeIntent
import com.android.mood.onboard.login.screen.signupagree.state.AgreeSideEffect
import com.android.mood.onboard.login.screen.signupagree.state.AgreeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AgreeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<AgreeUiState, AgreeSideEffect, AgreeIntent>(savedStateHandle) {

    override fun createInitialState(savedStateHandle: SavedStateHandle): AgreeUiState =
        AgreeUiState.INITIAL_STATE

    override fun handleClientException(throwable: Throwable) {
    }

    override suspend fun handleIntent(intent: AgreeIntent) {
        when (intent) {
            AgreeIntent.ClickNextButton -> postSideEffect(AgreeSideEffect.Finish)
            is AgreeIntent.ToggleAgreeItem -> {

            }
        }
    }
}