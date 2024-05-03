package com.uoa.core.db.entity

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "device_profiles")
@Parcelize
data class DriverProfileDataEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val driverType: String, // Public or Private
    val vehicleType: String, // Taxi, Bus, Trailer, Lorry
    val educationLevel: String, // No school, Primary, Secondary, University
    val drivingSchool: Boolean, // Yes or No
    val drivingLicense: Boolean, // Yes or No
    val email: String, // Driver's email
    val phoneType: String, // Type of phone
    val password: String, // Password
    val registrationDateTime: String // Registration date and time
) : Parcelable {

    @RequiresApi(Build.VERSION_CODES.Q)
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readBoolean(),
        parcel.readBoolean(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )
    override fun describeContents(): Int {
        return 0
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(vehicleType)
        parcel.writeString(educationLevel)
        parcel.writeBoolean(drivingSchool)
        parcel.writeBoolean(drivingLicense)
        parcel.writeString(email)
        parcel.writeString(phoneType)
        parcel.writeString(password)
        parcel.writeString(registrationDateTime)
    }

    companion object CREATOR : Parcelable.Creator<DriverProfileDataEntity> {
        @RequiresApi(Build.VERSION_CODES.Q)
        override fun createFromParcel(parcel: Parcel): DriverProfileDataEntity {
            return DriverProfileDataEntity(parcel)
        }

        override fun newArray(size: Int): Array<DriverProfileDataEntity?> {
            return arrayOfNulls(size)
        }
    }
}
