package com.uoa.sensordatacollection.data.model

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.uoa.sensordatacollection.modulesprovider.LinearAccelerationM
//import com.uoa.trip.data.model.TripDataEntity
import kotlinx.parcelize.Parcelize

@Entity(
    tableName = "sensor_data",

)
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
        parcel.writeFloatArray(
            floatArrayOf(
                accelerometerX,
                accelerometerY,
                accelerometerZ,
                gyroscopeX,
                gyroscopeY,
                gyroscopeZ,
                magnetometerX,
                magnetometerY,
                magnetometerZ,
                rotationVectorX,
                rotationVectorY,
                rotationVectorZ,
                rotationVectorScalar,
                linearAccelerationX,
                linearAccelerationY,
                linearAccelerationZ,
                // Add other float fields accordingly
            )
        )
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

