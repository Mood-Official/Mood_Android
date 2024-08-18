package com.android.mood.onboard.login.mvi

import com.android.mood.common.android.base.UiSideEffect

sealed class LoginSideEffect : UiSideEffect {
    data object NavigateToSample : LoginSideEffect()
}