package com.android.mood.domain.di

import com.android.mood.domain.usecase.SampleUseCase
import com.android.mood.domain.usecase.SampleUseCaseImpl
import com.android.mood.domain.usecase.user.CheckDuplicatedEmailUseCase
import com.android.mood.domain.usecase.user.CheckDuplicatedEmailUseCaseImpl
import com.android.mood.domain.usecase.validation.ValidateEmailUseCase
import com.android.mood.domain.usecase.validation.ValidateEmailUseCaseImpl
import com.android.mood.domain.usecase.validation.ValidateNameUseCase
import com.android.mood.domain.usecase.validation.ValidateNameUseCaseImpl
import com.android.mood.domain.usecase.validation.ValidateNickNameUseCase
import com.android.mood.domain.usecase.validation.ValidateNickNameUseCaseImpl
import com.android.mood.domain.usecase.validation.ValidatePasswordUseCase
import com.android.mood.domain.usecase.validation.ValidatePasswordUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class UseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun bindSampleUseCase(impl: SampleUseCaseImpl): SampleUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindValidateEmailUseCase(impl: ValidateEmailUseCaseImpl): ValidateEmailUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindValidateNameUseCase(impl: ValidateNameUseCaseImpl): ValidateNameUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindValidateNickNameUseCase(impl: ValidateNickNameUseCaseImpl): ValidateNickNameUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindValidatePasswordUseCase(impl: ValidatePasswordUseCaseImpl): ValidatePasswordUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindCheckDuplicatedEmailUseCase(impl: CheckDuplicatedEmailUseCaseImpl): CheckDuplicatedEmailUseCase
}