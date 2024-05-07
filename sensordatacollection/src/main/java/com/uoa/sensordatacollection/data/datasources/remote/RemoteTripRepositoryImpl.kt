package com.uoa.sensordatacollection.data.datasources.remote

import com.uoa.co.db.entity.TripDataEntity


// RemoteTripRepositoryImpl implementation
class RemoteTripRepositoryImpl(private val remoteDataSource: RemoteTripDataSource) : RemoteTripRepository {

    override suspend fun createTripRemote(tripData: com.uoa.co.db.entity.TripDataEntity) {
        remoteDataSource.createTripRemote(tripData)
    }

    override suspend fun deleteTripByIdRemote(tripId: Long) {
        remoteDataSource.deleteTripByIdRemote(tripId)
    }

    override suspend fun deleteTripsForDriverRemote(driverProfileId: Long) {
        remoteDataSource.deleteTripsForDriverRemote(driverProfileId)
    }

    override suspend fun getTripsForDriverRemote(driverProfileId: Long): List<com.uoa.co.db.entity.TripDataEntity> {
        return remoteDataSource.getTripsForDriverRemote(driverProfileId)
    }

    override suspend fun updateTripRemote(tripId: Long, tripData: com.uoa.co.db.entity.TripDataEntity) {
        remoteDataSource.updateTripRemote(tripId,tripData)
    }

    // Add other necessary repository methods, if any
}
