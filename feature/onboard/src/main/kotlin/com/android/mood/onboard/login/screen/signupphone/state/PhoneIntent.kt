package com.android.mood.onboard.login.screen.signupphone.state

import com.android.mood.common.android.base.UiIntent

sealed class PhoneIntent : UiIntent {
    data object ClickNextButton : PhoneIntent()
    data class InputPhone(val phone: String) : PhoneIntent()
    data class InputCertificationNumber(val certificationNumber: String) : PhoneIntent()
    data class ValidateCertificationNumber(val certificationNumber: String) : PhoneIntent()
    data class ValidatePhone(val phone: String) : PhoneIntent()
}