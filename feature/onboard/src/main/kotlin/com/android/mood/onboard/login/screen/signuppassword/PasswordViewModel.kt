package com.android.mood.onboard.login.screen.signuppassword

import androidx.lifecycle.SavedStateHandle
import com.android.mood.common.android.base.BaseViewModel
import com.android.mood.domain.usecase.validation.ValidatePasswordUseCase
import com.android.mood.onboard.login.screen.signuppassword.state.PasswordIntent
import com.android.mood.onboard.login.screen.signuppassword.state.PasswordSideEffect
import com.android.mood.onboard.login.screen.signuppassword.state.PasswordUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PasswordViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
) : BaseViewModel<PasswordUiState, PasswordSideEffect, PasswordIntent>(savedStateHandle) {

    override fun createInitialState(savedStateHandle: SavedStateHandle): PasswordUiState =
        PasswordUiState.INITIAL_STATE

    override suspend fun handleIntent(intent: PasswordIntent) {
        when (intent) {
            PasswordIntent.ClickNextButton -> postSideEffect(PasswordSideEffect.NavigateToName)
            is PasswordIntent.ValidatePassword -> reduce {
                val isSuccess = validatePasswordUseCase.execute(intent.password)
                copy(
                    password = intent.password,
                    repeatedPassword = currentState.repeatedPassword,
                    isSuccess = isSuccess,
                )
            }

            is PasswordIntent.ValidateRepeatedPassword -> reduce {
                val isSuccess = validatePasswordUseCase.checkRepeatedPassword(
                    password = currentState.password,
                    repeatedPassword = intent.repeatedPassword
                )
                copy(
                    password = currentState.password,
                    repeatedPassword = intent.repeatedPassword,
                    isRepeatedPasswordSuccess = isSuccess,
                )
            }
        }
    }

    override fun handleClientException(throwable: Throwable) {
    }
}