package com.uoa.sensordatacollection.data.datasources.remote

import com.uoa.core.appApiService.SensorDataApiService
import com.uoa.core.db.entity.SensorDataEntity

class RemoteSensorDataSource(private val apiService: com.uoa.core.appApiService.SensorDataApiService) {

    // Send a single sensor data entity to the remote server
    suspend fun sendSensorData(sensorData: com.uoa.core.db.entity.SensorDataEntity) {
        apiService.sendSensorData(sensorData)
    }

    // Send a list of sensor data entities to the remote server
    suspend fun sendBulkSensorData(sensorDataList: List<com.uoa.core.db.entity.SensorDataEntity>) {
        apiService.sendBulkSensorData(sensorDataList)
    }

    // Get sensor data associated with a specific tripDataId from the remote server
    suspend fun getSensorDataForTrip(tripDataId: Long): List<com.uoa.core.db.entity.SensorDataEntity> {
        return apiService.getSensorDataForTrip(tripDataId)
    }

    // Get sensor data by its id from the remote server
    suspend fun getSensorDataById(sensorDataId: Long): com.uoa.core.db.entity.SensorDataEntity {
        return apiService.getSensorDataById(sensorDataId)
    }

    // Delete a single sensor data by its id from the remote server
    suspend fun deleteSensorDataById(sensorDataId: Long) {
        apiService.deleteSensorDataById(sensorDataId)
    }

    // Delete all sensor data associated with a specific tripDataId from the remote server
    suspend fun deleteSensorDataForTrip(tripDataId: Long) {
        apiService.deleteSensorDataForTrip(tripDataId)
    }

    // Delete all sensor data from the remote server
    suspend fun deleteAllSensorData() {
        apiService.deleteAllSensorData()
    }
}
