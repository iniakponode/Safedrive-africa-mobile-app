package com.uoa.sensordatacollection.data.datasources.local

import com.uoa.core.db.entity.SensorDataEntity

//import com.uoa.sdaapp.domain.util.Result

interface LocalSensorRepository {

    // Insert a single sensor data entity into the local database
    suspend fun insertSensorData(sensorData: com.uoa.core.db.entity.SensorDataEntity)

    // Insert a list of sensor data entities into the local database
    suspend fun insertAllSensorData(sensorDataList: List<com.uoa.core.db.entity.SensorDataEntity>)

    // Get sensor data associated with a specific tripDataId from the local database
    suspend fun getSensorDataForTrip(tripDataId: Long): List<com.uoa.core.db.entity.SensorDataEntity>

    // Get sensor data by its id from the local database
    suspend fun getSensorDataById(sensorDataId: Long): com.uoa.core.db.entity.SensorDataEntity?

    suspend fun getNewSensorData(syncd: Boolean): List<com.uoa.core.db.entity.SensorDataEntity>

    // Delete a single sensor data by its id from the local database
    suspend fun deleteSensorDataById(sensorDataId: Long)

    // Delete all sensor data associated with a specific tripDataId from the local database
    suspend fun deleteSensorDataForTrip(tripDataId: Long)

    // Delete all sensor data from the local database
    suspend fun deleteAllSensorData()
}
