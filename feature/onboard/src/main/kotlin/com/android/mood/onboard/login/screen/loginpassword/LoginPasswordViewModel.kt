package com.android.mood.onboard.login.screen.loginpassword

import androidx.lifecycle.SavedStateHandle
import com.android.mood.common.android.base.BaseViewModel
import com.android.mood.domain.usecase.validation.ValidatePasswordUseCase
import com.android.mood.onboard.login.screen.loginpassword.state.LoginPasswordIntent
import com.android.mood.onboard.login.screen.loginpassword.state.LoginPasswordSideEffect
import com.android.mood.onboard.login.screen.loginpassword.state.LoginPasswordUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginPasswordViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
) : BaseViewModel<LoginPasswordUiState, LoginPasswordSideEffect, LoginPasswordIntent>(
    savedStateHandle
) {

    override fun createInitialState(savedStateHandle: SavedStateHandle): LoginPasswordUiState =
        LoginPasswordUiState.INITIAL_STATE

    override suspend fun handleIntent(intent: LoginPasswordIntent) {
        when (intent) {
            is LoginPasswordIntent.ClickNextButton -> {
                reduce {
                    val isSuccess = validatePasswordUseCase.execute(intent.password)
                    if (isSuccess) postSideEffect(LoginPasswordSideEffect.NavigateToHome)
                    copy(
                        password = intent.password,
                        isSuccess = isSuccess,
                    )
                }
            }

            is LoginPasswordIntent.InputPassword -> reduce {
                copy(
                    password = intent.password
                )
            }
        }
    }

    override fun handleClientException(throwable: Throwable) {
    }
}