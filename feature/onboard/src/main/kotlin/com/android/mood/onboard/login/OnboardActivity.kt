package com.android.mood.onboard.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.android.mood.designsystem.foundation.MoodTheme
import com.android.mood.navigator.MainNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnboardActivity : ComponentActivity() {
    @Inject
    lateinit var mainNavigator: MainNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoodTheme {
                val navController = rememberNavController()
                OnboardNavHost(
                    modifier = Modifier.fillMaxSize(),
                    navController = navController,
                    navigateToHome = { mainNavigator.navigateFrom(this@OnboardActivity) }
                )
            }
        }
    }
}