package com.uoa.deviceprofile.data.repoImplementations

import com.uoa.co.db.entity.DriverProfileDataEntity
import com.uoa.deviceprofile.data.datasources.LocalDataSource
import com.uoa.deviceprofile.data.datasources.RemoteDataSource
import com.uoa.deviceprofile.data.repository.DriverProfileSignupRepo
import com.uoa.deviceprofile.domain.model.DriverProfile
import com.uoa.deviceprofile.util.Mapper.Companion.convertDriverProfileEntityToDomainModel
import javax.inject.Inject
import kotlin.reflect.typeOf

class DriverProfileSignupRepoImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : DriverProfileSignupRepo {

//    function to signup the driver remotely.
//    override suspend fun signup(driverProfileDataEntity:DriverProfileDataEntity): Response<DriverProfile> {
//        // Implement signup logic, such as storing in a remote server and local cache
//        val driverProfileModel = convertDriverProfileEntityToDomainModel(remoteDataSource.createProfile(driverProfileDataEntity))
//        return convert
//    }

    override suspend fun signup(driverProfileDataEntity:DriverProfileDataEntity): DriverProfile {
        val response = remoteDataSource.createProfile(driverProfileDataEntity)
        if (response.isSuccessful) {
            val driverProEntity = response.body()
            if (driverProEntity is DriverProfileDataEntity) {
                return convertDriverProfileEntityToDomainModel(driverProfileDataEntity)
            } else {
                throw Exception("No data received from server: ${response.code()} ${response.message()}")
            }
        } else {
            throw Exception("Error during signup: ${response.errorBody()?.string()}")
        }
    }
//    function to store the driver profile locally.
override suspend fun localSignUp(driverProfileDataEntity: DriverProfileDataEntity): Long {
    return localDataSource.insertProfile(driverProfileDataEntity)

}

}
