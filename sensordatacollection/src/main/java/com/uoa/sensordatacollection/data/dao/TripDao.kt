package com.uoa.sensordatacollection.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.uoa.sensordatacollection.data.model.TripDataEntity

@Dao
interface TripDao {

    /**
     * Insert a new trip into the database.
     *
     * @param tripData The trip data to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrip(tripData: TripDataEntity) :TripDataEntity

    /**
     * Delete a trip by its id.
     *
     * @param tripId The id of the trip to be deleted.
     */
    @Query("DELETE FROM trip_data WHERE id = :tripId")
    suspend fun deleteTripById(tripId: Long)

    /**
     * Delete all trips associated with a given driver profile.
     *
     * @param driverProfileId The id of the driver profile.
     */
    @Query("DELETE FROM trip_data WHERE driverProfileId = :driverProfileId")
    suspend fun deleteTripsForDriver(driverProfileId: Long)

    /**
     * Get all trips associated with a given driver profile.
     *
     * @param driverProfileId The id of the driver profile.
     * @return List of trips associated with the driver profile.
     */
    @Query("SELECT * FROM trip_data WHERE driverProfileId = :driverProfileId")
    suspend fun getTripsForDriver(driverProfileId: Long): List<TripDataEntity>

    /**
     * Get a specific trip by its id.
     *
     * @param tripId The id of the trip.
     * @return The specific trip.
     */
    @Query("SELECT * FROM trip_data WHERE id = :tripId")
    suspend fun getTrip(tripId: Long): TripDataEntity

    /**
     * Update a trip in the database.
     *
     * @param tripData The trip data to be updated.
     */
    @Update
    suspend fun updateTrip(tripData: TripDataEntity): TripDataEntity

    @Query("SELECT * FROM trip_data WHERE synced = :syncd")
    suspend fun getNewTripData(syncd: Boolean): List<TripDataEntity>

    // Add other necessary operations, if any
}

