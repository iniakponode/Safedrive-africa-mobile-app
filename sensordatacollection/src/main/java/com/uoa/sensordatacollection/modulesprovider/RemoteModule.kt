package com.uoa.sensordatacollection.modulesprovider

//import com.uoa.sdaapp.appApiService.RetrofitInstance
import com.uoa.sensordatacollection.data.api.SensorDataApiService
import com.uoa.sensordatacollection.data.datasources.remote.RemoteSensorDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Singleton
    @Provides
    fun provideRemoteSensorDataSource(sensorDataApiService: SensorDataApiService): RemoteSensorDataSource {
        return RemoteSensorDataSource(sensorDataApiService)
    }
}
