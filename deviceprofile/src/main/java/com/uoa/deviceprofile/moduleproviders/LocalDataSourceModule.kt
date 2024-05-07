package com.uoa.deviceprofile.moduleproviders

import com.uoa.co.db.dao.DriverProfileDao
import com.uoa.deviceprofile.data.datasources.LocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule{

    @Provides
    @Singleton
    fun provideLocalDatSource(driverProfileDao: com.uoa.co.db.dao.DriverProfileDao): LocalDataSource {
        return LocalDataSource(driverProfileDao)
    }


}