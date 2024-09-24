package com.android.mood.onboard.login.screen.signuppassword.state

import com.android.mood.common.android.base.UiSideEffect
import com.android.mood.onboard.login.screen.signupnickname.state.NickNameSideEffect

sealed class PasswordSideEffect : UiSideEffect {
    data object NavigateToName : PasswordSideEffect()
}