package com.uoa.sensordatacollection.data.datasources.remote

import com.uoa.sensordatacollection.data.model.TripDataEntity
import com.uoa.trip.data.api.TripApiService


// RemoteTripDataSource implementation
class RemoteTripDataSource(private val apiService: TripApiService) {
    suspend fun createTripRemote(tripData: TripDataEntity) {
        apiService.createTrip(tripData)
    }

    suspend fun getTripRemote(tripId: Long): TripDataEntity{
        return apiService.getTripById(tripId)
    }

    suspend fun updateTripRemote(tripId: Long,tripData: TripDataEntity){
        apiService.updateTripRemote(tripData.id,tripData)
    }

    suspend fun deleteTripByIdRemote(tripId: Long) {
        apiService.deleteTripById(tripId)
    }

    suspend fun deleteTripsForDriverRemote(driverProfileId: Long) {
        apiService.deleteTripsForDriver(driverProfileId)
    }

    suspend fun getTripsForDriverRemote(driverProfileId: Long): List<TripDataEntity> {
        return apiService.getTripsForDriver(driverProfileId)
    }
}
