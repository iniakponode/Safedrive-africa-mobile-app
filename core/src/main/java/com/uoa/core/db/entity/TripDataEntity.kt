package com.uoa.core.db.entity

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "trip_data"
    )
@Parcelize
data class TripDataEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val driverProfileId: Long,
    val startTime: Long,
    var endTime: Long?,
    var synced: Boolean=false
    // Other trip data fields
) : Parcelable {
    @RequiresApi(Build.VERSION_CODES.Q)
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readLong(),
        parcel.readLong(),
        parcel.readLong(),
        parcel.readBoolean()
        // Read other fields accordingly
    )

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeLong(driverProfileId)
        parcel.writeLong(startTime)
        parcel.writeLong(endTime!!)
        parcel.writeBoolean(synced)
        // Write other fields accordingly
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TripDataEntity> {
        @RequiresApi(Build.VERSION_CODES.Q)
        override fun createFromParcel(parcel: Parcel): TripDataEntity {
            return TripDataEntity(parcel)
        }

        override fun newArray(size: Int): Array<TripDataEntity?> {
            return arrayOfNulls(size)
        }
    }
}


