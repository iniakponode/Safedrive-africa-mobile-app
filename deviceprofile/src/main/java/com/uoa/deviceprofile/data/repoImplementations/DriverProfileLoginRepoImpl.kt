package com.uoa.deviceprofile.data.repoImplementations

import androidx.lifecycle.LiveData
import com.uoa.deviceprofile.data.datasources.LocalDataSource
import com.uoa.deviceprofile.data.datasources.RemoteDataSource
import com.uoa.deviceprofile.data.model.DriverProfileDataEntity
import com.uoa.deviceprofile.domain.model.DriverProfile as DProfile
import com.uoa.deviceprofile.domain.repository.DriverProfileLoginRepo
import com.uoa.sdaapp.domain.util.Result
import androidx.lifecycle.liveData
import com.uoa.sdaapp.domain.util.Mapper.Companion.convertDriverProfileEntityToDomainModel
import retrofit2.Response
import javax.inject.Inject

class DriverProfileLoginRepoImpl @Inject constructor(private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource): DriverProfileLoginRepo {

    override suspend fun login(email: String, password: String): LiveData<Result<DProfile?>> = liveData {
        emit(Result.Loading) // Emitting the loading state
        try {
            val profile = localDataSource.getProfile(email, password)
            if (profile != null) {
                val driverProfile=convertDriverProfileEntityToDomainModel(profile)
                emit(Result.Success(driverProfile))
            } else {
                emit(Result.Error(Exception("Incorrect username or password")))
            }
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }



    override suspend fun remoteLogin(email: String, password: String): Response<DriverProfileDataEntity> {

        return remoteDataSource.login(email, password)
    }

}