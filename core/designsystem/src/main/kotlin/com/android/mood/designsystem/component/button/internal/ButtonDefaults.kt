package com.android.mood.designsystem.component.button.internal

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.android.mood.designsystem.foundation.MoodRadius
import com.android.mood.designsystem.foundation.MoodTheme
import net.deali.designsystem.internal.button.ButtonSize
import net.deali.designsystem.internal.button.ButtonStyle

internal object ButtonDefaults {
    @Composable
    fun colors(
        backgroundColor: Color,
        disabledBackgroundColor: Color,
        contentColor: Color,
        disabledContentColor: Color,
        outlineColor: Color = MoodTheme.color.transparent,
        disabledOutlineColor: Color = MoodTheme.color.transparent,
    ): ButtonColors {
        return DefaultButtonColors(
            backgroundColor = SolidColor(backgroundColor),
            disabledBackgroundColor = SolidColor(disabledBackgroundColor),
            outlineColor = outlineColor,
            disabledOutlineColor = disabledOutlineColor,
            contentColor = contentColor,
            disabledContentColor = disabledContentColor,
        )
    }

    @Composable
    fun colors(
        backgroundColor: Brush,
        disabledBackgroundColor: Brush,
        contentColor: Color,
        disabledContentColor: Color,
        outlineColor: Color = MoodTheme.color.transparent,
        disabledOutlineColor: Color = MoodTheme.color.transparent,
    ): ButtonColors {
        return DefaultButtonColors(
            backgroundColor = backgroundColor,
            disabledBackgroundColor = disabledBackgroundColor,
            outlineColor = outlineColor,
            disabledOutlineColor = disabledOutlineColor,
            contentColor = contentColor,
            disabledContentColor = disabledContentColor,
        )
    }

    @Composable
    fun buttonShape(buttonSize: ButtonSize, rounded: Boolean): Shape {
        if (rounded) {
            return MoodRadius.Radius100.shape
        }
        return when (buttonSize) {
            ButtonSize.Large -> MoodRadius.Radius6.shape
            ButtonSize.Medium -> MoodRadius.Radius6.shape
            ButtonSize.SemiMedium -> MoodRadius.Radius6.shape
            ButtonSize.Small -> MoodRadius.Radius4.shape
        }
    }

    @Composable
    fun buttonMinHeight(buttonSize: ButtonSize): Dp {
        return when (buttonSize) {
            ButtonSize.Large -> 50.dp
            ButtonSize.Medium -> 46.dp
            ButtonSize.SemiMedium -> 40.dp
            ButtonSize.Small -> 32.dp
        }
    }

    @Composable
    fun buttonPaddings(
        buttonSize: ButtonSize,
        buttonStyle: ButtonStyle,
        useLeftIcon: Boolean,
        useRightIcon: Boolean,
        isLoading: Boolean,
        rounded: Boolean,
    ): PaddingValues {
        return when (buttonSize) {
            ButtonSize.Large -> largeButtonPaddings(
                buttonStyle,
                useLeftIcon,
                useRightIcon,
                isLoading
            )

            ButtonSize.Medium -> mediumButtonPaddings(
                buttonStyle,
                useLeftIcon,
                useRightIcon,
                isLoading
            )

            ButtonSize.SemiMedium -> semiMediumButtonPaddings(
                buttonStyle,
                useLeftIcon,
                useRightIcon,
                isLoading
            )

            ButtonSize.Small -> smallButtonPaddings(
                buttonStyle,
                useLeftIcon,
                useRightIcon,
                isLoading,
                rounded
            )
        }
    }

    @Composable
    private fun largeButtonPaddings(
        buttonStyle: ButtonStyle,
        useLeftIcon: Boolean,
        useRightIcon: Boolean,
        isLoading: Boolean,
    ): PaddingValues {
        if (isLoading || buttonStyle == ButtonStyle.Assistive) {
            return PaddingValues(horizontal = 16.dp)
        }
        val leftPadding = if (useLeftIcon) 16.dp else 20.dp
        val rightPadding = if (useRightIcon) 16.dp else 20.dp
        return PaddingValues(start = leftPadding, end = rightPadding)
    }

