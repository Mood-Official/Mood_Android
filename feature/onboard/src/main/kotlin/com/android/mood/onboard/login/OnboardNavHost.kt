package com.android.mood.onboard.login

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.android.mood.onboard.login.navigation.LOGIN_ROUTE
import com.android.mood.onboard.login.navigation.loginPasswordScreen
import com.android.mood.onboard.login.navigation.loginScreen
import com.android.mood.onboard.login.navigation.navigateToAgree
import com.android.mood.onboard.login.navigation.navigateToLoginPassword
import com.android.mood.onboard.login.navigation.navigateToNickname
import com.android.mood.onboard.login.navigation.navigateToPhone
import com.android.mood.onboard.login.navigation.navigateToSignupPassword
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
        loginScreen(
            navigateToSignupPassword = { navController.navigateToSignupPassword() },
            navigateToLoginPassword = { navController.navigateToLoginPassword() }
        )
        loginPasswordScreen(
            navigateToHome = navigateToHome,
            navigateBack = { navController.popBackStack() }
        )
        signupPasswordScreen(
            navigateToNickname = { navController.navigateToNickname() },
            navigateBack = { navController.popBackStack() }
        )
        signupNicknameScreen(
            navigateToPhone = { navController.navigateToPhone() },
            navigateBack = { navController.popBackStack() }
        )
        signupPhoneScreen(
            navigateToAgree = { navController.navigateToAgree() },
            navigateBack = { navController.popBackStack() }
        )
        signupAgreeScreen(
            navigateToHome = navigateToHome,
            navigateBack = { navController.popBackStack() }
        )
    }
}