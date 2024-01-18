package com.uoa.sensordatacollection.modulesprovider

import com.uoa.sensordatacollection.data.datasources.local.LocalSensorDataSource
import com.uoa.sensordatacollection.data.datasources.local.LocalSensorRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalSensorRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindLocalSensorRepository(localDatasource: LocalSensorDataSource): LocalSensorRepository
}