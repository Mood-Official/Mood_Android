package com.android.mood.onboard.login.screen.signupphone.state

import com.android.mood.common.android.base.UiState

data class PhoneUiState(
    val phone: String,
    val certificationNumber: String,
    val isSuccess: Boolean? = null,
    val isCertificationSuccess: Boolean? = null,
) : UiState {
    companion object {
        private const val BLANK = ""
        val INITIAL_STATE = PhoneUiState(
            phone = BLANK,
            isSuccess = null,
            certificationNumber = "",
            isCertificationSuccess = null,
        )
    }
}