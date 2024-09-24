package com.android.mood.domain.usecase.validation

import javax.inject.Inject

interface ValidatePasswordUseCase {
    fun execute(password: String): Boolean
    fun checkRepeatedPassword(password: String, repeatedPassword: String): Boolean
}

internal class ValidatePasswordUseCaseImpl @Inject constructor(
) : ValidatePasswordUseCase {

    override fun execute(password: String): Boolean {
        if (password.length < 8) return false

        val containsLowerCase = password.any { it.isLowerCase() }
        val containsUpperCase = password.any { it.isUpperCase() }
        val containsDigit = password.any { it.isDigit() }
        val containsSpecialCharacter = password.any { !it.isLetterOrDigit() }

        return containsLowerCase && containsUpperCase && containsDigit && containsSpecialCharacter
    }

    override fun checkRepeatedPassword(password: String, repeatedPassword: String): Boolean {
        return password == repeatedPassword
    }
}