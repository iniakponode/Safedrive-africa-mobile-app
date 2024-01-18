package com.uoa.deviceprofile.data.datasources

import com.uoa.deviceprofile.data.model.DriverProfileDataEntity
import com.uoa.deviceprofile.data.dao.DriverProfileDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val deviceProfileDao: DriverProfileDao) {

    suspend fun insertProfile(deviceProfile: DriverProfileDataEntity): Boolean {
        deviceProfileDao.insert(deviceProfile)
        return true
    }

   suspend fun getProfile(email: String, password: String): DriverProfileDataEntity? {
        return deviceProfileDao.getProfile(email, password)
    }

    suspend fun getprofiles(): Flow<List<DriverProfileDataEntity>> {
        return deviceProfileDao.getAllDeviceProfiles()
    }

    // Other local database operations
}