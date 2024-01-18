package com.uoa.deviceprofile.data.datasources.moduleproviders

import com.uoa.deviceprofile.data.dao.DriverProfileDao
import com.uoa.deviceprofile.data.datasources.LocalDataSource
import com.uoa.sdaapp.db.Sdaapp
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
    fun provideDriverProfileDao(appDatabase: Sdaapp): DriverProfileDao {
        return appDatabase.driverProfile()
    }

    @Provides
    @Singleton
    fun provideLocalDatSource(driverProfileDao: DriverProfileDao): LocalDataSource {
        return LocalDataSource(driverProfileDao)
    }


}