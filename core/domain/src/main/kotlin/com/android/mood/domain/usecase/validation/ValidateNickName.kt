package com.android.mood.domain.usecase.validation

import javax.inject.Inject

interface ValidateNickNameUseCase {
    fun execute(nickname: String): Boolean
}

internal class ValidateNickNameUseCaseImpl @Inject constructor(
) : ValidateNickNameUseCase {

    override fun execute(nickname: String): Boolean {
        if (nickname.length !in NAME_MIN_RANGE..NAME_MAX_RANGE) return false
        if (nickname.isBlank()) return false
        val containsOnlyValidCharacters = nickname.all { it.isLetterOrDigit() || it in '가'..'힣' }
        return containsOnlyValidCharacters
    }

    companion object {
        private const val NAME_MIN_RANGE = 2
        private const val NAME_MAX_RANGE = 20
    }
}