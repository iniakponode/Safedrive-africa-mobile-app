package com.uoa.deviceprofile.domain.usecase

import com.uoa.core.util.Mapper.Companion.convertDriverProfileModelToEntity
import com.uoa.deviceprofile.domain.model.DriverProfile
import com.uoa.deviceprofile.domain.repository.DriverProfileSignupRepo
import com.uoa.core.util.Mapper.Companion.convertDriverProfileEntityToDomainModel
import javax.inject.Inject
import com.uoa.core.util.Result
import retrofit2.HttpException

class Signup @Inject constructor(private val repository: DriverProfileSignupRepo) {
    suspend fun execute(driverProfile: DriverProfile): Result<DriverProfile> {
        return try {
            val response = repository.signup(convertDriverProfileModelToEntity(driverProfile))

            if (response.isSuccessful) {
                response.body()?.let {
                    if (repository.storeDriverProfile(convertDriverProfileModelToEntity(driverProfile))) {
                        Result.Success(convertDriverProfileEntityToDomainModel(it))
                    } else {
                        Result.Error(Exception("Failed to store driver profile locally"))
                    }
                } ?: Result.Error(Exception("Null response body"))
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