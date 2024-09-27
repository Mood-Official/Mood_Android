package com.android.mood.designsystem.component.textinput.internal

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.android.mood.core.designsystem.R
import com.android.mood.designsystem.component.button.BtnPrimaryTextMedium
import com.android.mood.designsystem.component.icons.Icon16
import com.android.mood.designsystem.component.spacer.HorizontalSpacer
import com.android.mood.designsystem.foundation.MoodTheme


internal object MoodTextFieldDefaults {
    val BorderWidth: Dp = 1.dp
    val BorderShape: Shape = RoundedCornerShape(6.dp)

    val TextStyle: TextStyle
        @Composable
        get() = MoodTheme.typography.body.body1.regular

    @Composable
    fun cursor(): Brush {
        return SolidColor(MoodTheme.color.gray100)
    }

    @Composable
    fun paddings(): MoodTextFieldPaddingValues {
        return DefaultMoodTextFieldPaddingValues(
            horizontal = 12.dp,
            decoratedStart = 6.dp,
            vertical = 12.dp
        )
    }

    @Composable
    fun colors(): MoodTextFieldColors {
        return DefaultDealiTextFieldColors(
            backgroundColor = MoodTheme.color.white,
            disabledBackgroundColor = MoodTheme.color.gray75,
            readOnlyBackgroundColor = MoodTheme.color.white,
            outlineColor = MoodTheme.color.gray200,
            focusedOutlineColor = MoodTheme.color.gray600,
            errorOutlineColor = MoodTheme.color.rubyRed,
            readOnlyOutlineColor = MoodTheme.color.gray200,
            textColor = MoodTheme.color.gray900,
            disabledTextColor = MoodTheme.color.gray400,
            readOnlyTextColor = MoodTheme.color.gray900,
            placeholderTextColor = MoodTheme.color.gray400,
            labelTextColor = MoodTheme.color.gray600,
            helperTextColor = MoodTheme.color.rubyRed,
            errorHelperTextColor = MoodTheme.color.rubyRed,
        )
    }

    @Composable
    fun TrailingRemoveIcon(
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
    ) {
        Icon16(
            modifier = modifier,
            onClick = onClick,
            iconRes = R.drawable.frame_23,
            color = MoodTheme.color.primary500,
        )
    }

    @Composable
    fun TrailingButton(
        text: String,
        onClick: () -> Unit,
        enabled: Boolean,
        modifier: Modifier = Modifier,
    ) {
        Row(modifier = modifier) {
            HorizontalSpacer(width = 8.dp)
            BtnPrimaryTextMedium(
                text = text,
                enabled = enabled,
                onClick = onClick,
            )
        }
    }
}

@Stable
internal interface MoodTextFieldPaddingValues {

    @Composable
    fun padding(
        singleLine: Boolean,
        hasLeadingContent: Boolean,
        hasTrailingContent: Boolean,
    ): State<PaddingValues>
}

@Immutable
private class DefaultMoodTextFieldPaddingValues(
    private val decoratedStart: Dp,
    private val horizontal: Dp,
    private val vertical: Dp,
) : MoodTextFieldPaddingValues {

    @Composable
    override fun padding(
        singleLine: Boolean,
        hasLeadingContent: Boolean,
        hasTrailingContent: Boolean,
    ): State<PaddingValues> {

        return rememberUpdatedState(
            if (singleLine) {
                if (hasLeadingContent) {
                    PaddingValues(start = decoratedStart, end = horizontal)
                } else {
                    PaddingValues(horizontal = horizontal)
                }
            } else {
                PaddingValues(horizontal = horizontal, vertical = vertical)
            }
        )
    }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        if (this::class != other::class) return false

        other as DefaultMoodTextFieldPaddingValues

        if (this.horizontal != other.horizontal) return false
        if (this.decoratedStart != other.decoratedStart) return false
        return this.vertical == other.vertical
    }

    override fun hashCode(): Int {
        var hash = horizontal.hashCode()
        hash = 31 * hash + decoratedStart.hashCode()
        hash = 31 * hash + vertical.hashCode()
        return hash
    }
}

@Stable
internal interface MoodTextFieldColors {
    @Composable
    fun backgroundColor(state: MoodTextFieldState): State<Color>

    @Composable
    fun backgroundColor(enabled: Boolean): State<Color>

    @Composable
    fun outlineColor(state: MoodTextFieldState, focused: Boolean): State<Color?>

    @Composable
    fun textColor(state: MoodTextFieldState): State<Color>

    @Composable
    fun outlineColor(enabled: Boolean, focused: Boolean, isError: Boolean): State<Color?>

    @Composable
    fun textColor(enabled: Boolean): State<Color>

    @Composable
    fun placeholderTextColor(): State<Color>

    @Composable
    fun labelTextColor(): State<Color>

