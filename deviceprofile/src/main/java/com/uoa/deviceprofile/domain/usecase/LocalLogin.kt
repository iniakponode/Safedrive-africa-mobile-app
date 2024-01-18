package com.uoa.deviceprofile.domain.usecase

import androidx.lifecycle.LiveData
import com.uoa.deviceprofile.domain.model.DriverProfile
import com.uoa.deviceprofile.domain.repository.DriverProfileLoginRepo
import javax.inject.Inject
import com.uoa.sdaapp.domain.util.Result

class LocalLogin @Inject constructor(
    private val repo: DriverProfileLoginRepo
) {
    suspend fun execute(email: String, password: String): LiveData<Result<DriverProfile?>> {
        return repo.login(email, password)
    }
}
