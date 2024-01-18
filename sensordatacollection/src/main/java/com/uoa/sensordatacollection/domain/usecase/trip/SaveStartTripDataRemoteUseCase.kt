package com.uoa.sensordatacollection.domain.usecase.trip

import com.uoa.sensordatacollection.data.datasources.remote.RemoteTripRepository
import com.uoa.sensordatacollection.domain.Mapper
import com.uoa.sensordatacollection.domain.model.TripData
import javax.inject.Inject

class SaveStartTripDataRemoteUseCase @Inject constructor(private val remoteTripRepository: RemoteTripRepository) {

    suspend fun execute(tripData: TripData): Boolean {
        return try {
            // Create a domain model for trip start with endTime set to null
            val startTime = System.currentTimeMillis()
//            val tripData = TripData(driverProfileId = driverProfileId, startTime = startTime, endTime = null)

            // Store trip start time remotely using domain model
            remoteTripRepository.createTripRemote(Mapper.convertTripDataToEntityModel(tripData))

            // Return true if both local and remote operations were successful
            true
        } catch (e: Exception) {
            // Handle any exceptions if needed
            false
        }
    }
}