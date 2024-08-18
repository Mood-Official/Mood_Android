package com.android.mood.designsystem.foundation

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

internal val LocalMoodColor = staticCompositionLocalOf { MoodColor() }

class MoodColor {
    // Common
    internal val white = Color(0xFFFFFFFF)
    internal val black = Color(0xFF000000)

    // Primary
    internal val primary025 = Color(0xFFEDF4FF)
    internal val primary100 = Color(0xFFC8DEFE)
    internal val primary200 = Color(0xFF98C1FF)
    internal val primary300 = Color(0xFF6EA5FF)
    internal val primary400 = Color(0xFF428BFE)
    internal val primary500 = Color(0xFF0364FF)
    internal val primary600 = Color(0xFF0749DC)
    internal val primary700 = Color(0xFF0431AE)
    internal val primary800 = Color(0xFF051A75)
    internal val primary900 = Color(0xFF041143)


    // Secondary
    internal val rubyRed = Color(0xFFFF2C55)
    internal val apricotOrange = Color(0xFFFF9500)
    internal val lemonYellow = Color(0xFFFBFC72)
    internal val spearMint = Color(0xFF35E3B9)
    internal val skyBlue = Color(0xFF6FD3FB)
    internal val cornflowerBlue = Color(0xFF68ADFF)
    internal val azureBlue = Color(0xFF007AFF)

    // Gray
    internal val gray50 = Color(0xFFF8FAFD)
    internal val gray75 = Color(0xFFF1F5FA)
    internal val gray100 = Color(0xFFE9EEF5)
    internal val gray200 = Color(0xFFDFE5ED)
    internal val gray300 = Color(0xFFCBD1DB)
    internal val gray400 = Color(0xFFA6B1BD)
    internal val gray500 = Color(0xFF8E98A4)
    internal val gray600 = Color(0xFF798491)
    internal val gray700 = Color(0xFF586370)
    internal val gray800 = Color(0xFF424B57)
    internal val gray850 = Color(0xFF333B45)
    internal val gray900 = Color(0xFF15191E)
    internal val gray950 = Color(0xFF0A0D0F)
}