package com.uoa.core.db.entity

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

//import com.uoa.trip.data.model.TripDataEntity

@Entity(
    tableName = "sensor_data",

)
@Parcelize
data class SensorDataEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val tripDataId: Long,
    val timestamp: Long,
    val synced: Boolean=false,
    val accelerometerX: Float,
    val accelerometerY: Float,
    val accelerometerZ: Float,
    val gyroscopeX: Float,
    val gyroscopeY: Float,
    val gyroscopeZ: Float,
    val magnetometerX: Float,
    val magnetometerY: Float,
    val magnetometerZ: Float,
    val rotationVectorX: Float,
    val rotationVectorY: Float,
    val rotationVectorZ: Float,
    val rotationVectorScalar: Float,
    val linearAccelerationX: Float,
    val linearAccelerationY: Float,
    val linearAccelerationZ: Float,
    // Other sensor data fields
) : Parcelable {

    @RequiresApi(Build.VERSION_CODES.Q)
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readLong(),
        parcel.readLong(),
        parcel.readBoolean(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),

        // Read other fields accordingly
    )

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeLong(tripDataId)
        parcel.writeLong(timestamp)
        parcel.writeBoolean(synced)
        parcel.writeFloat(accelerometerX)
        parcel.writeFloat(accelerometerY)
        parcel.writeFloat(accelerometerZ)
        parcel.writeFloat(gyroscopeX)
        parcel.writeFloat(gyroscopeY)
        parcel.writeFloat(gyroscopeZ)
        parcel.writeFloat(magnetometerX)
        parcel.writeFloat(magnetometerY)
        parcel.writeFloat(magnetometerZ)
        parcel.writeFloat(rotationVectorX)
        parcel.writeFloat(rotationVectorY)
        parcel.writeFloat(rotationVectorZ)
        parcel.writeFloat(rotationVectorScalar)
        parcel.writeFloat(linearAccelerationX)
        parcel.writeFloat(linearAccelerationY)
        parcel.writeFloat(linearAccelerationZ)
                // Add other float fields accordingly
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SensorDataEntity> {
        @RequiresApi(Build.VERSION_CODES.Q)
        override fun createFromParcel(parcel: Parcel): SensorDataEntity {
            return SensorDataEntity(parcel)
        }

        override fun newArray(size: Int): Array<SensorDataEntity?> {
            return arrayOfNulls(size)
        }
    }
}

