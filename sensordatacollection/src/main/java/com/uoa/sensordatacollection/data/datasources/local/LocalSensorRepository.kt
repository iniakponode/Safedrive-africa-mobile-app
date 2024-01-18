package com.uoa.sensordatacollection.data.datasources.local

import com.uoa.sensordatacollection.data.model.SensorDataEntity
import retrofit2.Response
//import com.uoa.sdaapp.domain.util.Result

interface LocalSensorRepository {

    // Insert a single sensor data entity into the local database
    suspend fun insertSensorData(sensorData: SensorDataEntity)

    // Insert a list of sensor data entities into the local database
    suspend fun insertAllSensorData(sensorDataList: List<SensorDataEntity>)

    // Get sensor data associated with a specific tripDataId from the local database
    suspend fun getSensorDataForTrip(tripDataId: Long): List<SensorDataEntity>

    // Get sensor data by its id from the local database
    suspend fun getSensorDataById(sensorDataId: Long): SensorDataEntity?

    suspend fun getNewSensorData(syncd: Boolean): List<SensorDataEntity>

    // Delete a single sensor data by its id from the local database
    suspend fun deleteSensorDataById(sensorDataId: Long)

    // Delete all sensor data associated with a specific tripDataId from the local database
    suspend fun deleteSensorDataForTrip(tripDataId: Long)

    // Delete all sensor data from the local database
    suspend fun deleteAllSensorData()
}
