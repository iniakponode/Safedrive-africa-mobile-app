package com.uoa.deviceprofile.domain.model

data class DriverProfile(
    val driverType: String,
    val vehicleType: String,
    val educationalLevel: String,
    val drivingSchool: Boolean,
    val drivingLicense: Boolean,
    val email: String,
    val phone: String,
    val phoneType: String,
    val password: String,
    val registrationDateTime: String
)

