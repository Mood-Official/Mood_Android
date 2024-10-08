package com.android.mood.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.android.mood.home.HomeRoute

const val HOME_ROUTE = "home"

fun NavController.navigateToHome(navOptions: NavOptions) = navigate(HOME_ROUTE, navOptions)

fun NavGraphBuilder.homeScreen() {
    composable(
        route = HOME_ROUTE
    ) {
        HomeRoute()
    }
}