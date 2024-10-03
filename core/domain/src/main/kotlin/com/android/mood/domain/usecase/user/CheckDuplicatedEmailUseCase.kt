package com.android.mood.domain.usecase.user

import com.android.mood.domain.repository.UserRepository
import javax.inject.Inject

interface CheckDuplicatedEmailUseCase {
    suspend fun execute(email: String): Boolean
}

internal class CheckDuplicatedEmailUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : CheckDuplicatedEmailUseCase {
    override suspend fun execute(email: String): Boolean {
        return userRepository.checkDuplicatedEmail(email)
    }
}