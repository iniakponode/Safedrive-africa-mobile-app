package com.uoa.sensordatacollection.data.datasources.local

import com.uoa.co.db.dao.SensorDao
import com.uoa.co.db.entity.SensorDataEntity
//import com.uoa.sdaapp.domain.util.Result
//import retrofit2.Response

class LocalSensorDataSource(private val sensorDataDao: com.uoa.co.db.dao.SensorDao) {

    // Insert a single sensor data entity into the local database
    suspend fun insertSensorData(sensorData: com.uoa.co.db.entity.SensorDataEntity) {
        sensorDataDao.insertSensorData(sensorData)
    }

    // Insert a list of sensor data entities into the local database
    suspend fun insertAllSensorData(sensorDataList: List<com.uoa.co.db.entity.SensorDataEntity>) {
        sensorDataDao.insertAllSensorData(sensorDataList)
    }
   // Get new Sensor data not yet synced to server
    suspend fun getNewSensorData(synced: Boolean): List<com.uoa.co.db.entity.SensorDataEntity>{
        return sensorDataDao.getNewSensorData(synced)
    }
    // Get sensor data associated with a specific tripDataId from the local database
    suspend fun getSensorDataForTrip(tripDataId: Long): List<com.uoa.co.db.entity.SensorDataEntity> {
        return sensorDataDao.getSensorDataForTrip(tripDataId)
    }

    // Get sensor data by its id from the local database
    suspend fun getSensorDataById(sensorDataId: Long): com.uoa.co.db.entity.SensorDataEntity? {
        return sensorDataDao.getSensorDataById(sensorDataId)
    }

    // Delete a single sensor data by its id from the local database
    suspend fun deleteSensorDataById(sensorDataId: Long) {
        sensorDataDao.deleteSensorDataById(sensorDataId)
    }

    // Delete all sensor data associated with a specific tripDataId from the local database
    suspend fun deleteSensorDataForTrip(tripDataId: Long) {
        sensorDataDao.deleteSensorDataForTrip(tripDataId)
    }

    // Delete all sensor data from the local database
    suspend fun deleteAllSensorData() {
        sensorDataDao.deleteAllSensorData()
    }
}
