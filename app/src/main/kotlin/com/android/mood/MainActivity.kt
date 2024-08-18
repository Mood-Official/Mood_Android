package com.android.mood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.android.mood.designsystem.foundation.MoodTheme
import com.android.mood.navigation.MoodBottomBar
import com.android.mood.navigation.MoodNavHost
import com.android.mood.navigation.navigateToTopLevelDestination

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoodTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        MoodBottomBar(
                            navigateToDestination = { navController.navigateToTopLevelDestination(it) },
                            currentDestination = navController.currentBackStackEntryAsState().value?.destination
                        )
                    },
                    scaffoldState = scaffoldState
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        MoodNavHost(
                            navController = navController,
                        )
                    }
                }
            }
        }
    }
}