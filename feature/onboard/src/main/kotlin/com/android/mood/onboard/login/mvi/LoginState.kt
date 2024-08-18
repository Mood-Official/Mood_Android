package com.android.mood.onboard.login.mvi

import com.android.mood.common.android.base.UiState

data class LoginState(
    val isLoading: Boolean = true,
): UiState