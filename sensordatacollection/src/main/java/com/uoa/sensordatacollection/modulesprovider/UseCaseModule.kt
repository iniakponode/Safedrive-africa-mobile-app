package com.uoa.sensordatacollection.modulesprovider

import android.content.Context
import androidx.work.WorkerParameters
import com.uoa.sensordatacollection.data.TrackingSensor
import com.uoa.sensordatacollection.data.datasources.local.LocalSensorRepository
import com.uoa.sensordatacollection.data.datasources.remote.RemoteSensorRepository
import com.uoa.sensordatacollection.domain.usecase.AutoStartAndCollectSensorsUseCase
import com.uoa.sensordatacollection.domain.usecase.CollectSensorReadingsUseCase
import com.uoa.sensordatacollection.domain.usecase.SaveSensorDataToLocalDatabaseUseCase
import com.uoa.sensordatacollection.domain.usecase.SaveSensorDataToRemoteDBUseCase
import com.uoa.sensordatacollection.domain.usecase.SaveSensorReadingsUseCase
import com.uoa.sensordatacollection.domain.usecase.SensorWorkerUseCase
import com.uoa.sensordatacollection.domain.usecase.ShowNotificationUseCase
import com.uoa.sensordatacollection.domain.usecase.SignificantMotionSensorStartUseCase
import com.uoa.sensordatacollection.domain.usecase.StartSensorUseCase
import com.uoa.sensordatacollection.domain.usecase.StopSensorsUseCase
import com.uoa.sensordatacollection.domain.usecase.trip.StartTripUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object UseCaseModule {

    @Provides
    @Singleton
    fun provideSaveSensorDataToLocalDatabaseUseCase(localSensorRepository: LocalSensorRepository): SaveSensorDataToLocalDatabaseUseCase{
        return SaveSensorDataToLocalDatabaseUseCase(localSensorRepository)
    }

    @Provides
    @Singleton
    fun provideSaveSensorDataToRemoteServerUseCase(remoteSensorRepository: RemoteSensorRepository):
            SaveSensorDataToRemoteDBUseCase{
        return SaveSensorDataToRemoteDBUseCase(remoteSensorRepository)
    }

    @Provides
    @Singleton
    fun provideSaveSensorReadingsUseCase(
        saveSensorDataToLocalDatabaseUseCase: SaveSensorDataToLocalDatabaseUseCase,
        saveSensorDataToRemoteDBUseCase: SaveSensorDataToRemoteDBUseCase):
            SaveSensorReadingsUseCase{
        return SaveSensorReadingsUseCase(saveSensorDataToLocalDatabaseUseCase,saveSensorDataToRemoteDBUseCase)
    }
    @Provides
    @Singleton
    fun provideSignificantMotionSensorUseCase(
        @SignificantMotionSensorM significantMotionSensor: TrackingSensor):
            SignificantMotionSensorStartUseCase{
        return SignificantMotionSensorStartUseCase(significantMotionSensor)
    }

    @Provides
    @Singleton
    fun provideCollectSensorReadingsUseCase(
        @AccelerometerSensorM accelerometerSensor: TrackingSensor,
        @GyroscopeSensorM gyroscopeSensor: TrackingSensor,
        @LinearAccelerationM linearAcceleration: TrackingSensor,
        @RotationVectorSensorM rotationVectorSensor: TrackingSensor,
        @MagnetometerSensorM magnetometerSensor: TrackingSensor,
        saveSensorReadingsUseCase: SaveSensorReadingsUseCase
    ): CollectSensorReadingsUseCase{
        return CollectSensorReadingsUseCase(
            accelerometerSensor,
            gyroscopeSensor,
            linearAcceleration,
            rotationVectorSensor,
            magnetometerSensor,
            saveSensorReadingsUseCase
            )
    }

    @Provides
    @Singleton
    fun provideShowNotificationUseCase(): ShowNotificationUseCase{
        return ShowNotificationUseCase()
    }

    @Provides
    @Singleton
    fun provideStartSensorUseCase(
        showNotificationUseCase: ShowNotificationUseCase,
        @AccelerometerSensorM accelerometerSensor: TrackingSensor,
        @GyroscopeSensorM gyroscopeSensor: TrackingSensor,
        @LinearAccelerationM linearAcceleration: TrackingSensor,
        @RotationVectorSensorM rotationVectorSensor: TrackingSensor,
        @MagnetometerSensorM magnetometerSensor: TrackingSensor,
    ): StartSensorUseCase{
        return StartSensorUseCase(
            showNotificationUseCase,
            accelerometerSensor,
            gyroscopeSensor,
            linearAcceleration,
            rotationVectorSensor,
            magnetometerSensor
        )

    }

    @Provides
    @Singleton
    fun provideStopSensorUseCase(
        showNotificationUseCase: ShowNotificationUseCase,
        @AccelerometerSensorM accelerometerSensor: TrackingSensor,
        @GyroscopeSensorM gyroscopeSensor: TrackingSensor,
        @LinearAccelerationM linearAcceleration: TrackingSensor,
        @RotationVectorSensorM rotationVectorSensor: TrackingSensor,
        @MagnetometerSensorM magnetometerSensor: TrackingSensor,
    ): StopSensorsUseCase{
        return StopSensorsUseCase(
            showNotificationUseCase,
            accelerometerSensor,
            gyroscopeSensor,
            linearAcceleration,
            rotationVectorSensor,
            magnetometerSensor
        )

    }

    @Provides
    @Singleton
    fun provideAutoStartAndStopSensorUseCase(
        context: Context,
        significantMotionSensorStartUseCase: SignificantMotionSensorStartUseCase,
        startSensorUseCase: StartSensorUseCase,
        startTripUseCase: StartTripUseCase,
        collectSensorReadingsUseCase: CollectSensorReadingsUseCase):
            AutoStartAndCollectSensorsUseCase{
        return AutoStartAndCollectSensorsUseCase(
            context,
            significantMotionSensorStartUseCase,
            startSensorUseCase,
            startTripUseCase,
            collectSensorReadingsUseCase
            )
    }

    @Provides
    @Singleton
    fun provideSensorWorkerUseCase(
        appContext: Context,
        params: WorkerParameters,
        autoStartAndCollectSensorsUseCase: AutoStartAndCollectSensorsUseCase
    ): SensorWorkerUseCase {
        return  SensorWorkerUseCase(appContext, params, autoStartAndCollectSensorsUseCase)
    }
}