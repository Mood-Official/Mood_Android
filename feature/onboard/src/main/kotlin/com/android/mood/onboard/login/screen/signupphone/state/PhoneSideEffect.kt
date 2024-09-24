package com.android.mood.onboard.login.screen.signupphone.state

import com.android.mood.common.android.base.UiSideEffect

sealed class PhoneSideEffect : UiSideEffect {
    data object NavigateToAgree : PhoneSideEffect()
}