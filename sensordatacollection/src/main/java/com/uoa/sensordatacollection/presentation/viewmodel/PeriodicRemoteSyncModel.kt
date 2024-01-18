package com.uoa.sensordatacollection.presentation.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uoa.sensordatacollection.domain.usecase.SyncSensorDataWorker
import com.uoa.sensordatacollection.domain.usecase.trip.SyncTripData
//import com.uoa.trip.domain.usecases.UpdateTripRemoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeriodicRemoteSyncModel @Inject constructor(
    private val syncTripData: SyncTripData,
    private val syncSensorDataWorker: SyncSensorDataWorker
): ViewModel() {

    fun syncRemoteData(liveOwner: LifecycleOwner, driverProfileId: Long, max_retry:Int) :String {
        var syncTripDataState=""
        var syncSensorDataState=""
        var result=""
        viewModelScope.launch {
            syncTripDataState = syncTripData.saveTripDataRemote(liveOwner, true, "TripDataWork", max_retry)
            if (syncTripDataState == "SUCCESS")
                syncSensorDataState = syncSensorDataWorker.saveSensorDataToRemoteWork(
                    liveOwner,
                    true,
                    "SensorDataWork"
                )
            else
                result = "FAILED"

            if (syncTripDataState == "SUCCESS" && syncSensorDataState == "SUCCESS")
                result = "SUCCESS"
        }
        return result
    }

}