package com.uoa.sensordatacollection.data.datasources.local

import com.uoa.co.db.entity.TripDataEntity

// LocalTripDataSource interface
interface LocalTripDataRepository {

    /**
     * Insert a new trip into the local database.
     *
     * @param tripData The trip data to be inserted.
     */
    suspend fun insertTripLocal(tripData: com.uoa.co.db.entity.TripDataEntity) : Long

    /**
     * get a trip data from the local database.
     *
     * @param tripId The trip data to be inserted.
     */
    suspend fun getTrip(tripId: Long): com.uoa.co.db.entity.TripDataEntity

    /**
     * Delete a trip by its id from the local database.
     *
     * @param tripId The id of the trip to be deleted.
     */
    suspend fun deleteTripByIdLocal(tripId: Long)

    /**
     * Delete all trips associated with a given driver profile from the local database.
     *
     * @param driverProfileId The id of the driver profile.
     */
    suspend fun deleteTripsForDriverLocal(driverProfileId: Long)

    /**
     * Get all trips associated with a given driver profile from the local database.
     *
     * @param driverProfileId The id of the driver profile.
     * @return List of trips associated with the driver profile.
     */
    suspend fun getTripsForDriverLocal(driverProfileId: Long): List<com.uoa.co.db.entity.TripDataEntity>

    /**
     * Update a Trip in the local database.
     *
     * @param tripData The id of the trip.
     * @return trip associated with the data.
     */
    suspend fun updateTrip(tripData: com.uoa.co.db.entity.TripDataEntity): Int

    /**
     * Get trips that are not yet uploaded to server from the local database.
     *
     * @param synced The id of the trip.
     * @return trip associated with the data.
     */
    suspend fun getNewTripData(synced: Boolean): List<com.uoa.co.db.entity.TripDataEntity>

    // Add other necessary local operations, if any
}
