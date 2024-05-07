package com.uoa.deviceprofile.domain.usecase

import com.uoa.deviceprofile.util.Mapper.Companion.convertDriverProfileModelToEntity
import com.uoa.deviceprofile.domain.model.DriverProfile
import javax.inject.Inject
import com.uoa.deviceprofile.data.repoImplementations.DriverProfileSignupRepoImpl

class Signup @Inject constructor(private val repository: DriverProfileSignupRepoImpl) {
    suspend fun execute(driverProfile: DriverProfile): DriverProfile {
        val driverProfileEntity = convertDriverProfileModelToEntity(driverProfile)
        try {
            val result=repository.localSignUp(driverProfileEntity)
            if (result>0) {
                return driverProfile
            } else {
                throw Exception("Error during signup: ${result}")
            }
        }   catch (e: Exception) {
            throw e
        }
    }


}