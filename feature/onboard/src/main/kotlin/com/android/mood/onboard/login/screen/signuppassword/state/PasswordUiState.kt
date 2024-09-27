package com.android.mood.onboard.login.screen.signuppassword.state

import com.android.mood.common.android.base.UiState
import com.android.mood.onboard.login.screen.signupnickname.state.NickNameUiState

data class PasswordUiState(
    val password: String,
    val repeatedPassword: String,
    val isSuccess: Boolean? = null,
    val isRepeatedPasswordSuccess: Boolean? = null
) : UiState {
    companion object {
        private const val BLANK = ""
        val INITIAL_STATE = PasswordUiState(
            password = BLANK,
            repeatedPassword = BLANK,
            isSuccess = null,
            isRepeatedPasswordSuccess = null,
        )
    }
}