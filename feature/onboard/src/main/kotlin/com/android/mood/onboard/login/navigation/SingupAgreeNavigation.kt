package com.android.mood.onboard.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.mood.onboard.login.screen.signupagree.SignupAgreeRoute

const val SIGNUP_AGREE_ROUTE = "signup_agree"

fun NavController.navigateToAgree() = navigate(SIGNUP_AGREE_ROUTE)

fun NavGraphBuilder.signupAgreeScreen() {
    composable(
        route = SIGNUP_AGREE_ROUTE,
    ) {
        SignupAgreeRoute()
    }
}