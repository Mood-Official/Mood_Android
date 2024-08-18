package com.android.mood.onboard.login.navigator

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.android.mood.common.android.extension.getIntent
import com.android.mood.navigator.LoginNavigator
import com.android.mood.onboard.login.OnboardActivity
import javax.inject.Inject

internal class LoginNavigatorImpl @Inject constructor() : LoginNavigator {
    override fun navigateFrom(
        activity: Activity,
        intentBuilder: Intent.() -> Intent,
        withFinish: Boolean,
    ) {
        activity.startActivity(activity.getIntent<OnboardActivity>(intentBuilder))
        if (withFinish) activity.finish()
    }

    override fun navigateResultLauncher(
        launcher: ActivityResultLauncher<Intent>,
        activity: Activity,
        intentBuilder: Intent.() -> Intent,
    ) {
        launcher.launch(activity.getIntent<OnboardActivity>(intentBuilder))
    }

    override fun navigateResultLauncher(
        launcher: ActivityResultLauncher<Intent>,
        context: Context,
        intentBuilder: Intent.() -> Intent,
    ) {
        launcher.launch(context.getIntent<OnboardActivity>(intentBuilder))
    }
}