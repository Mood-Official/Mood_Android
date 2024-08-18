package com.android.mood.onboard.login

import com.android.mood.common.android.base.BaseViewModel
import com.android.mood.onboard.login.mvi.LoginIntent
import com.android.mood.onboard.login.mvi.LoginSideEffect
import com.android.mood.onboard.login.mvi.LoginSideEffect.NavigateToSample
import com.android.mood.onboard.login.mvi.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() :
    BaseViewModel<LoginState, LoginSideEffect, LoginIntent>(LoginState()) {

    override suspend fun handleIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.ClickLoginButton -> {
                postSideEffect(NavigateToSample)
            }
        }
    }
}