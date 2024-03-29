package com.uoa.sdaapp.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.uoa.deviceprofile.data.model.DriverProfileDataEntity

class Converters {

    @TypeConverter
    fun fromDriverProfile(driverProfileDataEntity: DriverProfileDataEntity): String {
        val gson = Gson()
        val type = object : TypeToken<DriverProfileDataEntity>() {}.type
        return gson.toJson(driverProfileDataEntity, type)
    }

    @TypeConverter
    fun toDriverProfile(driverProfileString: String): DriverProfileDataEntity {
        val gson = Gson()
        val type = object : TypeToken<DriverProfileDataEntity>() {}.type
        return gson.fromJson(driverProfileString, type)
    }
}
