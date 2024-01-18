package com.uoa.sensordatacollection.domain.usecase

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@HiltWorker
class SensorWorkerUseCase @AssistedInject constructor(
    @Assisted private val appContext: Context,
    @Assisted private val params: WorkerParameters,
    @Assisted private val autoStartAndCollectSensorsUseCase: AutoStartAndCollectSensorsUseCase


    // Add other sensors as needed
) : CoroutineWorker(appContext, params) {

    private var driverProfileID: Long= -1
    private var continueSensors:Boolean=false
    private var max_retry: Int=1
    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
//            val driverProfileId = inputData.getLong(DRIVER_PROFILE_ID_KEY, -1)

            // Call the suspend function within a coroutine scope

            if (continueSensors) {
                autoStartAndCollectSensorsUseCase.execute(driverProfileID)
            }
                Result.success()
        } catch (e: Exception) {
            val retryAttempts=runAttemptCount-1

            if(retryAttempts < max_retry){
                Log.e("SensorWorker", "Retry work. Attempt: ${retryAttempts}")
                Result.retry()
            }
            else {
                // Handle exceptions as needed
                Log.e("SensorStartError", "Error Starting and collecting Data ${e.message}")
                Result.failure()
            }
        }
    }

    suspend fun sensors_startWork(liveCycleOwner: LifecycleOwner,driverProfileId: Long, continueSensors: Boolean): String {
        this.driverProfileID=driverProfileId
        this.continueSensors=continueSensors
        this.max_retry=max_retry
        val workManager: WorkManager=WorkManager.getInstance(appContext)
        val sensorStartWorkRequest= OneTimeWorkRequestBuilder<SensorWorkerUseCase>()
            .setInputData(workDataOf(DRIVER_PROFILE_ID_KEY to driverProfileID,
                CONTINUEWORK to continueSensors,
                MAX_RETRY_COUNT to max_retry))
            .build()
        var workerState: String=""
        workManager.enqueue(sensorStartWorkRequest)
        workManager.getWorkInfoByIdLiveData(sensorStartWorkRequest.id)
            .observe(liveCycleOwner, Observer {
                workerState=it.state.name
            })
        return workerState
    }

    companion object {
        const val DRIVER_PROFILE_ID_KEY = "driver_profile_id"
        const val CONTINUEWORK="continueSensors"
        const val MAX_RETRY_COUNT="MAX_RETRY_COUNT"
    }
}