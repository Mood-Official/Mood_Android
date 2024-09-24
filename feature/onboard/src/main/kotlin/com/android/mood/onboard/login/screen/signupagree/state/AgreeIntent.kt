package com.android.mood.onboard.login.screen.signupagree.state

import com.android.mood.common.android.base.UiIntent

sealed class AgreeIntent : UiIntent {
    data object ClickNextButton : AgreeIntent()
    data class ToggleAgreeItem(
        val isAllAgree: Boolean,
        val age: Boolean,
        val service: Boolean,
        val privacy: Boolean,
        val marketing: Boolean
    ) : AgreeIntent()
}
