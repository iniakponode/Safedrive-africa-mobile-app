package com.uoa.sensordatacollection.data.datasources.local

import com.uoa.sensordatacollection.data.model.TripDataEntity
import javax.inject.Inject

class LocalTripDataRepositoryImpl @Inject constructor(private val localTripDataSource: LocalTripDataSource): LocalTripDataRepository {
    override suspend fun insertTripLocal(tripData: TripDataEntity): TripDataEntity {
        return localTripDataSource.insertTripLocal(tripData)
    }

    override suspend fun getTrip(tripId: Long): TripDataEntity{
        return localTripDataSource.getTrip(tripId)
    }

    override suspend fun deleteTripByIdLocal(tripId: Long) {
        return localTripDataSource.deleteTripByIdLocal(tripId)
    }

    override suspend fun deleteTripsForDriverLocal(driverProfileId: Long) {
        return localTripDataSource.deleteTripsForDriverLocal(driverProfileId)
    }

    override suspend fun getTripsForDriverLocal(driverProfileId: Long): List<TripDataEntity> {
        return localTripDataSource.getTripsForDriverLocal(driverProfileId)
    }

    override suspend fun updateTrip(tripData: TripDataEntity): TripDataEntity{
        return localTripDataSource.updateTrip(tripData)
    }

    override suspend fun getNewTripData(synced: Boolean): List<TripDataEntity> {
        return localTripDataSource.getNewTripData(synced)
    }

}