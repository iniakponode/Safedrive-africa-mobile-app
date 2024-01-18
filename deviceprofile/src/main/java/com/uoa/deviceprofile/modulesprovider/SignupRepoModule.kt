package com.uoa.deviceprofile.modulesprovider

import com.uoa.deviceprofile.data.repoImplementations.DriverProfileLoginRepoImpl
import com.uoa.deviceprofile.data.repoImplementations.DriverProfileSignupRepoImpl
import com.uoa.deviceprofile.domain.repository.DriverProfileLoginRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

abstract class SignupRepoModule {
    @Binds
    @Singleton
    abstract fun bindSignupReop(
        driverProfileSignupRepoImpl: DriverProfileSignupRepoImpl
    ): DriverProfileLoginRepo
}