package com.android.mood.onboard.login.screen.signuppassword.state

import com.android.mood.common.android.base.UiIntent
import com.android.mood.onboard.login.screen.signupnickname.state.NickNameIntent

sealed class PasswordIntent : UiIntent {
    data object ClickNextButton : PasswordIntent()
    data class ValidatePassword(val password: String) : PasswordIntent()
    data class ValidateRepeatedPassword(val password: String, val repeatedPassword: String) : PasswordIntent()
}