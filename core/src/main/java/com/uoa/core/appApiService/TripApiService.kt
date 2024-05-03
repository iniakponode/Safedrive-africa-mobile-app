package com.uoa.core.appApiService

import com.uoa.core.db.entity.TripDataEntity
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TripApiService {

    /**
     * Create a new trip remotely.
     *
     * @param tripData The trip data to be created.
     */
    @POST("trips")
    suspend fun createTrip(@Body tripData: TripDataEntity)

    /**
     * Update a trip remotely.
     *
     * @param tripId The id of the trip to be updated.
     * @param tripData The updated trip data.
     */
    @PUT("trips/{tripId}")
    suspend fun updateTripRemote(@Path("tripId") tripId: Long, @Body tripData: TripDataEntity)

    /**
     * Get a specific trip by its id remotely.
     *
     * @param tripId The id of the trip to retrieve.
     * @return The trip associated with the given id.
     */
    @GET("trips/single/{tripId}")
    suspend fun getTripById(@Path("tripId") tripId: Long): TripDataEntity

    /**
     * Delete a trip remotely by its id.
     *
     * @param tripId The id of the trip to be deleted.
     */
    @DELETE("trips/{tripId}")
    suspend fun deleteTripById(@Path("tripId") tripId: Long)

    /**
     * Delete all trips associated with a given driver profile remotely.
     *
     * @param driverProfileId The id of the driver profile.
     */
    @DELETE("trips/{driverProfileId}")
    suspend fun deleteTripsForDriver(@Path("driverProfileId") driverProfileId: Long)

    /**
     * Get all trips associated with a given driver profile remotely.
     *
     * @param driverProfileId The id of the driver profile.
     * @return List of trips associated with the driver profile.
     */
    @GET("trips/{driverProfileId}")
    suspend fun getTripsForDriver(@Path("driverProfileId") driverProfileId: Long): List<TripDataEntity>

    // Add other necessary remote operations, if any
}

