package com.uoa.sensordatacollection.data.datasources.remote

import com.uoa.core.db.entity.SensorDataEntity

interface RemoteSensorRepository {

    // Send a single sensor data entity to the remote server
    suspend fun sendSensorData(sensorData: com.uoa.core.db.entity.SensorDataEntity)

    // Send a list of sensor data entities to the remote server
    suspend fun sendBulkSensorData(sensorDataList: List<com.uoa.core.db.entity.SensorDataEntity>)

    // Get sensor data associated with a specific tripDataId from the remote server
    suspend fun getSensorDataForTrip(tripDataId: Long): List<com.uoa.core.db.entity.SensorDataEntity>

    // Get sensor data by its id from the remote server
    suspend fun getSensorDataById(sensorDataId: Long): com.uoa.core.db.entity.SensorDataEntity

    // Delete a single sensor data by its id from the remote server
    suspend fun deleteSensorDataById(sensorDataId: Long)

    // Delete all sensor data associated with a specific tripDataId from the remote server
    suspend fun deleteSensorDataForTrip(tripDataId: Long)

    // Delete all sensor data from the remote server
    suspend fun deleteAllSensorData()
}
