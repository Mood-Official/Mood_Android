package com.android.mood.onboard.login.screen.login.state

import com.android.mood.common.android.base.UiIntent

sealed class LoginIntent : UiIntent {
    data object ClickEmailButton : LoginIntent()
    data class ClickSnsButton(val type: String) : LoginIntent()
    data object ClickFindId : LoginIntent()
    data object ClickFindPassword : LoginIntent()
    data class ValidateEmail(val email: String) : LoginIntent()
}