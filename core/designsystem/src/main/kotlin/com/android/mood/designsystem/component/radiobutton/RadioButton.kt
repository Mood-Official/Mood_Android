package com.android.mood.designsystem.component.radiobutton

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.mood.core.designsystem.R
import com.android.mood.designsystem.component.icon.Icon24
import com.android.mood.designsystem.component.text.MoodText
import com.android.mood.designsystem.foundation.MoodTheme

@Composable
fun RadioButton(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .selectable(
                selected = selected,
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                enabled = enabled,
                role = Role.RadioButton,
                onClick = onClick
            )
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioIcon(
            selected = selected,
            enabled = enabled,
            modifier = when (selected) {
                true -> {
                    Modifier
                        .clip(RoundedCornerShape(1000.dp))
                        .background(MoodTheme.color.primary500)
                        .padding(all = 2.dp)
                }

                false -> {
                    Modifier
                        .clip(RoundedCornerShape(1000.dp))
                        .background(MoodTheme.color.transparent)
                        .border(
                            width = 2.dp,
                            color = MoodTheme.color.gray300,
                            shape = RoundedCornerShape(1000.dp)
                        )
                        .padding(all = 2.dp)
                }
            }
        )
        MoodText(
            modifier = Modifier
                .padding(start = 8.dp),
            text = text,
            style = MoodTheme.typography.body.body1.bold,
            color = when {
                enabled.not() -> MoodTheme.color.black
                else -> MoodTheme.color.black
            }
        )
    }
}


@Composable
private fun RadioIcon(
    selected: Boolean,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
) {
    Icon24(
        modifier = modifier,
        iconRes = when {
            enabled.not() -> R.drawable.ic_minus_thickness_2_0
            selected -> R.drawable.ic_minus_thickness_2_0
            else -> R.drawable.ic_check_thickness_2_0
        },
        color = MoodTheme.color.white
    )
}

@Composable
@Preview(showBackground = true, backgroundColor = 0XFFFFFF)
private fun RadioButtonPreview() {
    Column(
        modifier = Modifier
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        RadioButton(
            text = "(필수) 만 14세 이상입니다.",
            selected = false,
            onClick = {}
        )

        RadioButton(
            text = "(필수) 서비스 이용약관 동의",
            selected = true,
            onClick = {}
        )

        RadioButton(
            text = "(필수) 개인정보 수집 이용 동의",
            selected = false,
            enabled = true,
            onClick = {}
        )

        RadioButton(
            text = "(선택) 마케팅 개인정보 제 3자 제공 동의",
            selected = false,
            enabled = false,
            onClick = {}
        )
    }
}