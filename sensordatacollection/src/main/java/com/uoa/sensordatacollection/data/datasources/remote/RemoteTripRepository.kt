package com.uoa.sensordatacollection.data.datasources.remote

import com.uoa.core.db.entity.TripDataEntity

// RemoteTripRepository interface
interface RemoteTripRepository {

    suspend fun createTripRemote(tripData: com.uoa.core.db.entity.TripDataEntity)

    suspend fun deleteTripByIdRemote(tripId: Long)

    suspend fun deleteTripsForDriverRemote(driverProfileId: Long)

    suspend fun getTripsForDriverRemote(driverProfileId: Long): List<com.uoa.core.db.entity.TripDataEntity>

    suspend fun updateTripRemote(tripId: Long,tripData: com.uoa.core.db.entity.TripDataEntity)

    // Add other necessary repository methods, if any
}

