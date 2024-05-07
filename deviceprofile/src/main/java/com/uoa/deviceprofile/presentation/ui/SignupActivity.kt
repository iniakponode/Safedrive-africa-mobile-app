package com.uoa.deviceprofile.presentation.ui

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.material.Text
import androidx.compose.runtime.livedata.observeAsState

import dagger.hilt.android.AndroidEntryPoint
import com.uoa.deviceprofile.presentation.viewModel.DriverProfileViewModel

@AndroidEntryPoint
class SignupActivity : ComponentActivity() {
    private val viewModel: DriverProfileViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Observing driver profile LiveData to update the UI state
            val driverProfile = viewModel.driverProfile.observeAsState()

            // Rendering UI based on the observed data
            driverProfile.value?.let {
                // Assuming DriverProfileView is a composable function you defined
                DriverProfileView(viewModel)
            } ?: run {
                // Fallback UI if data isn't available yet
                Text("Loading profile data...")
            }
        }
    }
}

