package com.android.mood.designsystem.component.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.android.mood.designsystem.component.button.internal.ButtonDefaults
import com.android.mood.designsystem.foundation.MoodTheme
import com.android.mood.designsystem.component.button.internal.ButtonSize
import com.android.mood.designsystem.component.button.internal.ButtonStyle
import com.android.mood.designsystem.component.button.internal.CoreButton

@Composable
fun BtnSolidSmall(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes leftIcon: Int? = null,
    @DrawableRes rightIcon: Int? = null,
    clickable: Boolean = true,
    enabled: Boolean = true,
    loading: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    CoreButton(
        onClick = onClick,
        text = text,
        leftIcon = leftIcon,
        rightIcon = rightIcon,
        clickable = clickable,
        enabled = enabled,
        loading = loading,
        buttonStyle = ButtonStyle.Filled,
        buttonSize = ButtonSize.Small,
        buttonColors = ButtonDefaults.colors(
            backgroundColor = MoodTheme.color.primary500,
            disabledBackgroundColor = MoodTheme.color.gray75,
            contentColor = MoodTheme.color.white,
            disabledContentColor = MoodTheme.color.gray400,
        ),
        interactionSource = interactionSource,
        modifier = modifier,
    )
}

@Composable
fun BtnPrimaryOutlineSmall(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes leftIcon: Int? = null,
    @DrawableRes rightIcon: Int? = null,
    clickable: Boolean = true,
    enabled: Boolean = true,
    loading: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    CoreButton(
        onClick = onClick,
        text = text,
        leftIcon = leftIcon,
        rightIcon = rightIcon,
        clickable = clickable,
        enabled = enabled,
        loading = loading,
        buttonStyle = ButtonStyle.Outline,
        buttonSize = ButtonSize.Small,
        buttonColors = ButtonDefaults.colors(
            backgroundColor = MoodTheme.color.white,
            disabledBackgroundColor = MoodTheme.color.white,
            outlineColor = MoodTheme.color.primary500,
            disabledOutlineColor = MoodTheme.color.gray200,
            contentColor = MoodTheme.color.primary500,
            disabledContentColor = MoodTheme.color.gray300,
        ),
        interactionSource = interactionSource,
        modifier = modifier,
    )
}

@Composable
fun BtnSecondaryOutlineSmall(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes leftIcon: Int? = null,
    @DrawableRes rightIcon: Int? = null,
    clickable: Boolean = true,
    enabled: Boolean = true,
    loading: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    CoreButton(
        onClick = onClick,
        text = text,
        leftIcon = leftIcon,
        rightIcon = rightIcon,
        clickable = clickable,
        enabled = enabled,
        loading = loading,
        buttonStyle = ButtonStyle.Outline,
        buttonSize = ButtonSize.Small,
        buttonColors = ButtonDefaults.colors(
            backgroundColor = MoodTheme.color.white,
            disabledBackgroundColor = MoodTheme.color.white,
            outlineColor = MoodTheme.color.gray200,
            disabledOutlineColor = MoodTheme.color.gray200,
            contentColor = MoodTheme.color.primary500,
            disabledContentColor = MoodTheme.color.gray300,
        ),
        interactionSource = interactionSource,
        modifier = modifier,
    )
}

@Composable
fun BtnAssistiveSmall(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes leftIcon: Int? = null,
    @DrawableRes rightIcon: Int? = null,
    clickable: Boolean = true,
    enabled: Boolean = true,
    loading: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    CoreButton(
        onClick = onClick,
        text = text,
        leftIcon = leftIcon,
        rightIcon = rightIcon,
        clickable = clickable,
        enabled = enabled,
        loading = loading,
        buttonStyle = ButtonStyle.Outline,
        buttonSize = ButtonSize.Small,
        buttonColors = ButtonDefaults.colors(
            backgroundColor = MoodTheme.color.white,
            disabledBackgroundColor = MoodTheme.color.white,
            outlineColor = MoodTheme.color.gray200,
            disabledOutlineColor = MoodTheme.color.gray200,
            contentColor = MoodTheme.color.primary500,
            disabledContentColor = MoodTheme.color.gray300,
        ),
        interactionSource = interactionSource,
        modifier = modifier,
    )
}

@Composable
fun BtnPrimaryTextSmall(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes leftIcon: Int? = null,
    @DrawableRes rightIcon: Int? = null,
    clickable: Boolean = true,
    enabled: Boolean = true,
    loading: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    CoreButton(
        onClick = onClick,
        text = text,
        leftIcon = leftIcon,
        rightIcon = rightIcon,
        clickable = clickable,
        enabled = enabled,
        loading = loading,
        buttonStyle = ButtonStyle.Text,
        buttonSize = ButtonSize.Small,
        buttonColors = ButtonDefaults.colors(
            backgroundColor = MoodTheme.color.white,
            disabledBackgroundColor = MoodTheme.color.white,
            contentColor = MoodTheme.color.primaryNormal,
            disabledContentColor = MoodTheme.color.gray300,
        ),
        interactionSource = interactionSource,
        modifier = modifier,
    )
}

@Composable
fun BtnAssistiveTextSmall(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes leftIcon: Int? = null,
    @DrawableRes rightIcon: Int? = null,
    clickable: Boolean = true,
    enabled: Boolean = true,
    loading: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    CoreButton(
        onClick = onClick,
        text = text,
        leftIcon = leftIcon,
        rightIcon = rightIcon,
        clickable = clickable,
        enabled = enabled,
        loading = loading,
        buttonStyle = ButtonStyle.Text,
        buttonSize = ButtonSize.Small,
        buttonColors = ButtonDefaults.colors(
            backgroundColor = MoodTheme.color.white,
            disabledBackgroundColor = MoodTheme.color.white,
            contentColor = MoodTheme.color.gray600,
            disabledContentColor = MoodTheme.color.gray300,
        ),
        interactionSource = interactionSource,
        modifier = modifier,
    )
}