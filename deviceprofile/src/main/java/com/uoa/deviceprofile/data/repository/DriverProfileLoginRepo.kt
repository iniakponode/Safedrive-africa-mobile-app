package com.uoa.deviceprofile.data.repository

import androidx.lifecycle.LiveData
import com.uoa.co.db.entity.DriverProfileDataEntity
import com.uoa.deviceprofile.domain.model.DriverProfile as DProfile
import retrofit2.Response
import com.uoa.co.util.Result

interface DriverProfileLoginRepo {

    suspend fun login(email: String, password: String): LiveData<Result<DProfile?>>
    suspend fun remoteLogin(email: String, password: String): Any?
}