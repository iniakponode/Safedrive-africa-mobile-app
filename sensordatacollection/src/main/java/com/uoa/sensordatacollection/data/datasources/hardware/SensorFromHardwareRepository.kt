package com.uoa.sensordatacollection.data.datasources.hardware

//import kotlinx.coroutines.flow.Flow
//import com.uoa.core.db.entity.SensorDataEntity
interface SensorFromHardwareRepository {
    suspend fun startSensor()
    suspend fun stopSensorData()
}