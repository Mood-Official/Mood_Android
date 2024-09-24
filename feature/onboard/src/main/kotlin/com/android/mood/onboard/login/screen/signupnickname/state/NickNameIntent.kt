package com.android.mood.onboard.login.screen.signupnickname.state

import com.android.mood.common.android.base.UiIntent

sealed class NickNameIntent : UiIntent {
    data object ClickNextButton : NickNameIntent()
    data class ValidateName(val name: String) : NickNameIntent()
    data class ValidateBirthday(val birthday: String) : NickNameIntent()
    data class ValidateNickName(val nickname: String) : NickNameIntent()
    data class InputName(val name: String) : NickNameIntent()
    data class InputBirthday(val birthday: String) : NickNameIntent()
    data class InputNickName(val nickname: String) : NickNameIntent()
}