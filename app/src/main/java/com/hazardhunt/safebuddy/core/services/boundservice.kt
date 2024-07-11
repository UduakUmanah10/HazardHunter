// ktlint-disable filename
package com.hazardhunt.safebuddy.core.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import com.hazardhunt.safebuddy.sensorscreen.data.MeasurableSensor
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

const val DELAY_TIME = 100L

@AndroidEntryPoint
class Boundservice : Service() {

    @Inject
    lateinit var lightSensor: MeasurableSensor

    // val vm:Sensorviewmodel by viewModel()

    private val binder = MyBinder()

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    fun getProgress(): Flow<Float> {
        var progress = 0f
        var lux = 0f
        lightSensor.startListening()
        return flow {
            lightSensor.startListening()

            lightSensor.setOnSensorValueChangedListener { value ->
                lux = value[0]
            }

            while (true) {
                delay(DELAY_TIME)
                emit(lux)
            }
            // while (progress < 1.0f) {
            // progress += .1f
            // delay(1000)
            //  emit(progress)
            // }
        }
    }

    inner class MyBinder : Binder() {
        fun getService() = this@Boundservice
    }
}
