package com.android.mood.designsystem.component.checkcircle

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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

/**
 * 체크 서클 컴포넌트.
 *
 * @param checked 체크 상태
 * @param text 옆에 표시할 문구
 * @param modifier 컴포넌트에 적용할 [Modifier]
 * @param enabled 활성화 상태
 * @param onCheck 체크 시 콜백
 */
@Composable
fun CheckCircle(
    checked: Boolean,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onCheck: () -> Unit,
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                enabled = enabled,
                role = Role.Checkbox,
                onClick = onCheck
            )
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CheckCircleIcon(
            checked = checked,
            enabled = enabled,
            modifier =
            if (checked) {
                Modifier
                    .clip(RoundedCornerShape(1000.dp))
                    .background(MoodTheme.color.primary500)
            } else {
                Modifier
                    .clip(RoundedCornerShape(1000.dp))
                    .border(2.dp, MoodTheme.color.gray300, RoundedCornerShape(1000.dp))
                    .background(MoodTheme.color.transparent)
            }
        )

        MoodText(
            modifier = Modifier
                .padding(start = 8.dp, end = 3.dp),
            text = text,
            style = MoodTheme.typography.subtitle.subtitle5.medium,
            color = when {
                enabled.not() -> MoodTheme.color.gray900
                else -> MoodTheme.color.gray900
            },
            maxLines = 1
        )
    }
}

@Composable
fun CheckCircleIcon(
    checked: Boolean,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    noRipple: Boolean = false,
    onCheck: (() -> Unit)? = null,
) {
    InternalCheckCircleIcon(
        modifier = modifier,
        checked = checked,
        enabled = enabled,
        onCheck = onCheck,
        noRipple = noRipple,
    )
}

/**
 * 체크 서클 아이콘 컴포넌트.
 *
 * @param checked 체크 상태
 * @param modifier 컴포넌트에 적용할 [Modifier]
 * @param enabled 활성화 상태
 * @param isAd 체크 스타일을 AD 스타일로 설정
 * @param noRipple 리플 효과 제거 여부
 * @param onCheck 체크 시 콜백. `null`인 경우 클릭 이벤트 제거.
 */
@Composable
private fun InternalCheckCircleIcon(
    checked: Boolean,
    modifier: Modifier = Modifier,
    enabled: Boolean,
    noRipple: Boolean = false,
    onCheck: (() -> Unit)? = null,
) {
    val iconRes = when {
        enabled.not() -> R.drawable.ic_check_thickness_2_0
        checked -> R.drawable.ic_check_thickness_2_0
        else -> R.drawable.ic_check_thickness_2_0
    }

    if (onCheck == null) {
        Icon24(
            modifier = modifier,
            iconRes = iconRes,
            color = MoodTheme.color.white
        )
    } else {
        Icon24(
            modifier = modifier,
            iconRes = iconRes,
            enabled = enabled,
            onClick = onCheck,
            noRipple = noRipple,
            color = MoodTheme.color.white
        )
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0XFFFFFF)
private fun CheckCirclePreview() {
    Column(
        modifier = Modifier
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        CheckCircle(
            checked = false,
            text = "(필수) 만 14세 이상입니다.",
            onCheck = {},
        )
        CheckCircle(
            checked = true,
            text = "(필수) 서비스 이용약관 동의",
            onCheck = {}
        )
        CheckCircle(
            checked = true,
            text = "(필수) 개인정보 수집 이용 동의",
            onCheck = {}
        )
        CheckCircle(
            checked = true,
            text = "(선택) 마케팅 개인정보 제 3자 제공 동의",
            enabled = false,
            onCheck = {}
        )
    }
}