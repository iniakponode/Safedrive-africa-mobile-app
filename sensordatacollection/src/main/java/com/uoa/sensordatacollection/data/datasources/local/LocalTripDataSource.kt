package com.uoa.sensordatacollection.data.datasources.local

import com.uoa.core.db.dao.TripDao
import com.uoa.core.db.entity.TripDataEntity


// LocalTripDataSource implementation
class LocalTripDataSource(private val tripDao: com.uoa.core.db.dao.TripDao) {

    suspend fun insertTripLocal(tripData: com.uoa.core.db.entity.TripDataEntity): com.uoa.core.db.entity.TripDataEntity {
       return tripDao.insertTrip(tripData)
    }
    suspend fun updateTrip(tripData: com.uoa.core.db.entity.TripDataEntity): com.uoa.core.db.entity.TripDataEntity {
        return tripDao.updateTrip(tripData)
    }
    suspend fun getTrip(tripId: Long): com.uoa.core.db.entity.TripDataEntity {
        return tripDao.getTrip(tripId)
    }
    suspend fun deleteTripByIdLocal(tripId: Long) {
        tripDao.deleteTripById(tripId)
    }

    suspend fun deleteTripsForDriverLocal(driverProfileId: Long) {
        tripDao.deleteTripsForDriver(driverProfileId)
    }

    suspend fun getTripsForDriverLocal(driverProfileId: Long): List<com.uoa.core.db.entity.TripDataEntity> {
        return tripDao.getTripsForDriver(driverProfileId)
    }

    suspend fun getNewTripData(synced: Boolean): List<com.uoa.core.db.entity.TripDataEntity>{
        return tripDao.getNewTripData(synced)
    }

    // Add other necessary local operations, if any
}
