package com.uoa.deviceprofile.domain.usecase

import com.uoa.sdaapp.domain.util.Mapper.Companion.convertDriverProfileModelToEntity
import com.uoa.deviceprofile.data.model.DriverProfileDataEntity as DProfile
import com.uoa.deviceprofile.domain.repository.DriverProfileLoginRepo
import com.uoa.sdaapp.domain.util.Mapper.Companion.convertDriverProfileEntityToDomainModel
import retrofit2.HttpException
import javax.inject.Inject
import com.uoa.sdaapp.domain.util.Result

class Login @Inject constructor(private val repository: DriverProfileLoginRepo) {
    suspend fun execute(email: String, password: String): Result<DProfile> {
        return try {
            val response = repository.remoteLogin(email, password)
            if (response.isSuccessful) {
                response.body()?.let {
                    Result.Success(convertDriverProfileModelToEntity(convertDriverProfileEntityToDomainModel(it)))
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