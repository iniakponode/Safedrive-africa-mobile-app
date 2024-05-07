package com.uoa.co.db.entity

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "device_profiles")
@Parcelize
data class DriverProfileDataEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val driverType: String = "",
    val vehicleType: String = "",
    val educationLevel: String = "",
    val drivingSchool: Boolean = false,
    val drivingLicense: Boolean = false,
    val email: String = "",
    val phoneType: String = "",
    val password: String = "",
    val registrationDateTime: String = ""
)
    : Parcelable {

    override fun describeContents(): Int = 0

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(driverType)
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
        override fun createFromParcel(parcel: Parcel): DriverProfileDataEntity = DriverProfileDataEntity(
            id = parcel.readLong(),
            driverType = parcel.readString() ?: "",
            vehicleType = parcel.readString() ?: "",
            educationLevel = parcel.readString() ?: "",
            drivingSchool = parcel.readBoolean(),
            drivingLicense = parcel.readBoolean(),
            email = parcel.readString() ?: "",
            phoneType = parcel.readString() ?: "",
            password = parcel.readString() ?: "",
            registrationDateTime = parcel.readString() ?: ""
        )

        override fun newArray(size: Int): Array<DriverProfileDataEntity?> = arrayOfNulls(size)
    }
}


