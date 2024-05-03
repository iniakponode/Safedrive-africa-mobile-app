package com.uoa.deviceprofile.data.datasources.moduleproviders

import com.uoa.core.appApiService.DriverProfileApiService
import com.uoa.core.appApiService.RetrofitInstance
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
    fun provideDriverProfileApiSensorService(): DriverProfileApiService {
        return RetrofitInstance.getRetrofitInstance().create(DriverProfileApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(driverProfileApiService: DriverProfileApiService): RemoteDataSource {
        return RemoteDataSource(driverProfileApiService)
    }

}