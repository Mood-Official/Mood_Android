package com.android.mood.feature.sample.di

import com.android.mood.feature.sample.navigator.SampleNavigatorImpl
import com.android.mood.navigator.SampleNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
internal abstract class SampleNavigatorModule {

    @Binds
    @ActivityScoped
    abstract fun bindSampleNavigator(impl: SampleNavigatorImpl): SampleNavigator
}