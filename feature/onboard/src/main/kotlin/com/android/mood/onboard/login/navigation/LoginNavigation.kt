package com.android.mood.onboard.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.mood.onboard.login.screen.login.LoginRoute

const val LOGIN_ROUTE = "login"

fun NavGraphBuilder.loginScreen(
    navigateToPassword: () -> Unit
) {
    composable(
        route = LOGIN_ROUTE
    ) {
        LoginRoute(
            navigateToPassword = navigateToPassword
        )
    }
}