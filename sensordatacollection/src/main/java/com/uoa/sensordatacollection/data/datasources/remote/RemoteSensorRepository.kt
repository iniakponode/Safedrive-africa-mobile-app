package com.uoa.sensordatacollection.data.datasources.remote

import com.uoa.sensordatacollection.data.model.SensorDataEntity

interface RemoteSensorRepository {

    // Send a single sensor data entity to the remote server
    suspend fun sendSensorData(sensorData: SensorDataEntity)

    // Send a list of sensor data entities to the remote server
    suspend fun sendBulkSensorData(sensorDataList: List<SensorDataEntity>)

    // Get sensor data associated with a specific tripDataId from the remote server
    suspend fun getSensorDataForTrip(tripDataId: Long): List<SensorDataEntity>

    // Get sensor data by its id from the remote server
    suspend fun getSensorDataById(sensorDataId: Long): SensorDataEntity

    // Delete a single sensor data by its id from the remote server
    suspend fun deleteSensorDataById(sensorDataId: Long)

    // Delete all sensor data associated with a specific tripDataId from the remote server
    suspend fun deleteSensorDataForTrip(tripDataId: Long)

    // Delete all sensor data from the remote server
    suspend fun deleteAllSensorData()
}
