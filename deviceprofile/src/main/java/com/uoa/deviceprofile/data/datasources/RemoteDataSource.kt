package com.uoa.deviceprofile.data.datasources

import com.uoa.deviceprofile.data.api.DriverProfileApiService
import com.uoa.deviceprofile.data.model.DriverProfileDataEntity
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: DriverProfileApiService) {

    suspend fun createProfile(deviceProfile: DriverProfileDataEntity): Response<DriverProfileDataEntity> {
        return apiService.createProfile(deviceProfile)
    }
    suspend fun updateProfile(id: Int, deviceProfile: DriverProfileDataEntity): Response<DriverProfileDataEntity> {
        return apiService.updateProfile(id, deviceProfile)
    }
    suspend fun getProfiles(deviceProfile: DriverProfileDataEntity): Response<List<DriverProfileDataEntity>>{
        return apiService.getDeviceProfiles()
    }

    suspend fun getProfile(id: String): Response<DriverProfileDataEntity>{
        return apiService.getDeviceProfile(id)
    }

    suspend fun login(email: String, password: String): Response<DriverProfileDataEntity> {
        return apiService.login(email, password)
    }

    // Other remote operations
}