package com.uoa.sensordatacollection.modulesprovider

import com.uoa.sensordatacollection.data.dao.SensorDao
import com.uoa.sensordatacollection.data.datasources.local.LocalSensorDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun provideLocalSensorDataSource(sensorDataDao: SensorDao): LocalSensorDataSource {
        return LocalSensorDataSource(sensorDataDao)
    }
}
