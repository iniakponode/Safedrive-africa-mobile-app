package com.uoa.co.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.uoa.co.db.entity.DriverProfileDataEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DriverProfileDao {
    @Insert
    suspend fun insert(profile: DriverProfileDataEntity): Long

    @Query("SELECT * FROM device_profiles WHERE email = :email AND password = :password")
    suspend fun getProfile(email: String, password: String): DriverProfileDataEntity?

    @Query("Select * From device_profiles")
    fun getAllDeviceProfiles(): Flow<List<DriverProfileDataEntity>>

    @Delete
    suspend fun deleteDeviceProfile(deviceProfileM: DriverProfileDataEntity)

    @Query("UPDATE device_profiles SET email = :email, password = :password WHERE id = :id")
    suspend fun updateDeviceProfile(id: Long, email: String, password: String)
}