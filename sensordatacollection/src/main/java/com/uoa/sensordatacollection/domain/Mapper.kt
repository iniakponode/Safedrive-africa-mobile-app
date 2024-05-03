package com.uoa.sensordatacollection.domain

import com.uoa.core.db.entity.TripDataEntity
import com.uoa.sensordatacollection.domain.model.TripData

class Mapper {
    companion object{
            fun convertTripEntityToDomainModel(entity: com.uoa.core.db.entity.TripDataEntity): TripData {
            return TripData(
                id = entity.id,
                driverProfileId = entity.driverProfileId,
                startTime = entity.startTime,
                endTime = entity.endTime
            )
        }

        fun convertTripDataToEntityModel(data: TripData): com.uoa.core.db.entity.TripDataEntity {
            return com.uoa.core.db.entity.TripDataEntity(
                id = data.id,
                driverProfileId = data.driverProfileId,
                startTime = data.startTime,
                endTime = data.endTime
            )
        }
    }
}