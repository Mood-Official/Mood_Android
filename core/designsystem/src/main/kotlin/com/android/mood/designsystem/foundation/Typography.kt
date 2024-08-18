package com.android.mood.designsystem.foundation

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.android.mood.core.designsystem.R

internal val Pretendards = FontFamily(
    Font(R.font.pretendard_bold, FontWeight.Bold),
    Font(R.font.pretendard_semi_bold, FontWeight.SemiBold),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_regular, FontWeight.Normal)
)

internal val LocalMoodTypography = staticCompositionLocalOf { MoodTypography() }

class MoodTypography {
    val headline = Headline()
    val subtitle = Subtitle()
    val body = Body()
    val caption = Caption()
}

class Headline {
    val headline1 = TextStyleSet(
        bold = pretendardBold(size = 56, lineHeight = 72, letterSpacing = (-1.78F)),
        semibold = pretendardSemiBold(size = 56, lineHeight = 72, letterSpacing = (-1.78F)),
        medium = pretendardMedium(size = 56, lineHeight = 72, letterSpacing = (-1.78F))
    )
    val headline2 = TextStyleSet(
        bold = pretendardBold(size = 44, lineHeight = 57, letterSpacing = (-1.32F)),
        semibold = pretendardSemiBold(size = 44, lineHeight = 57, letterSpacing = (-1.32F)),
        medium = pretendardMedium(size = 44, lineHeight = 57, letterSpacing = (-1.32F))
    )
    val headline3 = TextStyleSet(
        bold = pretendardBold(size = 40, lineHeight = 52, letterSpacing = (-1.12F)),
        semibold = pretendardSemiBold(size = 40, lineHeight = 52, letterSpacing = (-1.12F)),
        medium = pretendardMedium(size = 40, lineHeight = 52, letterSpacing = (-1.12F))
    )
    val headline4 = TextStyleSet(
        bold = pretendardBold(size = 36, lineHeight = 48, letterSpacing = (-0.97F)),
        semibold = pretendardSemiBold(size = 36, lineHeight = 48, letterSpacing = (-0.97F)),
        medium = pretendardMedium(size = 36, lineHeight = 48, letterSpacing = (-0.97F))
    )
    val headline6 = TextStyleSet(
        bold = pretendardBold(size = 28, lineHeight = 38, letterSpacing = (-0.66F)),
        semibold = pretendardSemiBold(size = 28, lineHeight = 38, letterSpacing = (-0.66F)),
        medium = pretendardMedium(size = 28, lineHeight = 38, letterSpacing = (-0.66F))
    )
    val headline7 = TextStyleSet(
        bold = pretendardBold(size = 24, lineHeight = 32, letterSpacing = (-0.55F)),
        semibold = pretendardSemiBold(size = 24, lineHeight = 32, letterSpacing = (-0.55F)),
        medium = pretendardMedium(size = 24, lineHeight = 32, letterSpacing = (-0.55F)),
        regular = pretendardRegular(size = 24, lineHeight = 32, letterSpacing = (-0.55F))
    )
    val headline8 = TextStyleSet(
        bold = pretendardBold(size = 20, lineHeight = 28, letterSpacing = (-0.24F)),
        semibold = pretendardSemiBold(size = 20, lineHeight = 28, letterSpacing = (-0.24F)),
        medium = pretendardMedium(size = 20, lineHeight = 28, letterSpacing = (-0.24F)),
        regular = pretendardRegular(size = 20, lineHeight = 28, letterSpacing = (-0.24F))
    )
}

class Subtitle {
    val subtitle1 = TextStyleSet(
        bold = pretendardBold(size = 18, lineHeight = 26, letterSpacing = (-0.36F)),
        semibold = pretendardSemiBold(size = 18, lineHeight = 26, letterSpacing = (-0.36F)),
        medium = pretendardMedium(size = 18, lineHeight = 26, letterSpacing = (-0.36F)),
        regular = pretendardRegular(size = 18, lineHeight = 26, letterSpacing = (-0.36F))
    )
    val subtitle2 = TextStyleSet(
        bold = pretendardBold(size = 17, lineHeight = 24, letterSpacing = 0F),
        semibold = pretendardSemiBold(size = 17, lineHeight = 24, letterSpacing = 0F),
        medium = pretendardMedium(size = 17, lineHeight = 24, letterSpacing = 0F),
        regular = pretendardRegular(size = 17, lineHeight = 24, letterSpacing = 0F)
    )
    val subtitle3 = TextStyleSet(
        bold = pretendardBold(size = 16, lineHeight = 24, letterSpacing = 0F),
        semibold = pretendardSemiBold(size = 16, lineHeight = 24, letterSpacing = 0F),
        medium = pretendardMedium(size = 16, lineHeight = 24, letterSpacing = 0F),
        regular = pretendardRegular(size = 16, lineHeight = 24, letterSpacing = 0F)
    )
    val subtitle4 = TextStyleSet(
        bold = pretendardBold(size = 15, lineHeight = 24, letterSpacing = 0F),
        semibold = pretendardSemiBold(size = 15, lineHeight = 24, letterSpacing = 0F),
        medium = pretendardMedium(size = 15, lineHeight = 24, letterSpacing = 0F),
        regular = pretendardRegular(size = 15, lineHeight = 24, letterSpacing = 0F)
    )
    val subtitle5 = TextStyleSet(
        bold = pretendardBold(size = 14, lineHeight = 22, letterSpacing = (0.19F)),
        semibold = pretendardSemiBold(size = 14, lineHeight = 22, letterSpacing = (0.19F)),
        medium = pretendardMedium(size = 14, lineHeight = 22, letterSpacing = (0.19F)),
        regular = pretendardRegular(size = 14, lineHeight = 22, letterSpacing = (0.19F))
    )
    val subtitle6 = TextStyleSet(
        bold = pretendardBold(size = 13, lineHeight = 18, letterSpacing = (0.25F)),
        semibold = pretendardSemiBold(size = 13, lineHeight = 18, letterSpacing = (0.25F)),
        medium = pretendardMedium(size = 13, lineHeight = 18, letterSpacing = (0.25F)),
        regular = pretendardRegular(size = 13, lineHeight = 18, letterSpacing = (0.25F))
    )
}

