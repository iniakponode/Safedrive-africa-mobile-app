package com.uoa.sensordatacollection.modulesprovider

import com.uoa.sensordatacollection.data.AndroidSensor
import com.uoa.sensordatacollection.data.TrackingSensor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

abstract class TrackingSensorModule {
    @Binds
    @Singleton
    abstract fun bindTrackingSensor(androidSensor: AndroidSensor): TrackingSensor
}