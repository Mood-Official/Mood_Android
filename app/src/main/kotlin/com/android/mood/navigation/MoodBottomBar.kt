package com.android.mood.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.android.mood.designsystem.component.tabbar.MoodNavigationBar
import com.android.mood.designsystem.component.tabbar.MoodNavigationBarItem

@Composable
fun MoodBottomBar(
    modifier: Modifier = Modifier,
    destinations: List<MoodTopDestination> = MoodTopDestination.entries,
    navigateToDestination: (MoodTopDestination) -> Unit,
    currentDestination: NavDestination?,
) {
    MoodNavigationBar(
        modifier = modifier.fillMaxWidth(),
    ) {
        destinations.forEach { destination ->
            val isSelected = currentDestination.isTopLevelDestinationInHierarchy(destination)

            MoodNavigationBarItem(
                modifier = Modifier,
                isSelected = isSelected,
                onClick = { navigateToDestination(destination) },
                selectedIcon = destination.selectedIcon,
                unselectedIcon = destination.unselectedIcon
            )
        }
    }
}

@Preview
@Composable
private fun MoodBottomBarPreview() {
    val navController = rememberNavController()
    Scaffold(
        scaffoldState = rememberScaffoldState(),
        bottomBar = {
            MoodBottomBar(
                navigateToDestination = {},
                currentDestination = navController.currentBackStackEntryAsState().value?.destination
            )
        },
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {

        }
    }
}