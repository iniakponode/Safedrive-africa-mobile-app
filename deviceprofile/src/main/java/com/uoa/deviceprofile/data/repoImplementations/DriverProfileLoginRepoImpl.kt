package com.uoa.deviceprofile.data.repoImplementations

import androidx.lifecycle.LiveData
import com.uoa.deviceprofile.data.datasources.LocalDataSource
import com.uoa.deviceprofile.data.datasources.RemoteDataSource
import com.uoa.deviceprofile.domain.model.DriverProfile as DProfile
import com.uoa.deviceprofile.data.repository.DriverProfileLoginRepo
import androidx.lifecycle.liveData
import com.uoa.co.db.entity.DriverProfileDataEntity
import com.uoa.co.util.Result
import com.uoa.deviceprofile.util.Mapper
import com.uoa.deviceprofile.util.Mapper.Companion.convertDriverProfileEntityToDomainModel
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

class DriverProfileLoginRepoImpl @Inject constructor(private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource):
    DriverProfileLoginRepo {

//        function to login the driver locally.
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



// function to login the driver remotely.
override suspend fun remoteLogin(email: String, password: String): Any? {
    return try {
        val response = remoteDataSource.login(email, password)

        if (response.isSuccessful) {
            response.body()?.let {
                Result.Success(
                    Mapper.convertDriverProfileModelToEntity(
                        convertDriverProfileEntityToDomainModel(it)
                    )
                )
            } ?: Result.Error(Exception("No data received from server"))
        } else {
            Result.Error(HttpException(response))
        }
    } catch (e: HttpException) {
        Result.Error(e)
    } catch (e: Exception) {
        Result.Error(e)
    }
}

}