package com.uoa.deviceprofile.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "device_profiles")
@Parcelize
data class DriverProfileDataEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val driverType: String, // Public or Private
    val vehicleType: String, // Taxi, Bus, Trailer, Lorry
    val educationLevel: String, // No school, Primary, Secondary, University
    val drivingSchool: Boolean, // Yes or No
    val drivingLicense: Boolean, // Yes or No
    val email: String, // Driver's email
    val phone: String, // Phone number
    val phoneType: String, // Type of phone
    val password: String, // Password
    val registrationDateTime: String // Registration date and time
) : Parcelable
