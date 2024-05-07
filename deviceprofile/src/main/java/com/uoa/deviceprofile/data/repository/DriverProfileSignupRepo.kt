package com.uoa.deviceprofile.data.repository

import com.uoa.co.db.entity.DriverProfileDataEntity
import com.uoa.deviceprofile.domain.model.DriverProfile
//import com.uoa.deviceprofile.data.model.DriverProfile

interface DriverProfileSignupRepo {
    suspend fun signup(driverProfileDataEntity: DriverProfileDataEntity): Any?
    suspend fun localSignUp(driverProfileDataEntity: DriverProfileDataEntity): Long

}