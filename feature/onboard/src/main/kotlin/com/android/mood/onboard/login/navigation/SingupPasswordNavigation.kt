package com.android.mood.onboard.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.mood.onboard.login.screen.signuppassword.SignupPasswordRoute

const val SIGNUP_PASSWORD_ROUTE = "signup_password"

fun NavController.navigateToSignupPassword() = navigate(SIGNUP_PASSWORD_ROUTE)

fun NavGraphBuilder.signupPasswordScreen(
    navigateToNickname: () -> Unit,
    navigateBack: () -> Unit,
) {
    composable(
        route = SIGNUP_PASSWORD_ROUTE,
    ) {
        SignupPasswordRoute(
            navigateToNickname = navigateToNickname,
            navigateBack = navigateBack
        )
    }
}