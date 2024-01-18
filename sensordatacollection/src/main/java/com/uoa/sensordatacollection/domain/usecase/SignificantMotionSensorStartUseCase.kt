package com.uoa.sensordatacollection.domain.usecase

import android.util.Log
import com.uoa.sensordatacollection.data.TrackingSensor
import com.uoa.sensordatacollection.modulesprovider.SignificantMotionSensorM
import javax.inject.Inject

class SignificantMotionSensorStartUseCase @Inject constructor(
    @SignificantMotionSensorM private val significantMotionSensor: TrackingSensor
) {
    fun execute(): Boolean{
        return try {
            significantMotionSensor.startListeningToSensor(500)
            true
        }
        catch (e: Exception){
            Log.e("SignificantMotionSensorUseCase", "Error Starting Significant Motion Sensor: ${e.message}")
            false
        }

    }
}