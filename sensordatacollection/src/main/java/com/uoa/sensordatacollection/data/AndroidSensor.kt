package com.uoa.sensordatacollection.data

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.time.Instant
import javax.inject.Inject

//import javax.inject.Inject

abstract class AndroidSensor @Inject constructor(
    private val context: Context,
    sensorType: Int
) : TrackingSensor(sensorType), SensorEventListener {

    override fun doesSensorExist(): Boolean {
        return sensorManager.getDefaultSensor(sensorType) != null
    }

//        get() = true
//        get() = context.packageManager.hasSystemFeature(sensorFeature)

    private lateinit var sensorManager: SensorManager
    private var sensor: Sensor? = null

    override fun startListeningToSensor(rate: Int): Boolean {
        if (!doesSensorExist()) return false

        sensorManager.takeUnless { ::sensorManager.isInitialized }
            ?.apply { this@AndroidSensor.context.getSystemService(Context.SENSOR_SERVICE) as SensorManager }

        sensor?.let {
            // This block will be executed only if sensor is not null
            // Inside this block, you can use 'it' to refer to the non-null sensor
            val defaultSensor = sensorManager.getDefaultSensor(sensorType)
            if (defaultSensor != null) {
                this@AndroidSensor.sensor = defaultSensor
            } else {
                // Handle the case where the default sensor is not available
                // You may want to log a message, notify the user, or take appropriate action
                Log.i("DefaultSensor", "No Default Sensor")
                return false
            }
        }

        sensor?.let {
            return sensorManager.registerListener(this, it, rate)
        }

        return false
    }

    override fun stopListeningToSensor() {
        if (!doesSensorExist() || !::sensorManager.isInitialized) return
        sensorManager.unregisterListener(this)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onSensorChanged(event: SensorEvent?) {
        if (!doesSensorExist()) return

        if (event?.sensor?.type == sensorType) {
            onSensorValueChanged?.invoke(event.values.toList())
            sensorTimestamp?.invoke(Instant.now())
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        if (!doesSensorExist() || sensor != sensorManager.getDefaultSensor(sensorType)) return
        onAccuracyValueChanged?.invoke(accuracy)
    }
}
