package com.uoa.sdaapp.domain.util

import com.uoa.deviceprofile.data.model.DriverProfileDataEntity
import com.uoa.sensordatacollection.data.model.TripDataEntity
import com.uoa.sensordatacollection.domain.model.TripData
import com.uoa.deviceprofile.domain.model.DriverProfile as DProfile
class Mapper {
    companion object{
        fun convertDriverProfileModelToEntity(domainClass: DProfile): DriverProfileDataEntity {
            return DriverProfileDataEntity(
                driverType = domainClass.driverType,
                vehicleType = domainClass.vehicleType,
                password = domainClass.password,
                email = domainClass.email,
                phone = domainClass.phone,
                phoneType = domainClass.phoneType,
                registrationDateTime = domainClass.registrationDateTime,
                drivingLicense = domainClass.drivingLicense,
                drivingSchool = domainClass.drivingSchool,
                educationLevel = domainClass.educationalLevel
                // ... map other fields
            )
        }

        fun convertDriverProfileEntityToDomainModel(entity: DriverProfileDataEntity): DProfile {
            return DProfile(
                driverType = entity.driverType,
                vehicleType = entity.vehicleType,
                password = entity.password,
                email = entity.email,
                phone = entity.phone,
                phoneType = entity.phoneType,
                registrationDateTime = entity.registrationDateTime,
                drivingLicense = entity.drivingLicense,
                drivingSchool = entity.drivingSchool,
                educationalLevel = entity.educationLevel
                // ... map other fields
            )
        }

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