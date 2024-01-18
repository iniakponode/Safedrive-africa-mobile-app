package com.uoa.sensordatacollection.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uoa.sensordatacollection.domain.usecase.SensorWorkerUseCase
import com.uoa.sensordatacollection.domain.usecase.StopSensorsUseCase
import com.uoa.sensordatacollection.domain.usecase.trip.StopTripUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SensorsViewModel @Inject constructor(
    private val sensorWorkerUseCase: SensorWorkerUseCase,
    private val stopSensorsUseCase: StopSensorsUseCase,
    private val stopTripUseCase: StopTripUseCase
) : ViewModel() {

    private val _tripState = MutableStateFlow<TripState>(TripState.STOPPED)
    val tripState: StateFlow<TripState> get() = _tripState

    fun startTrip(liveOwner: LifecycleOwner,driverProfileId: Long, cont: Boolean) {
        viewModelScope.launch {
            _tripState.emit(TripState.STARTED)
            sensorWorkerUseCase.sensors_startWork(liveOwner,driverProfileId,cont)
            _tripState.emit(TripState.STARTED)
        }
    }

    fun stopTrip(context: Context, driverProfileId: Long) {
        viewModelScope.launch {
            _tripState.emit(TripState.STOPPED)
            stopSensorsUseCase.execute(context)
            _tripState.emit(TripState.STOPPED)
//            Update Trip data
            stopTripUseCase.execute(driverProfileId)
        }
    }
}