    @Composable
    fun helperTextColor(isError: Boolean): State<Color>
}

@Immutable
private class DefaultDealiTextFieldColors(
    private val backgroundColor: Color,
    private val disabledBackgroundColor: Color,
    private val readOnlyBackgroundColor: Color,
    private val outlineColor: Color,
    private val focusedOutlineColor: Color,
    private val errorOutlineColor: Color,
    private val readOnlyOutlineColor: Color,
    private val textColor: Color,
    private val disabledTextColor: Color,
    private val readOnlyTextColor: Color,
    private val placeholderTextColor: Color,
    private val labelTextColor: Color,
    private val helperTextColor: Color,
    private val errorHelperTextColor: Color,
) : MoodTextFieldColors {
    @Composable
    override fun backgroundColor(state: MoodTextFieldState): State<Color> {
        return rememberUpdatedState(
            when (state) {
                MoodTextFieldState.ENABLED,
                MoodTextFieldState.ERROR -> backgroundColor

                MoodTextFieldState.READ_ONLY -> readOnlyBackgroundColor
                else -> disabledBackgroundColor
            }
        )
    }

    @Composable
    override fun backgroundColor(enabled: Boolean): State<Color> {
        return rememberUpdatedState(if (enabled) backgroundColor else disabledBackgroundColor)
    }

    @Composable
    override fun outlineColor(state: MoodTextFieldState, focused: Boolean): State<Color> {
        return rememberUpdatedState(
            when (state) {
                MoodTextFieldState.ENABLED -> {
                    if (focused) {
                        focusedOutlineColor
                    } else {
                        outlineColor
                    }
                }

                MoodTextFieldState.ERROR -> errorOutlineColor
                else -> readOnlyOutlineColor
            }
        )
    }

    @Composable
    override fun textColor(state: MoodTextFieldState): State<Color> {
        return rememberUpdatedState(
            when (state) {
                MoodTextFieldState.ENABLED,
                MoodTextFieldState.ERROR -> textColor

                MoodTextFieldState.READ_ONLY -> readOnlyTextColor
                else -> disabledTextColor
            }
        )
    }

    @Composable
    override fun outlineColor(enabled: Boolean, focused: Boolean, isError: Boolean): State<Color> {
        return rememberUpdatedState(
            if (enabled) {
                if (isError) {
                    errorOutlineColor
                } else if (focused) {
                    focusedOutlineColor
                } else {
                    outlineColor
                }
            } else {
                outlineColor
            }
        )
    }

    @Composable
    override fun textColor(enabled: Boolean): State<Color> {
        return rememberUpdatedState(if (enabled) textColor else disabledTextColor)
    }

    @Composable
    override fun placeholderTextColor(): State<Color> {
        return rememberUpdatedState(placeholderTextColor)
    }

    @Composable
    override fun labelTextColor(): State<Color> {
        return rememberUpdatedState(labelTextColor)
    }

    @Composable
    override fun helperTextColor(isError: Boolean): State<Color> {
        return rememberUpdatedState(if (isError) errorHelperTextColor else helperTextColor)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        if (this::class != other::class) return false

        other as DefaultDealiTextFieldColors

        if (this.backgroundColor != other.backgroundColor) return false
        if (this.disabledBackgroundColor != other.disabledBackgroundColor) return false
        if (this.outlineColor != other.outlineColor) return false
        if (this.focusedOutlineColor != other.focusedOutlineColor) return false
        if (this.errorOutlineColor != other.errorOutlineColor) return false
        if (this.textColor != other.textColor) return false
        if (this.disabledTextColor != other.disabledTextColor) return false
        if (this.readOnlyTextColor != other.readOnlyTextColor) return false
        if (this.placeholderTextColor != other.placeholderTextColor) return false
        if (this.labelTextColor != other.labelTextColor) return false
        if (this.helperTextColor != other.helperTextColor) return false
        return this.errorHelperTextColor == other.errorHelperTextColor
    }

    override fun hashCode(): Int {
        var hash = backgroundColor.hashCode()
        hash = 31 * hash + disabledBackgroundColor.hashCode()
        hash = 31 * hash + outlineColor.hashCode()
        hash = 31 * hash + focusedOutlineColor.hashCode()
        hash = 31 * hash + errorOutlineColor.hashCode()
        hash = 31 * hash + textColor.hashCode()
        hash = 31 * hash + readOnlyTextColor.hashCode()
        hash = 31 * hash + disabledTextColor.hashCode()
        hash = 31 * hash + placeholderTextColor.hashCode()
        hash = 31 * hash + labelTextColor.hashCode()
        hash = 31 * hash + helperTextColor.hashCode()
        hash = 31 * hash + errorHelperTextColor.hashCode()
        return hash
    }
}