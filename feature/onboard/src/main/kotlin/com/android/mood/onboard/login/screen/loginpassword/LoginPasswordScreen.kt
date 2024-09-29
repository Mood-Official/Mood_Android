package com.android.mood.onboard.login.screen.loginpassword

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.mood.designsystem.component.button.BtnSolidLarge
import com.android.mood.designsystem.component.spacer.VerticalSpacer
import com.android.mood.designsystem.component.text.MoodText
import com.android.mood.designsystem.component.textinput.TextInput
import com.android.mood.designsystem.foundation.MoodRadius
import com.android.mood.designsystem.foundation.MoodTheme
import com.android.mood.onboard.login.screen.loginpassword.state.LoginPasswordUiState

@Composable
fun LoginPasswordScreen(
    state: LoginPasswordUiState,
    inputPassword: (String) -> Unit,
    onClick: (String) -> Unit,
) {
    LoginPasswordScreenImpl(
        state = state,
        inputPassword = inputPassword,
        onClick = onClick,
    )
}

@Composable
fun LoginPasswordScreenImpl(
    state: LoginPasswordUiState,
    inputPassword: (String) -> Unit = {},
    onClick: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MoodTheme.color.white)
            .padding(all = 16.dp)
    ) {
        MoodText(text = "비밀번호를 입력하고\n로그인해주세요", style = MoodTheme.typography.headline.headline7.bold)
        VerticalSpacer(height = 32.dp)
        TextInput(
            value = state.password,
            placeholder = "비밀번호를 입력해주세요.",
            onValueChange = { inputPassword(it) },
            isNecessary = false,
            label = "비밀번호",
            helperText = "비밀번호를 다시 입력해주세요.",
            isHelperTextVisible = state.isSuccess?.let { !it } ?: false,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )
        VerticalSpacer(height = 12.dp)
        BtnSolidLarge(
            onClick = { onClick(state.password) },
            text = "다음",
            modifier = Modifier
                .fillMaxWidth()
                .clip(MoodRadius.Radius12.shape),
            enabled = state.password.isNotEmpty()
        )
        VerticalSpacer(height = 32.dp)
        MoodText(
            modifier = Modifier.fillMaxWidth(),
            text = "비밀번호 찾기",
            style = MoodTheme.typography.caption.caption1.regular,
            color = MoodTheme.color.gray600,
            textAlign = TextAlign.Center,
        )
    }
}