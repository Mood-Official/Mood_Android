package com.android.mood.onboard.login.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.mood.designsystem.component.button.BtnSolidLarge
import com.android.mood.designsystem.component.divider.VerticalDivider
import com.android.mood.designsystem.component.spacer.HorizontalSpacer
import com.android.mood.designsystem.component.spacer.VerticalSpacer
import com.android.mood.designsystem.component.text.MoodText
import com.android.mood.designsystem.component.textinput.TextInput
import com.android.mood.designsystem.foundation.MoodRadius
import com.android.mood.designsystem.foundation.MoodTheme
import com.android.mood.onboard.login.screen.login.state.LoginUiState

@Composable
fun LoginScreen(
    state: LoginUiState,
    validateEmail: (String) -> Unit,
    navigateToPassword: (String) -> Unit,
) {
    LoginScreenImpl(
        state = state,
        validateEmail = validateEmail,
        navigateToPassword = navigateToPassword,
    )
}

@Composable
@Preview
private fun LoginScreenImpl(
    state: LoginUiState = LoginUiState.INITIAL_STATE,
    validateEmail: (String) -> Unit = {},
    navigateToPassword: (String) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MoodTheme.color.white)
            .padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(top = 52.dp)
                .background(Color(0xFFD9D9D9))
                .fillMaxWidth()
                .height(150.dp),
            contentAlignment = Alignment.Center
        ) {
            MoodText(text = "Mood", style = MoodTheme.typography.headline.headline1.bold)
        }
        VerticalSpacer(height = 72.dp)
        TextInput(
            value = state.email,
            placeholder = "이메일을 입력해주세요.",
            onValueChange = { validateEmail(it) },
            isNecessary = false,
            label = "이메일",
            helperText = "올바른 이메일 형식으로 입력해주세요.",
            isHelperTextVisible = state.isSuccess?.let { !it } ?: false,
        )
        VerticalSpacer(height = 12.dp)
        BtnSolidLarge(
            onClick = { navigateToPassword(state.email) },
            text = "이메일로 계속하기",
            modifier = Modifier
                .fillMaxWidth()
                .clip(MoodRadius.Radius12.shape),
            enabled = state.isSuccess ?: false
        )
        VerticalSpacer(height = 36.dp)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            MoodText(
                text = "이메일 찾기",
                style = MoodTheme.typography.caption.caption1.regular,
                color = MoodTheme.color.gray600
            )
            HorizontalSpacer(width = 12.dp)
            VerticalDivider(color = MoodTheme.color.gray600, Modifier.height(12.dp))
            HorizontalSpacer(width = 12.dp)
            MoodText(
                text = "비밀번호 찾기",
                style = MoodTheme.typography.caption.caption1.regular,
                color = MoodTheme.color.gray600
            )
        }
    }
}