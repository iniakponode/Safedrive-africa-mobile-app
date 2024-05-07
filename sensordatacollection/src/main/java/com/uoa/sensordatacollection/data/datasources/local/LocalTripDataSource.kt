package com.uoa.sensordatacollection.data.datasources.local


// LocalTripDataSource implementation
class LocalTripDataSource(private val tripDao: com.uoa.co.db.dao.TripDao) {

    suspend fun insertTripLocal(tripData: com.uoa.co.db.entity.TripDataEntity): Long {
       return tripDao.insertTrip(tripData)
    }
    suspend fun updateTrip(tripData: com.uoa.co.db.entity.TripDataEntity): Int {
        return tripDao.updateTrip(tripData.id, tripData.driverProfileId, tripData.endTime, tripData.startTime, tripData.synced)
    }
    suspend fun getTrip(tripId: Long): com.uoa.co.db.entity.TripDataEntity {
        return tripDao.getTrip(tripId)
    }
    suspend fun deleteTripByIdLocal(tripId: Long) {
        tripDao.deleteTripById(tripId)
    }

    suspend fun deleteTripsForDriverLocal(driverProfileId: Long) {
        tripDao.deleteTripsForDriver(driverProfileId)
    }

    suspend fun getTripsForDriverLocal(driverProfileId: Long): List<com.uoa.co.db.entity.TripDataEntity> {
        return tripDao.getTripsForDriver(driverProfileId)
    }

    suspend fun getNewTripData(synced: Boolean): List<com.uoa.co.db.entity.TripDataEntity>{
        return tripDao.getNewTripData(synced)
    }

    // Add other necessary local operations, if any
}