    @Composable
    private fun mediumButtonPaddings(
        buttonStyle: ButtonStyle,
        useLeftIcon: Boolean,
        useRightIcon: Boolean,
        isLoading: Boolean,
    ): PaddingValues {
        if (isLoading || buttonStyle == ButtonStyle.Assistive) {
            return PaddingValues(horizontal = 16.dp)
        }
        val leftPadding = if (useLeftIcon) 16.dp else 20.dp
        val rightPadding = if (useRightIcon) 16.dp else 20.dp
        return PaddingValues(start = leftPadding, end = rightPadding)
    }

    @Composable
    private fun semiMediumButtonPaddings(
        buttonStyle: ButtonStyle,
        useLeftIcon: Boolean,
        useRightIcon: Boolean,
        isLoading: Boolean,
    ): PaddingValues {
        if (isLoading || buttonStyle == ButtonStyle.Assistive) {
            return PaddingValues(horizontal = 16.dp)
        }
        val leftPadding = if (useLeftIcon) 16.dp else 20.dp
        val rightPadding = if (useRightIcon) 16.dp else 20.dp
        return PaddingValues(start = leftPadding, end = rightPadding)
    }

    @Composable
    private fun smallButtonPaddings(
        buttonStyle: ButtonStyle,
        useLeftIcon: Boolean,
        useRightIcon: Boolean,
        isLoading: Boolean,
        rounded: Boolean
    ): PaddingValues {
        if (buttonStyle == ButtonStyle.Assistive) {
            return PaddingValues(horizontal = 16.dp)
        }
        if (rounded) {
            return PaddingValues(
                start = if (useLeftIcon) 12.dp else 16.dp,
                end = if (useRightIcon) 12.dp else 16.dp
            )
        }
        if (isLoading || useLeftIcon && useRightIcon) {
            return PaddingValues(horizontal = 12.dp)
        }

        val leftPadding = if (useLeftIcon) 8.dp else 12.dp
        val rightPadding = if (useRightIcon) 8.dp else 12.dp

        return PaddingValues(start = leftPadding, end = rightPadding)
    }

    @Composable
    fun buttonTextStyle(buttonSize: ButtonSize, buttonStyle: ButtonStyle): TextStyle {
        return when (buttonSize) {
            ButtonSize.Large -> MoodTheme.typography.subtitle.subtitle3.medium

            ButtonSize.Medium -> if (buttonStyle == ButtonStyle.Assistive) {
                MoodTheme.typography.subtitle.subtitle4.medium
            } else {
                MoodTheme.typography.subtitle.subtitle4.medium
            }

            ButtonSize.SemiMedium -> if (buttonStyle == ButtonStyle.Assistive) {
                MoodTheme.typography.subtitle.subtitle5.medium
            } else {
                MoodTheme.typography.subtitle.subtitle5.medium
            }

            ButtonSize.Small -> if (buttonStyle == ButtonStyle.Assistive) {
                MoodTheme.typography.subtitle.subtitle6.medium
            } else {
                MoodTheme.typography.subtitle.subtitle6.medium
            }
        }
    }

    @Composable
    fun loadingIconSize(buttonSize: ButtonSize): DpSize {
        return when (buttonSize) {
            ButtonSize.Large, ButtonSize.Medium -> DpSize(24.dp, 24.dp)
            ButtonSize.SemiMedium, ButtonSize.Small -> DpSize(16.dp, 16.dp)
        }
    }
}

@Stable
internal interface ButtonColors {
    @Composable
    fun backgroundColor(enabled: Boolean): State<Brush>

    @Composable
    fun outlineColor(enabled: Boolean): State<Color>

    @Composable
    fun contentColor(enabled: Boolean): State<Color>
}

@Immutable
private class DefaultButtonColors(
    val backgroundColor: Brush,
    val disabledBackgroundColor: Brush,
    val outlineColor: Color,
    val disabledOutlineColor: Color,
    val contentColor: Color,
    val disabledContentColor: Color,
) : ButtonColors {
    @Composable
    override fun backgroundColor(enabled: Boolean): State<Brush> {
        return rememberUpdatedState(if (enabled) backgroundColor else disabledBackgroundColor)
    }

    @Composable
    override fun outlineColor(enabled: Boolean): State<Color> {
        return rememberUpdatedState(if (enabled) outlineColor else disabledOutlineColor)
    }

    @Composable
    override fun contentColor(enabled: Boolean): State<Color> {
        return rememberUpdatedState(if (enabled) contentColor else disabledContentColor)
    }
}
