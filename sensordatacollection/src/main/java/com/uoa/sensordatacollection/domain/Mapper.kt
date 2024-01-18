package com.uoa.sensordatacollection.domain

import com.uoa.sensordatacollection.data.model.TripDataEntity
import com.uoa.sensordatacollection.domain.model.TripData

class Mapper {
    companion object{
            fun convertTripEntityToDomainModel(entity: TripDataEntity): TripData {
            return TripData(
                id = entity.id,
                driverProfileId = entity.driverProfileId,
                startTime = entity.startTime,
                endTime = entity.endTime
            )
        }

        fun convertTripDataToEntityModel(data: TripData): TripDataEntity {
            return TripDataEntity(
                id = data.id,
                driverProfileId = data.driverProfileId,
                startTime = data.startTime,
                endTime = data.endTime
            )
        }
    }
}