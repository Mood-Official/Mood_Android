package com.android.mood.onboard.login.screen.loginpassword.state

import com.android.mood.common.android.base.UiState

data class LoginPasswordUiState(
    val password: String,
    val isSuccess: Boolean? = null,
) : UiState {
    companion object {
        private const val BLANK = ""
        val INITIAL_STATE = LoginPasswordUiState(
            password = BLANK,
            isSuccess = null,
        )
    }
}