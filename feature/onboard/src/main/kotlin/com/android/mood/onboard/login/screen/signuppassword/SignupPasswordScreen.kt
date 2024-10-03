package com.android.mood.onboard.login.screen.signuppassword

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.mood.designsystem.component.button.BtnSolidLarge
import com.android.mood.designsystem.component.spacer.VerticalSpacer
import com.android.mood.designsystem.component.text.MoodText
import com.android.mood.designsystem.component.textinput.TextInput
import com.android.mood.designsystem.foundation.MoodRadius
import com.android.mood.designsystem.foundation.MoodTheme
import com.android.mood.onboard.login.screen.signuppassword.state.PasswordUiState

@Composable
fun SignupPasswordScreen(
    state: PasswordUiState,
    navigateToNickname: () -> Unit,
    validatePassword: (String) -> Unit,
    validateRepeatedPassword: (String, String) -> Unit,
) {
    SignupPasswordScreenImpl(
        state = state,
        navigateToNickname = navigateToNickname,
        validatePassword = validatePassword,
        validateRepeatedPassword = validateRepeatedPassword
    )
}


@Composable
@Preview
fun SignupPasswordScreenImpl(
    state: PasswordUiState = PasswordUiState.INITIAL_STATE,
    navigateToNickname: () -> Unit = {},
    validatePassword: (String) -> Unit = {},
    validateRepeatedPassword: (String, String) -> Unit = { _, _ ->
    }
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MoodTheme.color.white)
            .padding(all = 16.dp)
    ) {
        MoodText(text = "사용할 비밀번호를 입력해주세요", style = MoodTheme.typography.headline.headline7.bold)
        VerticalSpacer(height = 4.dp)
        MoodText(
            text = "영문 대소문자, 숫자, 특수문자를 포함해\n8자 이상으로 작성해주세요. ",
            style = MoodTheme.typography.body.body2.regular,
            color = MoodTheme.color.gray600
        )
        VerticalSpacer(height = 28.dp)
        TextInput(
            value = state.password,
            placeholder = "비밀번호를 입력해주세요.",
            onValueChange = validatePassword,
            isNecessary = false,
            label = "비밀번호",
            helperText = "영문, 대소문자, 숫자, 특수문자 포함 8자 이상",
            isHelperTextVisible = state.isSuccess?.let { !it } ?: false,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )
        VerticalSpacer(height = 28.dp)
        TextInput(
            value = state.repeatedPassword,
            placeholder = "비밀번호를 한번 더 입력해주세요.",
            onValueChange = { validateRepeatedPassword(state.password, it) },
            isNecessary = false,
            label = "비밀번호 확인",
            helperText = "비밀번호가 일치하지 않습니다.",
            isHelperTextVisible = state.isRepeatedPasswordSuccess?.let { !it } ?: false,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )
        VerticalSpacer(modifier = Modifier.weight(1f), height = 0.dp)
        BtnSolidLarge(
            onClick = navigateToNickname,
            text = "다음",
            modifier = Modifier
                .fillMaxWidth()
                .clip(MoodRadius.Radius12.shape),
            enabled = state.isSuccess == true && state.isRepeatedPasswordSuccess == true && (state.password == state.repeatedPassword)
        )
    }
}