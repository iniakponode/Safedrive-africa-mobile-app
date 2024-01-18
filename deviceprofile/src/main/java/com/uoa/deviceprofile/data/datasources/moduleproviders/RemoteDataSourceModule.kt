package com.uoa.deviceprofile.data.datasources.moduleproviders

import com.uoa.deviceprofile.data.api.DriverProfileApiService
import com.uoa.deviceprofile.data.datasources.RemoteDataSource
import com.uoa.sdaapp.appApiService.RetrofitInstance
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
    fun provideDriverProfileApiSensorService(): DriverProfileApiService{
        return RetrofitInstance.getRetrofitInstance().create(DriverProfileApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(driverProfileApiService: DriverProfileApiService): RemoteDataSource{
        return RemoteDataSource(driverProfileApiService)
    }

}