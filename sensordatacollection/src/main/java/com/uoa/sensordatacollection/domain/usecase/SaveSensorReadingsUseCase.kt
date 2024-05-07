package com.uoa.sensordatacollection.domain.usecase

import com.uoa.co.db.entity.SensorDataEntity
import javax.inject.Inject

class SaveSensorReadingsUseCase @Inject constructor(
    private val saveSensorDataToLocalDatabaseUseCase:SaveSensorDataToLocalDatabaseUseCase,
    private val saveSensorDataToRemoteDBUseCase: SaveSensorDataToRemoteDBUseCase
){

    suspend fun execute(
        tripId: Long,
        accelerometerReading: List<Float>,
        gyroscopeReading: List<Float>,
        magnetometerSensorReading: List<Float>,
        rotationVectorSensorReading: List<Float>,
        linearAccelerationReading: List<Float>
        // Add parameters for other sensor readings as needed
    ) {
        // Create SensorDataEntity and save to local database
        val timestamp = System.currentTimeMillis()
        val sensorDataEntity = com.uoa.co.db.entity.SensorDataEntity(
            tripDataId = tripId,
            timestamp = timestamp,
            accelerometerX = accelerometerReading[0],
            accelerometerY = accelerometerReading[1],
            accelerometerZ = accelerometerReading[2],
            gyroscopeX = gyroscopeReading[0],
            gyroscopeY = gyroscopeReading[1],
            gyroscopeZ = gyroscopeReading[2],
            magnetometerX = magnetometerSensorReading[0],
            magnetometerY = magnetometerSensorReading[1],
            magnetometerZ = magnetometerSensorReading[2],
            rotationVectorX = rotationVectorSensorReading[0],
            rotationVectorY = rotationVectorSensorReading[1],
            rotationVectorZ = rotationVectorSensorReading[2],
            rotationVectorScalar = rotationVectorSensorReading[3],
            linearAccelerationX = linearAccelerationReading[0],
            linearAccelerationY = linearAccelerationReading[1],
            linearAccelerationZ = linearAccelerationReading[2]
            // Set other sensor readings accordingly
        )

        // Save to local database
        // Note: Replace with your actual method to save to local database
        saveSensorDataToLocalDatabaseUseCase.execute(sensorDataEntity)

        // Save to remote server
        // Note: Replace with your actual method to save to remote server
        saveSensorDataToRemoteDBUseCase.execute(sensorDataEntity)
    }
}