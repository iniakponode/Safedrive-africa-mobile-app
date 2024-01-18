package com.uoa.sensordatacollection.domain.usecase

import com.uoa.sensordatacollection.data.TrackingSensor
import com.uoa.sensordatacollection.modulesprovider.AccelerometerSensorM
import com.uoa.sensordatacollection.modulesprovider.GyroscopeSensorM
import com.uoa.sensordatacollection.modulesprovider.LinearAccelerationM
import com.uoa.sensordatacollection.modulesprovider.MagnetometerSensorM
import com.uoa.sensordatacollection.modulesprovider.RotationVectorSensorM
import javax.inject.Inject

class CollectSensorReadingsUseCase @Inject constructor(
    @AccelerometerSensorM private val accelerometerSensor: TrackingSensor,
    @GyroscopeSensorM
    private val gyroscopeSensor: TrackingSensor,
    @LinearAccelerationM
    private val linearAcceleration: TrackingSensor,
    @RotationVectorSensorM
    private val rotationVectorSensor: TrackingSensor,
    @MagnetometerSensorM
    private val magnetometerSensor: TrackingSensor,
    private val saveSensorReadingsUseCase: SaveSensorReadingsUseCase
){

    suspend fun execute (tripId: Long) {

        var accelerometerReading= listOf<Float>()
        var gyroscopeReading= listOf<Float>()
        var linearAccelerationReading= listOf<Float>()
        var rotationVectorSensorReading= listOf<Float>()
        var magnetometerSensorReading= listOf<Float>()
            // Collect sensor readings
        this.accelerometerSensor.setOnSensorValuesChangedListener { accelerometerReading = it}
        this.gyroscopeSensor.setOnSensorValuesChangedListener { gyroscopeReading=it }
        this.linearAcceleration.setOnSensorValuesChangedListener { linearAccelerationReading=it }
        this.rotationVectorSensor.setOnSensorValuesChangedListener { rotationVectorSensorReading=it }
        this.magnetometerSensor.setOnSensorValuesChangedListener { magnetometerSensorReading=it }

            // Collect readings from other sensors as needed

            // Save readings to local database and remote server
            saveSensorReadingsUseCase.execute(tripId, accelerometerReading, gyroscopeReading, magnetometerSensorReading,rotationVectorSensorReading, linearAccelerationReading)
    }
}