package com.uoa.sensordatacollection.data.datasources.local

import com.uoa.core.db.entity.SensorDataEntity
import com.uoa.core.util.Result
import javax.inject.Inject

class LocalSensorRepositoryImpl @Inject constructor(private val localSensorDataSource: LocalSensorDataSource) : LocalSensorRepository {

    override suspend fun insertSensorData(sensorData: SensorDataEntity) {
        localSensorDataSource.insertSensorData(sensorData)
    }

    override suspend fun insertAllSensorData(sensorDataList: List<SensorDataEntity>) {
        localSensorDataSource.insertAllSensorData(sensorDataList)
    }

    override suspend fun getSensorDataForTrip(tripDataId: Long): List<SensorDataEntity> {
        return localSensorDataSource.getSensorDataForTrip(tripDataId)
    }

    override suspend fun getSensorDataById(sensorDataId: Long): SensorDataEntity? {
        return localSensorDataSource.getSensorDataById(sensorDataId)
    }

    override suspend fun getNewSensorData(syncd: Boolean): List<SensorDataEntity> {
      return localSensorDataSource.getNewSensorData(syncd)
    }

    override suspend fun deleteSensorDataById(sensorDataId: Long) {
        localSensorDataSource.deleteSensorDataById(sensorDataId)
    }

    override suspend fun deleteSensorDataForTrip(tripDataId: Long) {
        localSensorDataSource.deleteSensorDataForTrip(tripDataId)
    }

    override suspend fun deleteAllSensorData() {
        localSensorDataSource.deleteAllSensorData()
    }
}
