package com.android.mood.onboard.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.mood.onboard.login.screen.signupnickname.SignupNicknameRoute
import com.android.mood.onboard.login.screen.signuppassword.SignupPasswordRoute

const val SIGNUP_NICKNAME_ROUTE = "signup_nickname"

fun NavController.navigateToNickname() = navigate(SIGNUP_NICKNAME_ROUTE)

fun NavGraphBuilder.signupNicknameScreen(
    navigateToPhone: () -> Unit,
) {
    composable(
        route = SIGNUP_NICKNAME_ROUTE,
    ) {
        SignupNicknameRoute(
            navigateToPhone = navigateToPhone
        )
    }
}