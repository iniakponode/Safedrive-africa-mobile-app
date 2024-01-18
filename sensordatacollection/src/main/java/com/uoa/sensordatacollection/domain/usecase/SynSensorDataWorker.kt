package com.uoa.sensordatacollection.domain.usecase

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import androidx.work.workDataOf
//import com.uoa.sdaapp.domain.util.Result
import com.uoa.sensordatacollection.data.datasources.local.LocalSensorRepository
import com.uoa.sensordatacollection.domain.usecase.trip.SyncTripData

import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit

@HiltWorker
class SyncSensorDataWorker @AssistedInject constructor(
    @Assisted private val appContext: Context,
    @Assisted private val params: WorkerParameters,
    @Assisted private val localSensorRepository: LocalSensorRepository,
    @Assisted private val saveToRemoteUseCase: SaveSensorDataToRemoteDBUseCase
) : CoroutineWorker(appContext, params) {

    private var synced=inputData.getBoolean(SyncTripData.SYNCED,false)
    private var workName=inputData.getString(SyncTripData.WORK_NAME)
    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            // Retrieve new sensor data from the local database
            val newSensorData = localSensorRepository.getNewSensorData(synced)

            if (newSensorData.isNotEmpty()){
                // Send new sensor data to the remote server
                newSensorData.forEach { sensorData ->
                    saveToRemoteUseCase.execute(sensorData)
                }

                Result.success()
            }
            Result.success()

        } catch (e: Exception) {
            // Handle exceptions as needed
           Result.retry()
        }
        catch (e: Exception){
            Log.e("SensorSyncError", "Error Syncing Sensor Data ${e.message}")
            Result.failure()
        }
    }

    suspend fun saveSensorDataToRemoteWork(liveCycleOwner: LifecycleOwner, sync: Boolean, workName:String): String{
        this.synced=sync
        this.workName=workName
        val workManager: WorkManager = WorkManager.getInstance(appContext)
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED) // Ensure there's an internet connection
            .build()

        val saveSensorDataToRemoteWorkRequest= PeriodicWorkRequestBuilder<SyncSensorDataWorker>(5, TimeUnit.MINUTES)
            .setInputData(workDataOf(SYNCED to synced,
                WORK_NAME to workName))
            .setConstraints(constraints)
            .build()
        var workerState: String=""

        workManager.enqueue(saveSensorDataToRemoteWorkRequest)

        workManager.getWorkInfoByIdLiveData(saveSensorDataToRemoteWorkRequest.id)
            .observe(liveCycleOwner, Observer {
                workerState=it.state.name
            })
        return workerState

    }

    companion object {
        const val WORK_NAME = "SyncSensorDataWorker"
        const val SYNCED="SYNCED"
    }
}
