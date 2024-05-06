package com.uoa.sensordatacollection.domain.model

data class SensorData(
    val id: Long = 0,
    val tripDataId: Long,
    val timestamp: Long,
    val synced: Boolean = false,
    val accelerometerX: Float,
    val accelerometerY: Float,
    val accelerometerZ: Float,
    val gyroscopeX: Float,
    val gyroscopeY: Float,
    val gyroscopeZ: Float,
    val magnetometerX: Float,
    val magnetometerY: Float,
    val magnetometerZ: Float,
    val rotationVectorX: Float,
    val rotationVectorY: Float,
    val rotationVectorZ: Float,
    val rotationVectorScalar: Float,
    val linearAccelerationX: Float,
    val linearAccelerationY: Float,
    val linearAccelerationZ: Float,
    // Other sensor data fields
)

