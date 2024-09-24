package com.android.mood.onboard.login.screen.login.state

import com.android.mood.common.android.base.UiState

data class LoginUiState(
    val email: String,
    val isSuccess: Boolean? = null,
) : UiState {
    companion object {
        private const val BLANK = ""
        val INITIAL_STATE = LoginUiState(
            email = BLANK,
            isSuccess = null,
        )
    }
}