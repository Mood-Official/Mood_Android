package com.android.mood.navigation

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.android.mood.designsystem.foundation.MoodIcon
import com.android.mood.core.designsystem.R as designSystemR

enum class MoodTopDestination(
    val selectedIcon: @Composable () -> Unit,
    val unselectedIcon: @Composable () -> Unit,
    @StringRes val textLabelId: Int,
) {
    HOME(
        selectedIcon = { MoodIcon.Home(tint = Color.Blue) },
        unselectedIcon = { MoodIcon.Home() },
        textLabelId = designSystemR.string.home
    ),
    MEET(
        selectedIcon = { MoodIcon.Home(tint = Color.Blue) },
        unselectedIcon = { MoodIcon.Home() },
        textLabelId = designSystemR.string.meet
    )
}

fun NavDestination?.isTopLevelDestinationInHierarchy(destination: MoodTopDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false