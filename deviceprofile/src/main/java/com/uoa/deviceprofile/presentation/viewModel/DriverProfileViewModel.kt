package com.uoa.deviceprofile.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.uoa.core.db.entity.DriverProfileDataEntity
import com.uoa.deviceprofile.util.Mapper.Companion.convertDriverProfileModelToEntity
import com.uoa.deviceprofile.domain.model.DriverProfile as DProfile
import com.uoa.deviceprofile.domain.usecase.LocalLogin
import com.uoa.deviceprofile.domain.usecase.Signup
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.uoa.core.util.Result.*

@HiltViewModel
class DriverProfileViewModel @Inject constructor(
    private val signup: Signup,
    private val login: LocalLogin
) : ViewModel() {

    private val _driverProfile = MutableLiveData<DProfile>()
    val driverProfile: LiveData<DProfile> = _driverProfile

    private val _result = MutableLiveData<Exception?>()
    val result: LiveData<Exception?> = _result

    private fun submitDriverProfile(driverProfile: DProfile) {
        viewModelScope.launch {
            when (val result = signup.execute(driverProfile)) {
                is Success -> {
                    val profile = result.data
                    _driverProfile.value = profile
                }
                is Error -> {
                    val error = result.exception
                    _result.value = error
                }

                else -> {
                    Loading
                }
            }
        }
    }

    fun signupDriverProfile(driverProfile: DProfile) {
        submitDriverProfile(driverProfile)
    }

    private val _loginResult = MutableLiveData<DriverProfileDataEntity?>()
    val loginResult: LiveData<DriverProfileDataEntity?> = _loginResult

    private val _loginError=MutableLiveData<Error>()
    val loginError=_loginError

    private val _loginLoading=MutableLiveData<Loading>()
    val loginLoading=_loginLoading

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                _loginLoading.value = Loading

                when (val result = login.execute(email, password).value) {
                    is Success -> {
                        // Successfully logged in
                        _loginResult.value = convertDriverProfileModelToEntity(result.data!!)
                    }
                    is Error -> {
                        // Error during login
                        _loginError.value = Error(result.exception)
                    }
                    is Loading -> {
                        _loginLoading.value = Loading
                    }

                    else -> {
                        Log.i("Trace", "Can\'t Trace")
                    }
                }
            } catch (e: Exception) {
                // Exception during login
                _loginError.value = Error(e)
            }
        }
    }

}
