package com.uoa.sensordatacollection.data.datasources.local

import com.uoa.core.db.entity.SensorDataEntity
//import com.uoa.sdaapp.domain.util.Result
import javax.inject.Inject

class LocalSensorRepositoryImpl @Inject constructor(private val localSensorDataSource: LocalSensorDataSource) : LocalSensorRepository {

    override suspend fun insertSensorData(sensorData: com.uoa.core.db.entity.SensorDataEntity) {
        localSensorDataSource.insertSensorData(sensorData)
    }

    override suspend fun insertAllSensorData(sensorDataList: List<com.uoa.core.db.entity.SensorDataEntity>) {
        localSensorDataSource.insertAllSensorData(sensorDataList)
    }

    override suspend fun getSensorDataForTrip(tripDataId: Long): List<com.uoa.core.db.entity.SensorDataEntity> {
        return localSensorDataSource.getSensorDataForTrip(tripDataId)
    }

    override suspend fun getSensorDataById(sensorDataId: Long): com.uoa.core.db.entity.SensorDataEntity? {
        return localSensorDataSource.getSensorDataById(sensorDataId)
    }

    override suspend fun getNewSensorData(syncd: Boolean): List<com.uoa.core.db.entity.SensorDataEntity> {
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
