package com.uoa.sensordatacollection.modulesprovider.trip

import com.uoa.sensordatacollection.data.datasources.local.LocalTripDataRepository
import com.uoa.sensordatacollection.data.model.TripDataEntity
import com.uoa.sensordatacollection.domain.Mapper.Companion.convertTripDataToEntityModel
import com.uoa.sensordatacollection.domain.model.TripData
import javax.inject.Inject

class StartTripUseCase @Inject constructor(
    private val localTripRepository: LocalTripDataRepository
) {

    suspend fun execute(driverProfileId: Long): TripDataEntity {
        // Create a domain model for trip start with endTime set to null
        val startTime = System.currentTimeMillis()
        val tripData = TripData(driverProfileId = driverProfileId, startTime = startTime, endTime = null)

            // Store trip start time locally using domain model
        return localTripRepository.insertTripLocal(convertTripDataToEntityModel(tripData))

    }
}

