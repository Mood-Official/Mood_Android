package com.android.mood.onboard.login.screen.signupnickname

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.mood.designsystem.component.bottomsheet.DatePickerBottomSheet
import com.android.mood.designsystem.component.button.BtnSolidLarge
import com.android.mood.designsystem.component.spacer.VerticalSpacer
import com.android.mood.designsystem.component.text.MoodText
import com.android.mood.designsystem.component.textinput.TextInput
import com.android.mood.designsystem.component.textinput.internal.MoodTextFieldState
import com.android.mood.designsystem.foundation.MoodRadius
import com.android.mood.designsystem.foundation.MoodTheme
import com.android.mood.onboard.login.screen.signupnickname.state.NickNameUiState
import kotlinx.coroutines.launch

@Composable
fun SignupNicknameScreen(
    state: NickNameUiState,
    navigateToPhone: () -> Unit,
    validateName: (String) -> Unit = {},
    validateBirthday: (String) -> Unit = {},
    validateNickName: (String) -> Unit = {},
    inputName: (String) -> Unit = {},
    inputBirthday: (String) -> Unit = {},
    inputNickName: (String) -> Unit = {},
) {
    SignupNicknameScreenImpl(
        state = state,
        navigateToPhone = navigateToPhone,
        validateName = validateName,
        validateBirthday = validateBirthday,
        validateNickName = validateNickName,
        inputName = inputName,
        inputBirthday = inputBirthday,
        inputNickName = inputNickName,
    )
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun SignupNicknameScreenImpl(
    state: NickNameUiState = NickNameUiState.INITIAL_STATE,
    navigateToPhone: () -> Unit = {},
    validateName: (String) -> Unit = {},
    validateBirthday: (String) -> Unit = {},
    validateNickName: (String) -> Unit = {},
    inputName: (String) -> Unit = {},
    inputBirthday: (String) -> Unit = {},
    inputNickName: (String) -> Unit = {},
) {
    val focusRequester = remember { FocusRequester() }
    val focusRequester2 = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState =
        rememberModalBottomSheetState(
            initialValue = ModalBottomSheetValue.Hidden, skipHalfExpanded = true
        )
    val hideBottomSheet: () -> Unit = {
        coroutineScope.launch { bottomSheetState.hide() }
    }

    LaunchedEffect(state) {
        if (state.isNicknameSuccess == true) {
            focusManager.clearFocus()
        } else if (state.isBirthdaySuccess == true) {
            focusRequester2.requestFocus()
        } else if (state.isNameSuccess == true) {
            focusManager.clearFocus()
            bottomSheetState.show()
        } else if (state.isNameSuccess == false) {
            focusRequester.requestFocus()
        }
    }
    ModalBottomSheetLayout(
        sheetContent = {
            DatePickerBottomSheet(
                modifier = Modifier.background(MoodTheme.color.white).height(450.dp),
                onClick = { year, month, date ->
                    hideBottomSheet()
                    inputBirthday("$year.$month.$date")
                }
            )
        },
        sheetState = bottomSheetState,
        sheetShape = MoodRadius.Radius12.shape
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MoodTheme.color.white)
                .padding(all = 16.dp)
        ) {
            MoodText(text = "이름을 입력해주세요", style = MoodTheme.typography.headline.headline7.bold)
            VerticalSpacer(height = 4.dp)
            MoodText(
                text = "본인 인증을 위해 실명으로 입력해주세요",
                style = MoodTheme.typography.body.body2.regular,
                color = MoodTheme.color.gray600
            )
            if (state.isNameSuccess == true && state.isBirthdaySuccess == true) {
                VerticalSpacer(height = 28.dp)
                TextInput(
                    modifier = Modifier.focusRequester(focusRequester2),
                    value = state.nickname,
                    placeholder = "닉네임을 입력해주세요",
                    onValueChange = inputNickName,
                    isNecessary = false,
                    label = "닉네임",
                    helperText = "닉네임 규칙을 지켜주세요",
                    isHelperTextVisible = state.isNicknameSuccess?.let { !it } ?: false,
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = { validateNickName(state.nickname) }),
                )
            }
            if (state.isNameSuccess == true) {
                VerticalSpacer(height = 28.dp)
                TextInput(
                    modifier = Modifier.clickable { coroutineScope.launch { bottomSheetState.show() } },
                    state = MoodTextFieldState.READ_ONLY,
                    value = state.birthday,
                    placeholder = "생년월일을 입력해주세요",
                    onValueChange = { },
                    isNecessary = false,
                    label = "생년월일",
                    helperText = "생년월일을 입력해주세요",
                    isHelperTextVisible = state.isBirthdaySuccess?.let { !it } ?: false,
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = { validateBirthday(state.birthday) }),
                )
            }
            VerticalSpacer(height = 28.dp)
            TextInput(
                modifier = Modifier.focusRequester(focusRequester),
                value = state.name,
                placeholder = "이름을 입력해주세요.",
                onValueChange = inputName,
                isNecessary = false,
                label = "이름",
                helperText = "이름을 입력해주세요.",
                isHelperTextVisible = state.isNameSuccess?.let { !it } ?: false,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { validateName(state.name) }),
            )
            VerticalSpacer(modifier = Modifier.weight(1f), height = 0.dp)
            BtnSolidLarge(
                onClick = navigateToPhone,
                text = "다음",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(MoodRadius.Radius12.shape),
                enabled = state.isNicknameSuccess == true && state.isNameSuccess == true && state.isBirthdaySuccess == true
            )
        }
    }
}