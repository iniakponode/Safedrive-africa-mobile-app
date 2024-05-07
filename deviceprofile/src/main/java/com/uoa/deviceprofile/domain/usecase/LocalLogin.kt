package com.uoa.deviceprofile.domain.usecase

import androidx.lifecycle.LiveData
import com.uoa.deviceprofile.domain.model.DriverProfile
import com.uoa.deviceprofile.data.repoImplementations.DriverProfileLoginRepoImpl
import javax.inject.Inject

class LocalLogin @Inject constructor(
    private val repo: DriverProfileLoginRepoImpl
) {
//    use case to login the driver locally using email and password.
    suspend fun execute(email: String, password: String): LiveData<com.uoa.co.util.Result<DriverProfile?>> {
        return repo.login(email, password)
    }
}
