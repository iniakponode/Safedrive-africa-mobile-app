package com.uoa.sensordatacollection.util

import android.os.Build
import androidx.annotation.RequiresApi
import com.uoa.co.db.entity.DriverProfileDataEntity
import com.uoa.co.db.entity.SensorDataEntity
import com.uoa.co.db.entity.TripDataEntity
import com.uoa.sensordatacollection.domain.model.SensorData
import com.uoa.sensordatacollection.domain.model.TripData
class Mapper {
    companion object {


        fun convertTripEntityToDomainModel(entity: com.uoa.co.db.entity.TripDataEntity): TripData {
            return TripData(
                id = entity.id,
                driverProfileId = entity.driverProfileId,
                startTime = entity.startTime,
                endTime = entity.endTime
            )
        }

        fun convertTripDataToEntityModel(data: TripData): com.uoa.co.db.entity.TripDataEntity {
            return com.uoa.co.db.entity.TripDataEntity(
                id = data.id,
                driverProfileId = data.driverProfileId,
                startTime = data.startTime,
                endTime = data.endTime
            )
        }

        fun convertSensorEntityToDomainModel(entity: com.uoa.co.db.entity.SensorDataEntity): SensorData {
            return SensorData(
                id = entity.id,
                tripDataId = entity.tripDataId,
                timestamp = entity.timestamp,
                synced = entity.synced,
                accelerometerX = entity.accelerometerX,
                accelerometerY = entity.accelerometerY,
                accelerometerZ = entity.accelerometerZ,
                gyroscopeX = entity.gyroscopeX,
                gyroscopeY = entity.gyroscopeY,
                gyroscopeZ = entity.gyroscopeZ,
                magnetometerX = entity.magnetometerX,
                magnetometerY = entity.magnetometerY,
                magnetometerZ = entity.magnetometerZ,
                rotationVectorX = entity.rotationVectorX,
                rotationVectorY = entity.rotationVectorY,
                rotationVectorZ = entity.rotationVectorZ,
                rotationVectorScalar = entity.rotationVectorScalar,
                linearAccelerationX = entity.linearAccelerationX,
                linearAccelerationY = entity.linearAccelerationY,
                linearAccelerationZ = entity.linearAccelerationZ,
            )
        }

        fun convertSensorDataToEntityModel(data: SensorData): com.uoa.co.db.entity.SensorDataEntity {
            return com.uoa.co.db.entity.SensorDataEntity(
                id = data.id,
                tripDataId = data.tripDataId,
                timestamp = data.timestamp,
                synced = data.synced,
                accelerometerX = data.accelerometerX,
                accelerometerY = data.accelerometerY,
                accelerometerZ = data.accelerometerZ,
                gyroscopeX = data.gyroscopeX,
                gyroscopeY = data.gyroscopeY,
                gyroscopeZ = data.gyroscopeZ,
                magnetometerX = data.magnetometerX,
                magnetometerY = data.magnetometerY,
                magnetometerZ = data.magnetometerZ,
                rotationVectorX = data.rotationVectorX,
                rotationVectorY = data.rotationVectorY,
                rotationVectorZ = data.rotationVectorZ,
                rotationVectorScalar = data.rotationVectorScalar,
                linearAccelerationX = data.linearAccelerationX,
                linearAccelerationY = data.linearAccelerationY,
                linearAccelerationZ = data.linearAccelerationZ,
            )
        }

    }
}