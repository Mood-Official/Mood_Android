package com.android.mood.feature.sample.navigator

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.android.mood.common.android.extension.getIntent
import com.android.mood.feature.sample.SampleActivity
import com.android.mood.navigator.SampleNavigator
import javax.inject.Inject

internal class SampleNavigatorImpl @Inject constructor(): SampleNavigator {

    override fun navigateFrom(
        activity: Activity,
        intentBuilder: Intent.() -> Intent,
        withFinish: Boolean,
    ) {
        activity.startActivity(activity.getIntent<SampleActivity>(intentBuilder))
        if (withFinish) activity.finish()
    }

    override fun navigateResultLauncher(
        launcher: ActivityResultLauncher<Intent>,
        activity: Activity,
        intentBuilder: Intent.() -> Intent,
    ) {
        launcher.launch(activity.getIntent<SampleActivity>(intentBuilder))
    }

    override fun navigateResultLauncher(
        launcher: ActivityResultLauncher<Intent>,
        context: Context,
        intentBuilder: Intent.() -> Intent,
    ) {
        launcher.launch(context.getIntent<SampleActivity>(intentBuilder))
    }
}