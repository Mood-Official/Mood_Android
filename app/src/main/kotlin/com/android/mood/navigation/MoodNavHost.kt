package com.android.mood.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import com.android.mood.home.navigation.HOME_ROUTE
import com.android.mood.home.navigation.homeScreen
import com.android.mood.home.navigation.navigateToHome
import com.android.mood.meet.navigation.MeetScreen
import com.android.mood.meet.navigation.navigateToMeet

@Composable
fun MoodNavHost(
    modifier: Modifier = Modifier,
    startDestination: String = HOME_ROUTE,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        homeScreen()
        MeetScreen()
    }
}

fun NavHostController.navigateToTopLevelDestination(topLevelDestination: MoodTopDestination) {
    val topLevelNavOptions = navOptions {
        popUpTo(this@navigateToTopLevelDestination.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

    when (topLevelDestination) {
        MoodTopDestination.HOME ->
            this@navigateToTopLevelDestination.navigateToHome(topLevelNavOptions)

        MoodTopDestination.MEET ->
            this@navigateToTopLevelDestination.navigateToMeet(topLevelNavOptions)
    }
}