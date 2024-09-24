package com.android.mood.onboard.login.screen.signupnickname.state

import com.android.mood.common.android.base.UiState

data class NickNameUiState(
    val name: String,
    val birthday: String,
    val nickname: String,
    val isNameSuccess: Boolean? = null,
    val isBirthdaySuccess: Boolean? = null,
    val isNicknameSuccess: Boolean? = null,
) : UiState {
    companion object {
        private const val BLANK = ""
        val INITIAL_STATE = NickNameUiState(
            name = BLANK,
            birthday = BLANK,
            nickname = BLANK,
            isNameSuccess = null,
            isBirthdaySuccess = null,
            isNicknameSuccess = null,
        )
    }
}