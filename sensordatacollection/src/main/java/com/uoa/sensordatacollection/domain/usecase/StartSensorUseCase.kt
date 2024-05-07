package com.uoa.sensordatacollection.domain.usecase

import android.util.Log
import android.content.Context
import com.uoa.sensordatacollection.data.AndroidSensor
import com.uoa.sensordatacollection.data.TrackingSensor
import com.uoa.sensordatacollection.data.datasources.local.LocalSensorRepository
import com.uoa.sensordatacollection.data.datasources.remote.RemoteSensorRepository
import com.uoa.sensordatacollection.modulesprovider.AccelerometerSensorM
import com.uoa.sensordatacollection.modulesprovider.GyroscopeSensorM
import com.uoa.sensordatacollection.modulesprovider.LinearAccelerationM
import com.uoa.sensordatacollection.modulesprovider.MagnetometerSensorM
import com.uoa.sensordatacollection.modulesprovider.RotationVectorSensorM
import javax.inject.Inject

class StartSensorUseCase @Inject constructor(
    private val showNotificationUseCase: ShowNotificationUseCase,
    @AccelerometerSensorM private val accelerometerSensor: TrackingSensor,
    @GyroscopeSensorM
    private val gyroscopeSensor: TrackingSensor,
    @LinearAccelerationM
    private val linearAcceleration: TrackingSensor,
    @RotationVectorSensorM
    private val rotationVectorSensor: TrackingSensor,
    @MagnetometerSensorM
    private val magnetometerSensor: TrackingSensor
) {

    fun execute(driverProfileId: Long, context: Context): Boolean {
        return try {
            showNotificationUseCase.execute("Sensors Started....", context)
            accelerometerSensor.startListeningToSensor(500)
            gyroscopeSensor.startListeningToSensor(500)
            linearAcceleration.startListeningToSensor(500)
            rotationVectorSensor.startListeningToSensor(500)
            magnetometerSensor.startListeningToSensor(500)
            true
        } catch (e: Exception) {
            // Handle any exceptions
            Log.e("StartSensorUseCase", "Error starting sensor: ${e.message}")
            false
        }
    }
}
