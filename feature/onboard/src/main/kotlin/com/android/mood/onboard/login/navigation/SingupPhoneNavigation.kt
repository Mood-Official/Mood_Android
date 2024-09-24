package com.android.mood.onboard.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.mood.onboard.login.screen.signupphone.SignupPhoneRoute

const val SIGNUP_PHONE_ROUTE = "signup_phone"

fun NavController.navigateToPhone() = navigate(SIGNUP_PHONE_ROUTE)

fun NavGraphBuilder.signupPhoneScreen(
    navigateToAgree: () -> Unit,
) {
    composable(
        route = SIGNUP_PHONE_ROUTE,
    ) {
        SignupPhoneRoute(navigateToAgree = navigateToAgree)
    }
}