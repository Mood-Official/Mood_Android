package com.android.mood.onboard.login.screen.signupagree.state

import com.android.mood.common.android.base.UiState

data class AgreeUiState(
    val isAllAgree: Boolean = false,
    val age: Boolean = false,
    val service: Boolean = false,
    val privacy: Boolean = false,
    val marketing: Boolean = false,
) : UiState {
    companion object {
        val INITIAL_STATE = AgreeUiState(
            isAllAgree = false,
            age = false,
            service = false,
            privacy = false,
            marketing = false,
        )
    }
}