package com.android.mood.meet.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.android.mood.meet.MeetRoute

const val MEET_ROUTE = "meet"

fun NavController.navigateToMeet(navOptions: NavOptions) = navigate(MEET_ROUTE, navOptions)

fun NavGraphBuilder.MeetScreen() {
    composable(
        route = MEET_ROUTE
    ) {
        MeetRoute()
    }
}