package com.uoa.sensordatacollection.data.datasources.local

import com.uoa.sensordatacollection.data.dao.TripDao
import com.uoa.sensordatacollection.data.model.TripDataEntity


// LocalTripDataSource implementation
class LocalTripDataSource(private val tripDao: TripDao) {

    suspend fun insertTripLocal(tripData: TripDataEntity): TripDataEntity{
       return tripDao.insertTrip(tripData)
    }
    suspend fun updateTrip(tripData: TripDataEntity): TripDataEntity {
        return tripDao.updateTrip(tripData)
    }
    suspend fun getTrip(tripId: Long): TripDataEntity {
        return tripDao.getTrip(tripId)
    }
    suspend fun deleteTripByIdLocal(tripId: Long) {
        tripDao.deleteTripById(tripId)
    }

    suspend fun deleteTripsForDriverLocal(driverProfileId: Long) {
        tripDao.deleteTripsForDriver(driverProfileId)
    }

    suspend fun getTripsForDriverLocal(driverProfileId: Long): List<TripDataEntity> {
        return tripDao.getTripsForDriver(driverProfileId)
    }

    suspend fun getNewTripData(synced: Boolean): List<TripDataEntity>{
        return tripDao.getNewTripData(synced)
    }

    // Add other necessary local operations, if any
}
