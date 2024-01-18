package com.uoa.sensordatacollection.modulesprovider

import android.app.Application
import com.uoa.sensordatacollection.data.TrackingSensor
import com.uoa.sensordatacollection.data.datasources.hardware.AccelerometerSensor
import com.uoa.sensordatacollection.data.datasources.hardware.GyroscopeSensor
import com.uoa.sensordatacollection.data.datasources.hardware.LinearAcceleration
import com.uoa.sensordatacollection.data.datasources.hardware.MagnetometerSensor
import com.uoa.sensordatacollection.data.datasources.hardware.RotationVectorSensor
import com.uoa.sensordatacollection.data.datasources.hardware.SignificantMotion
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SensorsModule {
    @Provides
    @Singleton
    @AccelerometerSensorM
    fun provideAccelerometerSensor(app: Application): TrackingSensor {
        return AccelerometerSensor(app)
    }

    @Provides
    @Singleton
    @GyroscopeSensorM
    fun provideGyroscopeSensor(app: Application): TrackingSensor{
        return GyroscopeSensor(app)
    }


    @Provides
    @Singleton
    @LinearAccelerationM
    fun provideLinearAcceleration(app: Application): TrackingSensor{
        return LinearAcceleration(app)
    }


    @Provides
    @Singleton
    @RotationVectorSensorM
    fun provideRotationVectorSensor(app: Application): TrackingSensor{
        return RotationVectorSensor(app)
    }

    @Provides
    @Singleton
    @MagnetometerSensorM
    fun provideMagnetometerSensor(app: Application): TrackingSensor{
        return MagnetometerSensor(app)
    }

    @Provides
    @Singleton
    @SignificantMotionSensorM
    fun provideSignificantMotionSensor(app: Application): TrackingSensor{
        return SignificantMotion(app)
    }

}


@Qualifier
annotation class RotationVectorSensorM

@Qualifier
annotation class MagnetometerSensorM
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AccelerometerSensorM

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class GyroscopeSensorM

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LinearAccelerationM

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class SignificantMotionSensorM
