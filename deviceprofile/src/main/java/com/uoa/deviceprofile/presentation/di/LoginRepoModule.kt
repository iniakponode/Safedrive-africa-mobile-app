package com.uoa.deviceprofile.presentation.di

import com.uoa.deviceprofile.data.repoImplementations.DriverProfileLoginRepoImpl
import com.uoa.deviceprofile.data.repository.DriverProfileLoginRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@Singleton
@InstallIn(ViewModelComponent::class)

abstract class LoginRepoModule {

    @Binds
    @Singleton
    abstract fun bindLoginRepo(loginRepoImpl: DriverProfileLoginRepoImpl): DriverProfileLoginRepo
}