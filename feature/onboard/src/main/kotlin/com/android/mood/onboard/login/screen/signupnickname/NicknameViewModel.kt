package com.android.mood.onboard.login.screen.signupnickname

import androidx.lifecycle.SavedStateHandle
import com.android.mood.common.android.base.BaseViewModel
import com.android.mood.domain.usecase.validation.ValidateNameUseCase
import com.android.mood.domain.usecase.validation.ValidateNickNameUseCase
import com.android.mood.onboard.login.screen.signupnickname.state.NickNameIntent
import com.android.mood.onboard.login.screen.signupnickname.state.NickNameSideEffect
import com.android.mood.onboard.login.screen.signupnickname.state.NickNameUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NicknameViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val validateNicknameUseCase: ValidateNickNameUseCase,
    private val validateNameUseCase: ValidateNameUseCase,
) : BaseViewModel<NickNameUiState, NickNameSideEffect, NickNameIntent>(savedStateHandle) {

    override fun createInitialState(savedStateHandle: SavedStateHandle): NickNameUiState =
        NickNameUiState.INITIAL_STATE

    override fun handleClientException(throwable: Throwable) {
    }

    override suspend fun handleIntent(intent: NickNameIntent) {
        when (intent) {
            NickNameIntent.ClickNextButton -> postSideEffect(NickNameSideEffect.NavigateToPhone)
            is NickNameIntent.ValidateName -> {
                val result = validateNameUseCase.execute(intent.name)
                reduce {
                    copy(name = intent.name, isNameSuccess = result)
                }
            }

            is NickNameIntent.ValidateBirthday -> {
                reduce {
                    copy(birthday = intent.birthday, isBirthdaySuccess = true)
                }
            }

            is NickNameIntent.ValidateNickName -> {
                val result = validateNicknameUseCase.execute(intent.nickname)
                reduce {
                    copy(nickname = intent.nickname, isNicknameSuccess = result)
                }
            }

            is NickNameIntent.InputName -> reduce { copy(name = intent.name) }
            is NickNameIntent.InputBirthday -> reduce {
                copy(birthday = intent.birthday, isBirthdaySuccess = true)
            }

            is NickNameIntent.InputNickName -> reduce { copy(nickname = intent.nickname) }
        }
    }
}