package com.uoa.deviceprofile.presentation.ui
import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DeviceProfileApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialization code for this module
    }
}