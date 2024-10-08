package com.android.mood.designsystem.foundation


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

enum class MoodRadius(val shape: RoundedCornerShape) {
    Radius4(RoundedCornerShape(size = 4.dp)),
    Radius6(RoundedCornerShape(size = 6.dp)),
    Radius10(RoundedCornerShape(size = 10.dp)),
    Radius12(RoundedCornerShape(size = 12.dp)),
    Radius20(RoundedCornerShape(size = 20.dp)),
    Radius25(RoundedCornerShape(size = 25.dp)),
    Radius30(RoundedCornerShape(size = 30.dp)),
    Radius35(RoundedCornerShape(size = 35.dp)),
    Radius40(RoundedCornerShape(size = 40.dp)),
    Radius100(RoundedCornerShape(size = 100.dp)),
    RadiusTop30(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
}