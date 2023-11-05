package com.example.hazardhunt.sesorsscreen.data

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

abstract class AndroidSensors(
    private val context: Context,
    private val senSorFeature: String,
    sensorType: Int,

) : MeasurableSensor(sensorType), SensorEventListener {

    override val doesSensorExist: Boolean
        get() = context.packageManager.hasSystemFeature(senSorFeature)

    /**
     * SensorManager is the system service from android that is responsible for
     * reporting the sensor value
     * */

    private lateinit var sensorManager: SensorManager

    /**
     * this would be returned from the sensor manager when they triggered to
     * start listening and which sensor we should start listening to
     * */

    private var sensor: Sensor? = null

    override fun startListening() {
        if (!doesSensorExist) {
            return
        }

        /**
         * this function checks if  this is the first time that a function is
         * being initialized to determine if we should start listening to the sensor
         * or initialize the sensor first.
         * */
        if (!::sensorManager.isInitialized && sensor == null) {
            sensorManager = context.getSystemService(SensorManager::class.java) as SensorManager
            sensor = sensorManager.getDefaultSensor(typeofSensor)
        }
        sensor?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun stopListening() {
        if (!doesSensorExist || !::sensorManager.isInitialized) {
            return
        }

        sensor?.let {
            sensorManager.unregisterListener(this)
        }
    }

    /**
     * the onSensorChanged function is used to trigger the  onsensorvalue changed value
     * whenever there is a new sensor value
     **/

    override fun onSensorChanged(event: SensorEvent?) {
        if (!doesSensorExist) {
            return
        }
        if (event?.sensor?.type == typeofSensor) {
            onSensorValueChanged?.invoke(event.values.toList())
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        println("""""")
    }
}
