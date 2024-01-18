package com.uoa.sensordatacollection.domain.model

data class TripData(
    val id: Long = 0,
    val driverProfileId: Long,
    val startTime: Long,
    val endTime: Long?,
    // Other trip data fields
)

