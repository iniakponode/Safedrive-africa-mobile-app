package com.uoa.deviceprofile.domain.repository

import androidx.lifecycle.LiveData
import com.uoa.core.db.entity.DriverProfileDataEntity
import com.uoa.deviceprofile.domain.model.DriverProfile as DProfile
import retrofit2.Response
import com.uoa.core.util.Result

interface DriverProfileLoginRepo {

    suspend fun login(email: String, password: String): LiveData<Result<DProfile?>>
    suspend fun remoteLogin(email: String, password: String): Response<DriverProfileDataEntity>
}