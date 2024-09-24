package com.android.mood.onboard.login.screen.signupnickname.state

import com.android.mood.common.android.base.UiSideEffect

sealed class NickNameSideEffect : UiSideEffect {
    data object NavigateToPhone : NickNameSideEffect()
}