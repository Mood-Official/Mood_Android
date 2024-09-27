package com.android.mood.domain.usecase.validation

import javax.inject.Inject

interface ValidateNameUseCase {
    fun execute(name: String): Boolean
}

internal class ValidateNameUseCaseImpl @Inject constructor(
) : ValidateNameUseCase {

    override fun execute(name: String): Boolean {
        if (name.length !in NAME_MIN_RANGE..NAME_MAX_RANGE) return false
        if (name.isBlank()) return false
        val containsOnlyValidCharacters =
            name.all { it.isLetter() || it.isWhitespace() || it in '가'..'힣' }
        return containsOnlyValidCharacters
    }

    companion object {
        private const val NAME_MIN_RANGE = 2
        private const val NAME_MAX_RANGE = 20
    }
}