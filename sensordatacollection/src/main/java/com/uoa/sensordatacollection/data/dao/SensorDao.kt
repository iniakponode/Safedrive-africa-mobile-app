package com.uoa.sensordatacollection.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
//import com.uoa.sdaapp.domain.util.Result
import com.uoa.sensordatacollection.data.model.SensorDataEntity
//import retrofit2.Response

@Dao
interface SensorDao {

    // Inserts a single SensorDataEntity into the database.
    // If a conflict occurs, it replaces the existing entry.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSensorData(sensorData: SensorDataEntity)

    // Inserts a list of SensorDataEntity objects into the database.
    // If conflicts occur, it replaces the existing entries.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSensorData(sensorDataList: List<SensorDataEntity>)

    // Retrieves a list of SensorDataEntity objects associated with a specific tripDataId.
    @Query("SELECT * FROM sensor_data WHERE tripDataId = :tripDataId")
    suspend fun getSensorDataForTrip(tripDataId: Long): List<SensorDataEntity>

    // Retrieves a single SensorDataEntity by its id.
    @Query("SELECT * FROM sensor_data WHERE id = :sensorDataId")
    suspend fun getSensorDataById(sensorDataId: Long): SensorDataEntity?

    // Deletes a single SensorDataEntity by its id.
    @Query("DELETE FROM sensor_data WHERE id = :sensorDataId")
    suspend fun deleteSensorDataById(sensorDataId: Long)

    // Deletes all SensorDataEntity entries associated with a specific tripDataId.
    @Query("DELETE FROM sensor_data WHERE tripDataId = :tripDataId")
    suspend fun deleteSensorDataForTrip(tripDataId: Long)

    // Deletes all SensorDataEntity entries from the table.
    @Query("DELETE FROM sensor_data")
    suspend fun deleteAllSensorData()

    @Query("SELECT * FROM sensor_data WHERE synced = :syncd")
    suspend fun getNewSensorData(syncd: Boolean): List<SensorDataEntity>
}

