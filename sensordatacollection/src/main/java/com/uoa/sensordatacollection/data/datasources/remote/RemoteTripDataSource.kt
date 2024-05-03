package com.uoa.sensordatacollection.data.datasources.remote

import com.uoa.core.db.entity.TripDataEntity
import com.uoa.core.appApiService.TripApiService


// RemoteTripDataSource implementation
class RemoteTripDataSource(private val apiService: com.uoa.core.appApiService.TripApiService) {
    suspend fun createTripRemote(tripData: com.uoa.core.db.entity.TripDataEntity) {
        apiService.createTrip(tripData)
    }

    suspend fun getTripRemote(tripId: Long): com.uoa.core.db.entity.TripDataEntity {
        return apiService.getTripById(tripId)
    }

    suspend fun updateTripRemote(tripId: Long,tripData: com.uoa.core.db.entity.TripDataEntity){
        apiService.updateTripRemote(tripData.id,tripData)
    }

    suspend fun deleteTripByIdRemote(tripId: Long) {
        apiService.deleteTripById(tripId)
    }

    suspend fun deleteTripsForDriverRemote(driverProfileId: Long) {
        apiService.deleteTripsForDriver(driverProfileId)
    }

    suspend fun getTripsForDriverRemote(driverProfileId: Long): List<com.uoa.core.db.entity.TripDataEntity> {
        return apiService.getTripsForDriver(driverProfileId)
    }
}
