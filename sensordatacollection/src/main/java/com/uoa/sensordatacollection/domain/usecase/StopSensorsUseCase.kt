package com.uoa.sensordatacollection.domain.usecase

import android.content.Context
import android.util.Log
import com.uoa.sensordatacollection.data.TrackingSensor
import com.uoa.sensordatacollection.modulesprovider.AccelerometerSensorM
import com.uoa.sensordatacollection.modulesprovider.GyroscopeSensorM
import com.uoa.sensordatacollection.modulesprovider.LinearAccelerationM
import com.uoa.sensordatacollection.modulesprovider.MagnetometerSensorM
import com.uoa.sensordatacollection.modulesprovider.RotationVectorSensorM
import javax.inject.Inject

class StopSensorsUseCase @Inject constructor(
    private val showNotificationUseCase: ShowNotificationUseCase,
    @AccelerometerSensorM
    private val accelerometerSensor: TrackingSensor,
    @GyroscopeSensorM
    private val gyroscopeSensor: TrackingSensor,
    @LinearAccelerationM
    private val linearAcceleration: TrackingSensor,
    @RotationVectorSensorM
    private val rotationVectorSensor: TrackingSensor,
    @MagnetometerSensorM
    private val magnetometerSensor: TrackingSensor
) {

    fun execute(context:Context): Boolean {
        return try {
            showNotificationUseCase.execute("Sensors Stopping....", context)
            accelerometerSensor.stopListeningToSensor()
            gyroscopeSensor.stopListeningToSensor()
            linearAcceleration.stopListeningToSensor()
            rotationVectorSensor.stopListeningToSensor()
            magnetometerSensor.stopListeningToSensor()
            // Stop other sensors as needed
            true
        }
        catch (e: Exception){
            Log.e("StopSensorUsecase","Error starting sensor: ${e.message}")
            false
        }

    }
}