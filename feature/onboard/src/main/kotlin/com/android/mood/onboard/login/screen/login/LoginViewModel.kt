package com.android.mood.onboard.login.screen.login

import androidx.lifecycle.SavedStateHandle
import com.android.mood.common.android.base.BaseViewModel
import com.android.mood.domain.usecase.validation.ValidateEmailUseCase
import com.android.mood.onboard.login.screen.login.state.LoginIntent
import com.android.mood.onboard.login.screen.login.state.LoginSideEffect
import com.android.mood.onboard.login.screen.login.state.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val validateEmailUseCase: ValidateEmailUseCase,
) : BaseViewModel<LoginUiState, LoginSideEffect, LoginIntent>(savedStateHandle) {

    override fun createInitialState(savedStateHandle: SavedStateHandle): LoginUiState =
        LoginUiState.INITIAL_STATE

    override suspend fun handleIntent(intent: LoginIntent) {
        when (intent) {
            LoginIntent.ClickEmailButton -> postSideEffect(LoginSideEffect.NavigateToPassword)
            is LoginIntent.ClickSnsButton -> {}
            LoginIntent.ClickFindId -> {}
            LoginIntent.ClickFindPassword -> {}
            is LoginIntent.ValidateEmail -> reduce {
                copy(
                    email = intent.email,
                    isSuccess = validateEmailUseCase.execute(intent.email)
                )
            }
        }
    }

    override fun handleClientException(throwable: Throwable) {
    }
}