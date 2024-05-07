package com.uoa.sensordatacollection.data.datasources.local

import com.uoa.co.db.entity.TripDataEntity
import javax.inject.Inject

class LocalTripDataRepositoryImpl @Inject constructor(private val localTripDataSource: LocalTripDataSource): LocalTripDataRepository {
    override suspend fun insertTripLocal(tripData: com.uoa.co.db.entity.TripDataEntity): Long {
        return localTripDataSource.insertTripLocal(tripData)
    }

    override suspend fun getTrip(tripId: Long): com.uoa.co.db.entity.TripDataEntity {
        return localTripDataSource.getTrip(tripId)
    }

    override suspend fun deleteTripByIdLocal(tripId: Long) {
        return localTripDataSource.deleteTripByIdLocal(tripId)
    }

    override suspend fun deleteTripsForDriverLocal(driverProfileId: Long) {
        return localTripDataSource.deleteTripsForDriverLocal(driverProfileId)
    }

    override suspend fun getTripsForDriverLocal(driverProfileId: Long): List<com.uoa.co.db.entity.TripDataEntity> {
        return localTripDataSource.getTripsForDriverLocal(driverProfileId)
    }

    override suspend fun updateTrip(tripData: com.uoa.co.db.entity.TripDataEntity): Int {
        return localTripDataSource.updateTrip(tripData)
    }

    override suspend fun getNewTripData(synced: Boolean): List<com.uoa.co.db.entity.TripDataEntity> {
        return localTripDataSource.getNewTripData(synced)
    }

}