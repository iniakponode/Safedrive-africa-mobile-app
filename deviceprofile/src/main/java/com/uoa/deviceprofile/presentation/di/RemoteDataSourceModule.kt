package com.uoa.deviceprofile.presentation.di

import com.uoa.deviceprofile.data.datasources.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {
    @Provides
    @Singleton
    fun provideDriverProfileApiSensorService(): com.uoa.co.appApiService.DriverProfileApiService {
        return com.uoa.co.appApiService.RetrofitInstance.getRetrofitInstance().create(com.uoa.co.appApiService.DriverProfileApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(driverProfileApiService: com.uoa.co.appApiService.DriverProfileApiService): RemoteDataSource {
        return RemoteDataSource(driverProfileApiService)
    }

}