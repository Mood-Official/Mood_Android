package com.android.mood.onboard.login.screen.loginpassword.state

import com.android.mood.common.android.base.UiSideEffect

sealed class LoginPasswordSideEffect : UiSideEffect {
    data object NavigateToHome : LoginPasswordSideEffect()
}