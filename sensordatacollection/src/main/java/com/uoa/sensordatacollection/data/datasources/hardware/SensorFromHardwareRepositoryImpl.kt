package com.uoa.sensordatacollection.data.datasources.hardware

import com.uoa.sensordatacollection.data.TrackingSensor
import com.uoa.sensordatacollection.data.datasources.local.LocalSensorDataSource
//import com.uoa.sensordatacollection.data.model.SensorDataEntity
//import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class SensorFromHardwareRepositoryImpl @Inject constructor(
    private  val trackingSensor: TrackingSensor,
    private val localSensorDataSource: LocalSensorDataSource,
    private val remoteSensorDataSource: LocalSensorDataSource
): SensorFromHardwareRepository{
    override suspend fun startSensor() {

    }

    override suspend fun stopSensorData() {

    }
}