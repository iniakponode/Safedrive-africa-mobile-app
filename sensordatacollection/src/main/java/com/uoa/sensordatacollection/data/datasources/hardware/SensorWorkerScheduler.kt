package com.uoa.sensordatacollection.data.datasources.hardware

import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.uoa.sensordatacollection.domain.usecase.SensorWorkerUseCase

class SensorWorkerScheduler {
    companion object {
        // Schedule SensorWorker
        fun scheduleSensorWorker(driverProfileId: String) {
            val sensorWorkRequest = OneTimeWorkRequestBuilder<SensorWorkerUseCase>()
                .setInputData(workDataOf(SensorWorkerUseCase.DRIVER_PROFILE_ID_KEY to driverProfileId))
                .build()
            WorkManager.getInstance().enqueue(sensorWorkRequest)
        }
    }

}