package com.android.mood.designsystem.foundation

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

internal val LocalMoodColor = staticCompositionLocalOf { MoodColor() }

class MoodColor {
    // Common
    val white = Color(0xFFFFFFFF)
    val black = Color(0xFF000000)
    val transparent = Color(0x00FFFFFF)

    // Primary
    val primary025 = Color(0xFFEDF4FF)
    val primary100 = Color(0xFFC8DEFE)
    val primary200 = Color(0xFF98C1FF)
    val primary300 = Color(0xFF6EA5FF)
    val primary400 = Color(0xFF428BFE)
    val primary500 = Color(0xFF0364FF)
    val primary600 = Color(0xFF0749DC)
    val primary700 = Color(0xFF0431AE)
    val primary800 = Color(0xFF051A75)
    val primary900 = Color(0xFF041143)
    val primaryNormal = Color(0xFF0066FF)

    val secondary500 = Color(0xFF28C596)


    // Secondary
    val rubyRed = Color(0xFFFF2C55)
    val apricotOrange = Color(0xFFFF9500)
    val lemonYellow = Color(0xFFFBFC72)
    val spearMint = Color(0xFF35E3B9)
    val skyBlue = Color(0xFF6FD3FB)
    val cornflowerBlue = Color(0xFF68ADFF)
    val azureBlue = Color(0xFF007AFF)

    // Gray
    val gray50 = Color(0xFFF8FAFD)
    val gray75 = Color(0xFFF1F5FA)
    val gray100 = Color(0xFFE9EEF5)
    val gray200 = Color(0xFFDFE5ED)
    val gray300 = Color(0xFFCBD1DB)
    val gray400 = Color(0xFFA6B1BD)
    val gray500 = Color(0xFF8E98A4)
    val gray600 = Color(0xFF798491)
    val gray700 = Color(0xFF586370)
    val gray800 = Color(0xFF424B57)
    val gray850 = Color(0xFF333B45)
    val gray900 = Color(0xFF15191E)
    val gray950 = Color(0xFF0A0D0F)

    val gradient: Brush = kotlin.run {
        val start = Color(0xFFFB4760)
        val end = Color(0xFFFE1EA4)
        Brush.horizontalGradient(colors = listOf(start, end))
    }
}