package com.android.mood.common.android.extension

import android.app.Activity
import android.content.Context
import android.content.Intent

inline fun <reified T : Activity> Context.getIntent(
    intentBuilder: Intent.() -> Intent = { this },
): Intent {
    return intentBuilder(Intent(this, T::class.java))
}