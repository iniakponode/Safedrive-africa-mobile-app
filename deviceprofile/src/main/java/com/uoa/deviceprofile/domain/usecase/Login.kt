package com.uoa.deviceprofile.domain.usecase

import com.uoa.deviceprofile.util.Mapper.Companion.convertDriverProfileModelToEntity
import com.uoa.co.db.entity.DriverProfileDataEntity as DProfile
import com.uoa.deviceprofile.util.Mapper.Companion.convertDriverProfileEntityToDomainModel
import retrofit2.HttpException
import javax.inject.Inject
import com.uoa.co.util.Result
import com.uoa.deviceprofile.data.repoImplementations.DriverProfileLoginRepoImpl

class Login @Inject constructor(private val repository: DriverProfileLoginRepoImpl) {

//    use case to login the driver remotely using email and password.
    suspend fun execute(email: String, password: String): Any? {
        try {
            return repository.remoteLogin(email, password)
        }   catch (e: Exception) {
            throw e
        }
    }

}