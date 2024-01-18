package com.uoa.sensordatacollection.data.datasources.hardware

//import kotlinx.coroutines.flow.Flow
//import com.uoa.sensordatacollection.data.model.SensorDataEntity
interface SensorFromHardwareRepository {
    suspend fun startSensor()
    suspend fun stopSensorData()
}