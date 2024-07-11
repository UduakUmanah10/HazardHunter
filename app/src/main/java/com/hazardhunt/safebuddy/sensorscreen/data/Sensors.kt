// ktlint-disable filename
package com.hazardhunt.safebuddy.sensorscreen.data

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor

class LightSensor(
    context: Context,
) : AndroidSensors(
    context = context,
    senSorFeature = PackageManager.FEATURE_SENSOR_LIGHT,
    sensorType = Sensor.TYPE_LIGHT,

)
