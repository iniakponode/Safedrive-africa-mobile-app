package com.uoa.sensordatacollection.modulesprovider.trip

import android.util.Log
import com.uoa.sensordatacollection.data.datasources.local.LocalTripDataRepository
import com.uoa.sensordatacollection.data.datasources.remote.RemoteTripRepository

import javax.inject.Inject

class StopTripUseCase @Inject constructor(
    private val localTripRepository: LocalTripDataRepository,
    private val remoteTripRepository: RemoteTripRepository
) {

    suspend fun execute(driverProfileId: Long): Boolean {

      try {
          // Retrieve the trip data from the local repository
          val tripData = localTripRepository.getTrip(driverProfileId)

          // Update the endTime in the domain model
          val endTime = System.currentTimeMillis()
          tripData.endTime = endTime

                  // Store updated trip data locally
          localTripRepository.updateTrip(tripData)

          return true
      }
      catch (e: Exception){
          // Handle database operation exceptions
          Log.e("StopTripUseCase", "Error stopping trip: ${e.message}")
          return false
      }


    }
}
