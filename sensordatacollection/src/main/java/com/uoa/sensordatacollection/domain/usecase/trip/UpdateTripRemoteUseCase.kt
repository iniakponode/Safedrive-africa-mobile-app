package com.uoa.sensordatacollection.domain.usecase.trip

import com.uoa.sensordatacollection.data.datasources.remote.RemoteTripRepository
import com.uoa.sensordatacollection.domain.model.TripData

import javax.inject.Inject

class UpdateTripRemoteUseCase @Inject constructor(private val remoteTripRepository: RemoteTripRepository) {

    suspend fun execute(tripId:Long, tripData: TripData): Boolean {
        return try {
            // Create a domain model for trip start with endTime set to null
            val startTime = System.currentTimeMillis()

            // Store updated trip data remotely
            remoteTripRepository.updateTripRemote(tripData.id, Mapper.convertTripDataToEntityModel(tripData))

            // Return true if both local and remote operations were successful
            true
        } catch (e: Exception) {
            // Handle any exceptions if needed
            false
        }
    }
}