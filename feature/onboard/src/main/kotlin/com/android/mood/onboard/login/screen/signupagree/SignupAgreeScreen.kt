package com.android.mood.onboard.login.screen.signupagree

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.mood.designsystem.component.button.BtnSolidLarge
import com.android.mood.designsystem.component.checkcircle.CheckCircle
import com.android.mood.designsystem.component.divider.HorizontalDivider
import com.android.mood.designsystem.component.spacer.HorizontalSpacer
import com.android.mood.designsystem.component.spacer.VerticalSpacer
import com.android.mood.designsystem.component.text.MoodText
import com.android.mood.designsystem.foundation.MoodRadius
import com.android.mood.designsystem.foundation.MoodTheme
import com.android.mood.onboard.login.screen.signupagree.state.AgreeUiState

@Composable
fun SignupAgreeScreen(state: AgreeUiState) {
    SignupAgreeScreenImpl(state = state, toggleAgreeItem = { _, _, _, _, _ -> })
}


@Composable
@Preview
fun SignupAgreeScreenImpl(
    state: AgreeUiState = AgreeUiState.INITIAL_STATE,
    toggleAgreeItem: (Boolean, Boolean, Boolean, Boolean, Boolean) -> Unit = { _, _, _, _, _ -> }
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MoodTheme.color.white)
            .padding(all = 16.dp)
    ) {
        MoodText(text = "서비스 이용 약관에\n동의해주세요", style = MoodTheme.typography.headline.headline7.bold)
        VerticalSpacer(height = 32.dp)
        CheckCircle(checked = state.isAllAgree, text = "모두 동의", onCheck = {})
        VerticalSpacer(height = 16.dp)
        HorizontalDivider(color = MoodTheme.color.gray100)
        VerticalSpacer(height = 16.dp)
        CheckCircle(checked = false, text = "(필수) 만 14세 이상입니다.", onCheck = {})
        VerticalSpacer(height = 16.dp)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckCircle(checked = false, text = "(필수) 서비스 이용약관 동의", onCheck = {})
            HorizontalSpacer(modifier = Modifier.weight(1f), width = 0.dp)
            MoodText(
                text = "보기",
                style = MoodTheme.typography.subtitle.subtitle6.medium,
                color = MoodTheme.color.gray400
            )
        }
        VerticalSpacer(height = 16.dp)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckCircle(checked = false, text = "(필수) 개인정보 수집 이용 동의", onCheck = {})
            HorizontalSpacer(modifier = Modifier.weight(1f), width = 0.dp)
            MoodText(
                text = "보기",
                style = MoodTheme.typography.subtitle.subtitle6.medium,
                color = MoodTheme.color.gray400
            )
        }
        VerticalSpacer(height = 16.dp)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckCircle(checked = false, text = "(선택) 마케팅 개인정보 제 3자 제공 동의", onCheck = {})
            HorizontalSpacer(modifier = Modifier.weight(1f), width = 0.dp)
            MoodText(
                text = "보기",
                style = MoodTheme.typography.subtitle.subtitle6.medium,
                color = MoodTheme.color.gray400
            )
        }

        VerticalSpacer(modifier = Modifier.weight(1f), height = 0.dp)
        BtnSolidLarge(
            onClick = {},
            text = "회원가입 완료",
            modifier = Modifier
                .fillMaxWidth()
                .clip(MoodRadius.Radius12.shape),
        )
    }
}