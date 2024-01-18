package com.uoa.deviceprofile.domain.repository

import com.uoa.deviceprofile.data.model.DriverProfileDataEntity
//import com.uoa.deviceprofile.data.model.DriverProfile
import retrofit2.Response

interface DriverProfileSignupRepo {
    suspend fun signup(driverProfileDataEntity: DriverProfileDataEntity): Response<DriverProfileDataEntity>
    suspend fun storeDriverProfile(driverProfileDataEntity: DriverProfileDataEntity): Boolean

}