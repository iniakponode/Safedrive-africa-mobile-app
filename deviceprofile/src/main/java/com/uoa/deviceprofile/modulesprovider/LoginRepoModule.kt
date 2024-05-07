package com.uoa.deviceprofile.modulesprovider

import com.uoa.deviceprofile.data.repository.DriverProfileLoginRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

abstract class LoginRepoModule {

    @Binds
    @Singleton
    abstract fun bindDriverProfileLoginRepo(driverProfileLoginRepo: DriverProfileLoginRepo): DriverProfileLoginRepo
}