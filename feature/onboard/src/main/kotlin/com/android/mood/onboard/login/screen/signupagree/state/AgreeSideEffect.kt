package com.android.mood.onboard.login.screen.signupagree.state

import com.android.mood.common.android.base.UiSideEffect

sealed class AgreeSideEffect : UiSideEffect {
    data object Finish : AgreeSideEffect()
}