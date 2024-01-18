package com.uoa.sensordatacollection.data.datasources.remote

import com.uoa.sensordatacollection.data.model.SensorDataEntity
import javax.inject.Inject

class RemoteSensorRepositoryImpl @Inject constructor(private val remoteSensorDataSource: RemoteSensorDataSource) : RemoteSensorRepository {

    override suspend fun sendSensorData(sensorData: SensorDataEntity) {
        remoteSensorDataSource.sendSensorData(sensorData)
    }

    override suspend fun sendBulkSensorData(sensorDataList: List<SensorDataEntity>) {
        remoteSensorDataSource.sendBulkSensorData(sensorDataList)
    }

    override suspend fun getSensorDataForTrip(tripDataId: Long): List<SensorDataEntity> {
        return remoteSensorDataSource.getSensorDataForTrip(tripDataId)
    }

    override suspend fun getSensorDataById(sensorDataId: Long): SensorDataEntity {
        return remoteSensorDataSource.getSensorDataById(sensorDataId)
    }

    override suspend fun deleteSensorDataById(sensorDataId: Long) {
        remoteSensorDataSource.deleteSensorDataById(sensorDataId)
    }

    override suspend fun deleteSensorDataForTrip(tripDataId: Long) {
        remoteSensorDataSource.deleteSensorDataForTrip(tripDataId)
    }

    override suspend fun deleteAllSensorData() {
        remoteSensorDataSource.deleteAllSensorData()
    }
}
