package com.uoa.deviceprofile.util

import com.uoa.co.db.entity.DriverProfileDataEntity
import com.uoa.co.db.entity.TripDataEntity

import com.uoa.deviceprofile.domain.model.DriverProfile as DProfile
class Mapper {
    companion object{
        fun convertDriverProfileModelToEntity(domainClass: DProfile): com.uoa.co.db.entity.DriverProfileDataEntity {
            return com.uoa.co.db.entity.DriverProfileDataEntity(
                driverType = domainClass.driverType,
                vehicleType = domainClass.vehicleType,
                password = domainClass.password,
                email = domainClass.email,
//                phone = domainClass.phone,
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
//                phone = entity.phone,
                phoneType = entity.phoneType,
                registrationDateTime = entity.registrationDateTime,
                drivingLicense = entity.drivingLicense,
                drivingSchool = entity.drivingSchool,
                educationalLevel = entity.educationLevel
                // ... map other fields
            )
        }

    }
}