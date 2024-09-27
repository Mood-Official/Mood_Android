package com.android.mood.navigation.di

import com.android.mood.navigation.navigator.MainNavigatorImpl
import com.android.mood.navigator.MainNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
internal abstract class MainNavigatorModule {
    @Binds
    @ActivityScoped
    abstract fun bindMainNavigator(impl: MainNavigatorImpl): MainNavigator
}