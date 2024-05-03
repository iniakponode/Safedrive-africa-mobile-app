package com.uoa.core.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.uoa.core.db.entity.DriverProfileDataEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DriverProfileDao {
    @Insert
    suspend fun insert(profile: DriverProfileDataEntity)

    @Query("SELECT * FROM device_profiles WHERE email = :email AND password = :password")
    fun getProfile(email: String, password: String): DriverProfileDataEntity?

    @Query("Select * From device_profiles")
    fun getAllDeviceProfiles(): Flow<List<DriverProfileDataEntity>>

    @Delete
    suspend fun deleteDeviceProfile(deviceProfileM: DriverProfileDataEntity)

    @Update
    suspend fun updateDeviceProfile(deviceProfileM: DriverProfileDataEntity)
}