package com.android.mood.onboard.login.screen.loginpassword.state

import com.android.mood.common.android.base.UiIntent

sealed class LoginPasswordIntent : UiIntent {
    data class ClickNextButton(val password: String) : LoginPasswordIntent()
    data class InputPassword(val password: String) : LoginPasswordIntent()
}