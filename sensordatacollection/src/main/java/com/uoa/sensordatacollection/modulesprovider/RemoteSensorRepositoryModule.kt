package com.uoa.sensordatacollection.modulesprovider

import com.uoa.sensordatacollection.data.datasources.remote.RemoteSensorDataSource
import com.uoa.sensordatacollection.data.datasources.remote.RemoteSensorRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteSensorRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRemoteSensorRepository(remoteDatasource: RemoteSensorDataSource): RemoteSensorRepository
}