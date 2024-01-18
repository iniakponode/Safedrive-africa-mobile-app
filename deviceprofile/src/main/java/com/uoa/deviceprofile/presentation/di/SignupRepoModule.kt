package com.uoa.deviceprofile.presentation.di

import com.uoa.deviceprofile.data.repoImplementations.DriverProfileSignupRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
abstract class SignupRepoModule {
    @Binds
    @Singleton
    abstract  fun bindSignupRepository(signupRepoImpl: DriverProfileSignupRepoImpl): SignupRepoModule
}