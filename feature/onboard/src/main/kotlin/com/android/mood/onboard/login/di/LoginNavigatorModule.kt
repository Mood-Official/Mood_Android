package com.android.mood.onboard.login.di

import com.android.mood.navigator.LoginNavigator
import com.android.mood.onboard.login.navigator.LoginNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
internal abstract class LoginNavigatorModule {
    @Binds
    @ActivityScoped
    abstract fun bindLoginNavigator(impl: LoginNavigatorImpl): LoginNavigator
}