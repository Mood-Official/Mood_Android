package com.android.mood.onboard.login.screen.login.state

import com.android.mood.common.android.base.UiSideEffect

sealed class LoginSideEffect : UiSideEffect {
    data object NavigateToSignupPassword : LoginSideEffect()
    data object NavigateToLoginPassword : LoginSideEffect()
}