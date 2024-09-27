package com.android.mood.onboard.login

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.android.mood.onboard.login.navigation.LOGIN_ROUTE
import com.android.mood.onboard.login.navigation.loginScreen
import com.android.mood.onboard.login.navigation.navigateToAgree
import com.android.mood.onboard.login.navigation.navigateToNickname
import com.android.mood.onboard.login.navigation.navigateToPassword
import com.android.mood.onboard.login.navigation.navigateToPhone
import com.android.mood.onboard.login.navigation.signupAgreeScreen
import com.android.mood.onboard.login.navigation.signupNicknameScreen
import com.android.mood.onboard.login.navigation.signupPasswordScreen
import com.android.mood.onboard.login.navigation.signupPhoneScreen

@Composable
fun OnboardNavHost(
    modifier: Modifier = Modifier,
    startDestination: String = LOGIN_ROUTE,
    navController: NavHostController,
    navigateToHome: () -> Unit,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        loginScreen(navigateToPassword = { navController.navigateToPassword() })
        signupPasswordScreen(navigateToNickname = { navController.navigateToNickname() })
        signupNicknameScreen(navigateToPhone = { navController.navigateToPhone() })
        signupPhoneScreen(navigateToAgree = { navController.navigateToAgree() })
        signupAgreeScreen(navigateToHome = navigateToHome)
    }
}