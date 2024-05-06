package com.uoa.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.uoa.core.db.dao.DriverProfileDao
import com.uoa.core.db.dao.SensorDao
import com.uoa.core.db.dao.TripDao
import com.uoa.core.db.entity.DriverProfileDataEntity
import com.uoa.core.db.entity.SensorDataEntity
import com.uoa.core.db.entity.TripDataEntity


@Database(
    entities = [
        DriverProfileDataEntity::class,
        TripDataEntity::class,
        SensorDataEntity::class
    ],
    version=14, exportSchema=false
)
@TypeConverters(Converters::class)
abstract class Sdaapp: RoomDatabase(){
    abstract fun driverProfile(): DriverProfileDao
    abstract fun trip(): TripDao
    abstract fun sensordao(): SensorDao
}