package com.uoa.sensordatacollection.domain.usecase

import android.content.Context
import android.util.Log
import com.uoa.sensordatacollection.domain.usecase.trip.StartTripUseCase
import javax.inject.Inject

class AutoStartAndCollectSensorsUseCase @Inject constructor(
    private val appContext: Context,
    private val significantMotionSensorStartUseCase: SignificantMotionSensorStartUseCase,
    private val startSensorUseCase: StartSensorUseCase,
    private val startTripUseCase: StartTripUseCase,

    private val collectSensorReadingsUseCase: CollectSensorReadingsUseCase
) {

    suspend fun execute(
        driverProfileId: Long
    ){
            // Check for significant motion
            val significantMotionDetected = significantMotionSensorStartUseCase.execute()

            // If significant motion is detected, collect sensor readings
            if (significantMotionDetected) {
                // Start sensors if not already started
                val sensorsStarted=startSensorUseCase.execute(driverProfileId, appContext)

                if (!sensorsStarted) {
                    Log.e("SensorsNotStarted", "Sensors not Started")
                }

                val tripData=startTripUseCase.execute(driverProfileId)
                // Collect sensor readings for 5 minutes at 500Hz
                collectSensorReadingsUseCase.execute(tripData)
            } else {
                // Stop sensors if significant motion is not detected

            }

    }
}