package com.android.mood.onboard.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.mood.onboard.login.screen.loginpassword.LoginPasswordRoute

const val LOGIN_PASSWORD_ROUTE = "login_password"

fun NavController.navigateToLoginPassword() = navigate(LOGIN_PASSWORD_ROUTE)

fun NavGraphBuilder.loginPasswordScreen(
    navigateToHome: () -> Unit,
    navigateBack: () -> Unit
) {
    composable(
        route = LOGIN_PASSWORD_ROUTE
    ) {
        LoginPasswordRoute(
            navigateToHome = navigateToHome,
            navigateBack = navigateBack,
        )
    }
}