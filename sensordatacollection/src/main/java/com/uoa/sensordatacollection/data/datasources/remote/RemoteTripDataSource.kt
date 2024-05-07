package com.uoa.sensordatacollection.data.datasources.remote

import com.uoa.co.db.entity.TripDataEntity
import com.uoa.co.appApiService.TripApiService


// RemoteTripDataSource implementation
class RemoteTripDataSource(private val apiService: com.uoa.co.appApiService.TripApiService) {
    suspend fun createTripRemote(tripData: com.uoa.co.db.entity.TripDataEntity) {
        apiService.createTrip(tripData)
    }

    suspend fun getTripRemote(tripId: Long): TripDataEntity {
        return apiService.getTripById(tripId)
    }

    suspend fun updateTripRemote(tripId: Long,tripData: TripDataEntity){
        apiService.updateTripRemote(tripId,tripData)
    }

    suspend fun deleteTripByIdRemote(tripId: Long) {
        apiService.deleteTripById(tripId)
    }

    suspend fun deleteTripsForDriverRemote(driverProfileId: Long) {
        apiService.deleteTripsForDriver(driverProfileId)
    }

    suspend fun getTripsForDriverRemote(driverProfileId: Long): List<com.uoa.co.db.entity.TripDataEntity> {
        return apiService.getTripsForDriver(driverProfileId)
    }
}
