package com.uoa.sensordatacollection.domain.usecase.trip

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
import com.uoa.sensordatacollection.data.datasources.local.LocalTripDataRepository
import com.uoa.sensordatacollection.domain.Mapper
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit

@HiltWorker
class SyncTripData @AssistedInject constructor(
    @Assisted private val appContext: Context,
    @Assisted private val params: WorkerParameters,
    @Assisted private val localTripRepository: LocalTripDataRepository,
    @Assisted private val saveStartTripDataRemoteUseCase: SaveStartTripDataRemoteUseCase,
    @Assisted private val updateTripRemoteUseCase: UpdateTripRemoteUseCase
) : CoroutineWorker(appContext, params) {
    private var synced=inputData.getBoolean(SYNCED,false)
    private var workName=inputData.getString(WORK_NAME)
    private var max_retry: Int=1
    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            // Retrieve new sensor data from the local database
            val newTripData = localTripRepository.getNewTripData(synced)

            if (newTripData.isNotEmpty()){
                newTripData.forEach { tripData ->

                    if (tripData.endTime==null)
                        saveStartTripDataRemoteUseCase.execute(Mapper.convertTripEntityToDomainModel(tripData))
                    else
                        updateTripRemoteUseCase.execute(tripData.id,Mapper.convertTripEntityToDomainModel(tripData))
                }
                Result.success()
            }
            else
                Result.success()
        } catch (e: Exception) {
            // Handle exceptions as needed

            val retryAttempts=runAttemptCount-1

            if(retryAttempts < max_retry){
                Log.e("SensorWorker", "Retry work. Attempt: ${retryAttempts}")
                Result.retry()
            }
            else {
                // Handle exceptions as needed
                Log.e("SensorSyncError", "Error Syncing Sensor Data ${e.message}")
                Result.failure()
            }
        }
    }

    suspend fun saveTripDataRemote(liveCycleOwner: LifecycleOwner, sync: Boolean, workName:String, max_retry: Int): String{
        this.synced=sync
        this.workName=workName
        var workerState: String=""
        this.max_retry=max_retry
        val workManager: WorkManager = WorkManager.getInstance(appContext)

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED) // Ensure there's an internet connection
            .build()

        val saveTripDataRemoteRequest= PeriodicWorkRequestBuilder<SyncTripData>(5, TimeUnit.MINUTES)
            .setInputData(workDataOf(SYNCED to synced, WORK_NAME to workName,
                MAX_RETRY_COUNT to max_retry))
            .setConstraints(constraints)
            .build()

        workManager.enqueue(saveTripDataRemoteRequest)

        workManager.getWorkInfoByIdLiveData(saveTripDataRemoteRequest.id)
            .observe(liveCycleOwner, Observer {
                workerState=it.state.name
            })
        return workerState

    }

    companion object {
        const val WORK_NAME = "RemoteTripDataWorker"
        const val SYNCED="SYNCED"
        const val MAX_RETRY_COUNT="MAX_RETRY_COUNT"
    }
}