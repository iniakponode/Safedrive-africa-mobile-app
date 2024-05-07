package com.uoa.deviceprofile.data.datasources

import com.uoa.co.db.entity.DriverProfileDataEntity
import com.uoa.co.db.dao.DriverProfileDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val deviceProfileDao: DriverProfileDao) {

    suspend fun insertProfile(deviceProfile: DriverProfileDataEntity): Long {
        return deviceProfileDao.insert(deviceProfile)

    }

   suspend fun getProfile(email: String, password: String): DriverProfileDataEntity? {
        return deviceProfileDao.getProfile(email, password)
    }

    suspend fun getprofiles(): Flow<List<DriverProfileDataEntity>> {
        return deviceProfileDao.getAllDeviceProfiles()
    }



    // Other local database operations
}