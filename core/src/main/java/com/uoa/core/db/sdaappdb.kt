package com.uoa.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.uoa.core.db.dao.DriverProfileDao
import com.uoa.core.db.dao.SensorDao
import com.uoa.core.db.dao.TripDao


@Database(
    entities = [
        DriverProfileDao::class,
    ],
    version=14, exportSchema=false
)
@TypeConverters(Converters::class)
abstract class Sdaapp: RoomDatabase(){
    abstract fun driverProfile(): DriverProfileDao
    abstract fun trip(): TripDao
    abstract fun sensordao(): SensorDao
}