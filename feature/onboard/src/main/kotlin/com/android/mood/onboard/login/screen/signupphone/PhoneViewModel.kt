package com.android.mood.onboard.login.screen.signupphone

import android.util.Patterns
import androidx.lifecycle.SavedStateHandle
import com.android.mood.common.android.base.BaseViewModel
import com.android.mood.onboard.login.screen.signupphone.state.PhoneIntent
import com.android.mood.onboard.login.screen.signupphone.state.PhoneSideEffect
import com.android.mood.onboard.login.screen.signupphone.state.PhoneUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhoneViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<PhoneUiState, PhoneSideEffect, PhoneIntent>(savedStateHandle) {

    override fun createInitialState(savedStateHandle: SavedStateHandle): PhoneUiState =
        PhoneUiState.INITIAL_STATE

    override suspend fun handleIntent(intent: PhoneIntent) {
        when (intent) {
            PhoneIntent.ClickNextButton -> postSideEffect(
                PhoneSideEffect.NavigateToAgree
            )

            is PhoneIntent.ValidateCertificationNumber -> {
                // TODO 인증번호 서버와 통신을 통해 확인해서 다음으로 넘어갈 수 있도록 개발하기
                reduce {
                    copy(
                        certificationNumber = intent.certificationNumber,
                        isCertificationSuccess = true
                    )
                }
            }

            is PhoneIntent.InputPhone -> reduce {
                if (intent.phone == "") copy(phone = intent.phone, isSuccess = null)
                else copy(phone = intent.phone)
            }

            is PhoneIntent.InputCertificationNumber -> reduce {
                if (intent.certificationNumber == "") copy(
                    certificationNumber = intent.certificationNumber,
                    isSuccess = null
                )
                else copy(certificationNumber = intent.certificationNumber)
            }

            is PhoneIntent.ValidatePhone -> reduce {
                val result = Patterns.PHONE.matcher(intent.phone).matches()
                copy(phone = intent.phone, isSuccess = result)
            }
        }
    }

    override fun handleClientException(throwable: Throwable) {
    }
}