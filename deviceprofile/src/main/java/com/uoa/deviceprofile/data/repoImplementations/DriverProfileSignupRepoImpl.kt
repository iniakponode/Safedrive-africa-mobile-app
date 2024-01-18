package com.uoa.deviceprofile.data.repoImplementations

import com.uoa.deviceprofile.data.datasources.LocalDataSource
import com.uoa.deviceprofile.data.datasources.RemoteDataSource
import com.uoa.deviceprofile.data.model.DriverProfileDataEntity
import com.uoa.deviceprofile.domain.repository.DriverProfileSignupRepo
import retrofit2.Response
import javax.inject.Inject

class DriverProfileSignupRepoImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : DriverProfileSignupRepo {

    override suspend fun signup(driverProfileDataEntity: DriverProfileDataEntity): Response<DriverProfileDataEntity> {
        // Implement signup logic, such as storing in a remote server and local cache
        return remoteDataSource.createProfile(driverProfileDataEntity)
    }
    override suspend fun storeDriverProfile(driverProfileDataEntity: DriverProfileDataEntity): Boolean{
        return localDataSource.insertProfile(driverProfileDataEntity)
    }

}
