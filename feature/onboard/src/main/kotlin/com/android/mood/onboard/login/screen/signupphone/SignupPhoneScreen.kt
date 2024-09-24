package com.android.mood.onboard.login.screen.signupphone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.mood.designsystem.component.button.BtnPrimaryTextMedium
import com.android.mood.designsystem.component.button.BtnSolidLarge
import com.android.mood.designsystem.component.spacer.VerticalSpacer
import com.android.mood.designsystem.component.text.MoodText
import com.android.mood.designsystem.component.textinput.TextInput
import com.android.mood.designsystem.foundation.MoodRadius
import com.android.mood.designsystem.foundation.MoodTheme
import com.android.mood.onboard.login.screen.signupphone.state.PhoneUiState

@Composable
fun SignupPhoneScreen(
    state: PhoneUiState,
    navigateToAgree: () -> Unit,
    inputPhone: (String) -> Unit,
    inputCertification: (String) -> Unit,
    validatePhone: (String) -> Unit,
    validateCertification: (String) -> Unit,
) {
    SignupPhoneScreenImpl(
        state = state,
        navigateToAgree = navigateToAgree,
        validatePhone = validatePhone,
        inputPhone = inputPhone,
        inputCertification = inputCertification,
        validateCertification = validateCertification,
    )
}


@Composable
@Preview
fun SignupPhoneScreenImpl(
    state: PhoneUiState = PhoneUiState.INITIAL_STATE,
    navigateToAgree: () -> Unit = {},
    inputPhone: (String) -> Unit = {},
    inputCertification: (String) -> Unit = {},
    validatePhone: (String) -> Unit = {},
    validateCertification: (String) -> Unit = {},
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MoodTheme.color.white)
            .padding(all = 16.dp)
    ) {
        MoodText(text = "전화번호를 인증해주세요", style = MoodTheme.typography.headline.headline7.bold)
        VerticalSpacer(height = 4.dp)
        MoodText(
            text = "더 안전한 커뮤니티를 위해 본인 인증이 필요해요.",
            style = MoodTheme.typography.body.body2.regular,
            color = MoodTheme.color.gray600
        )
        VerticalSpacer(height = 28.dp)
        TextInput(
            value = state.phone,
            placeholder = "휴대폰 번호를 입력해주세요.",
            onValueChange = inputPhone,
            isNecessary = false,
            label = "휴대폰 번호",
            shouldRemoveIcon = false,
            innerTrailingContent = {
                BtnPrimaryTextMedium(onClick = { validatePhone(state.phone) }, text = "인증")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
        if (state.isSuccess == true) {
            VerticalSpacer(height = 8.dp)
            TextInput(
                value = state.certificationNumber,
                placeholder = "인증번호를 입력해주세요",
                onValueChange = inputCertification,
                isNecessary = false,
                helperText = "인증번호가 일치하지 않습니다.",
                isHelperTextVisible = state.isCertificationSuccess == false,
                shouldRemoveIcon = false,
                innerTrailingContent = {
                    when (state.isCertificationSuccess) {
                        true -> {
                            Image(
                                painter = painterResource(com.android.mood.core.designsystem.R.drawable.ic_check_thickness_2_0),
                                contentDescription = "Check Icon",
                                colorFilter = ColorFilter.tint(MoodTheme.color.secondary500)
                            )
                        }

                        else -> {
                            BtnPrimaryTextMedium(
                                onClick = { validateCertification(state.certificationNumber) },
                                text = "인증하기"
                            )
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }
        VerticalSpacer(modifier = Modifier.weight(1f), height = 0.dp)
        BtnSolidLarge(
            onClick = navigateToAgree,
            text = "다음",
            modifier = Modifier
                .fillMaxWidth()
                .clip(MoodRadius.Radius12.shape),
            enabled = state.isCertificationSuccess == true
        )
    }
}