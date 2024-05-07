package com.uoa.sensordatacollection.modulesprovider

import com.uoa.co.db.dao.SensorDao
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
    fun provideLocalSensorDataSource(sensorDataDao: com.uoa.co.db.dao.SensorDao): LocalSensorDataSource {
        return LocalSensorDataSource(sensorDataDao)
    }
}
