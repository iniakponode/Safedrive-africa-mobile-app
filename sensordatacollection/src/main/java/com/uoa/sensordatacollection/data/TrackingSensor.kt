package com.uoa.sensordatacollection.data

import java.time.Instant

abstract class TrackingSensor(
    protected val sensorType: Int
) {
    protected var onSensorValueChanged: ((List<Float>) -> Unit)? = null
    protected var onAccuracyValueChanged: ((Int) -> Unit)? = null
    protected var sensorTimestamp: ((Instant) -> Unit)? = null
//    abstract val doesSensorExist: Boolean
    abstract fun doesSensorExist(): Boolean
    abstract fun startListeningToSensor(rate: Int): Boolean
    abstract fun stopListeningToSensor()

    fun setOnSensorValuesChangedListener(listener: (List<Float>) -> Unit) {
        onSensorValueChanged = listener
    }

    fun setTimestampOnSensorChangedListener(listener: (Instant) -> Unit) {
        sensorTimestamp = listener
    }

    fun setOnAccuracyValueChangedListener(listener: (Int) -> Unit) {
        onAccuracyValueChanged = listener
    }
}
