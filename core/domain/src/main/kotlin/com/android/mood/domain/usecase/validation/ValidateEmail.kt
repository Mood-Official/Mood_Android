package com.android.mood.domain.usecase.validation

import androidx.core.util.PatternsCompat
import javax.inject.Inject

interface ValidateEmailUseCase {
    fun execute(email: String): Boolean?
}

internal class ValidateEmailUseCaseImpl @Inject constructor(
) : ValidateEmailUseCase {

    override fun execute(email: String): Boolean? {
        if (email.isBlank()) return null
        if (!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()) return false
        return true
    }


}