class Body {
    val body1 = TextStyleSet(
        bold = pretendardBold(size = 16, lineHeight = 26, letterSpacing = (0.1F)),
        semibold = pretendardSemiBold(size = 16, lineHeight = 26, letterSpacing = (0.1F)),
        medium = pretendardMedium(size = 16, lineHeight = 26, letterSpacing = (0.1F)),
        regular = pretendardRegular(size = 16, lineHeight = 26, letterSpacing = (0.1F))
    )
    val body2 = TextStyleSet(
        bold = pretendardBold(size = 15, lineHeight = 24, letterSpacing = (0.15F)),
        semibold = pretendardSemiBold(size = 15, lineHeight = 24, letterSpacing = (0.15F)),
        medium = pretendardMedium(size = 15, lineHeight = 24, letterSpacing = (0.15F)),
        regular = pretendardRegular(size = 15, lineHeight = 24, letterSpacing = (0.15F))
    )
    val body3 = TextStyleSet(
        bold = pretendardBold(size = 14, lineHeight = 24, letterSpacing = (0.19F)),
        semibold = pretendardSemiBold(size = 14, lineHeight = 24, letterSpacing = (0.19F)),
        medium = pretendardMedium(size = 14, lineHeight = 24, letterSpacing = (0.19F)),
        regular = pretendardRegular(size = 14, lineHeight = 24, letterSpacing = (0.19F))
    )
}

class Caption {
    val caption1 = TextStyleSet(
        bold = pretendardBold(size = 13, lineHeight = 18, letterSpacing = (0.25F)),
        semibold = pretendardSemiBold(size = 13, lineHeight = 18, letterSpacing = (0.25F)),
        medium = pretendardMedium(size = 13, lineHeight = 18, letterSpacing = (0.25F)),
        regular = pretendardRegular(size = 13, lineHeight = 18, letterSpacing = (0.25F))
    )
    val caption2 = TextStyleSet(
        bold = pretendardBold(size = 12, lineHeight = 16, letterSpacing = (0.3F)),
        semibold = pretendardSemiBold(size = 12, lineHeight = 16, letterSpacing = (0.3F)),
        medium = pretendardMedium(size = 12, lineHeight = 16, letterSpacing = (0.3F)),
        regular = pretendardRegular(size = 12, lineHeight = 16, letterSpacing = (0.3F))
    )
    val caption3 = TextStyleSet(
        bold = pretendardBold(size = 11, lineHeight = 14, letterSpacing = (0.34F)),
        semibold = pretendardSemiBold(size = 11, lineHeight = 14, letterSpacing = (0.34F)),
        medium = pretendardMedium(size = 11, lineHeight = 14, letterSpacing = (0.34F)),
        regular = pretendardRegular(size = 11, lineHeight = 14, letterSpacing = (0.34F))
    )
    val caption4 = TextStyleSet(
        bold = pretendardBold(size = 10, lineHeight = 12, letterSpacing = (0.34F)),
        semibold = pretendardSemiBold(size = 10, lineHeight = 12, letterSpacing = (0.34F)),
        medium = pretendardMedium(size = 10, lineHeight = 12, letterSpacing = (0.34F)),
        regular = pretendardRegular(size = 10, lineHeight = 12, letterSpacing = (0.34F))
    )
}


class TextStyleSet(
    val bold: TextStyle,
    val semibold: TextStyle,
    val medium: TextStyle,
    val regular: TextStyle? = null,
)

private fun pretendardBold(
    size: Int,
    lineHeight: Int,
    letterSpacing: Float,
) = TextStyle(
    fontFamily = Pretendards,
    fontWeight = FontWeight.Bold,
    fontSize = size.sp,
    lineHeight = lineHeight.sp,
    letterSpacing = letterSpacing.sp,
)

private fun pretendardSemiBold(
    size: Int,
    lineHeight: Int,
    letterSpacing: Float,
) = TextStyle(
    fontFamily = Pretendards,
    fontWeight = FontWeight.SemiBold,
    fontSize = size.sp,
    lineHeight = lineHeight.sp,
    letterSpacing = letterSpacing.sp,
)

private fun pretendardMedium(
    size: Int,
    lineHeight: Int,
    letterSpacing: Float,
) = TextStyle(
    fontFamily = Pretendards,
    fontWeight = FontWeight.Medium,
    fontSize = size.sp,
    lineHeight = lineHeight.sp,
    letterSpacing = letterSpacing.sp,
)

private fun pretendardRegular(
    size: Int,
    lineHeight: Int,
    letterSpacing: Float,
) = TextStyle(
    fontFamily = Pretendards,
    fontWeight = FontWeight.Normal,
    fontSize = size.sp,
    lineHeight = lineHeight.sp,
    letterSpacing = letterSpacing.sp,
)