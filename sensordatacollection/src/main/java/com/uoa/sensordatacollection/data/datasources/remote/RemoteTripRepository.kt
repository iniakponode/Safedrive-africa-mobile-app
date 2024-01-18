package com.uoa.sensordatacollection.data.datasources.remote

import com.uoa.sensordatacollection.data.model.TripDataEntity

// RemoteTripRepository interface
interface RemoteTripRepository {

    suspend fun createTripRemote(tripData: TripDataEntity)

    suspend fun deleteTripByIdRemote(tripId: Long)

    suspend fun deleteTripsForDriverRemote(driverProfileId: Long)

    suspend fun getTripsForDriverRemote(driverProfileId: Long): List<TripDataEntity>

    suspend fun updateTripRemote(tripId: Long,tripData: TripDataEntity)

    // Add other necessary repository methods, if any
}

