package com.android.mood.onboard.login.mvi

import com.android.mood.common.android.base.UiIntent

sealed class LoginIntent : UiIntent {
    data object ClickLoginButton : LoginIntent()
}