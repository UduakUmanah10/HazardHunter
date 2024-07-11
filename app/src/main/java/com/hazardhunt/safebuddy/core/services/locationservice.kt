// ktlint-disable filename
package com.hazardhunt.safebuddy.core.services

import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.google.android.gms.location.LocationServices
import com.hazardhunt.safebuddy.R
import com.hazardhunt.safebuddy.core.location.Locationclient
import com.hazardhunt.safebuddy.core.location.SafetyTaskLocationClient
import com.hazardhunt.safebuddy.sensorscreen.data.MeasurableSensor
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

const val NOTIFICATION_CHANNEL = 11
const val DELAY_LOCATION = 10000L

@AndroidEntryPoint
class LocationService : Service() {

    @Inject
    lateinit var lightSensor: MeasurableSensor

    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private lateinit var locationClient: Locationclient

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        locationClient = SafetyTaskLocationClient(
            applicationContext,
            LocationServices.getFusedLocationProviderClient(applicationContext),
        )
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            START_TRACKING -> start()
            STOP_TRACKING -> stop()
        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun start() {
        var sensor: Float? = null

        lightSensor.startListening()
        lightSensor.setOnSensorValueChangedListener { value ->
            val lux = value[0]
            sensor = lux
            Toast.makeText(this, "$sensor", Toast.LENGTH_LONG).show()
        }
        val notification = NotificationCompat
            .Builder(this, "location_track")
            .setContentTitle("Tracking location")
            .setContentText("Location: null")
            .setSmallIcon(R.drawable.sensorstate)
            .setOngoing(true)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        locationClient
            .getLocationUpdate(DELAY_LOCATION).catch {
                    e ->
                e.printStackTrace()
            }.onEach { locatoin ->
                val lat = locatoin.latitude.toString()
                val lon = locatoin.longitude.toString()

                val updatedNotification = notification.setContentText(
                    "Location($lat, $lon ,$sensor)",
                )

                notificationManager.notify(NOTIFICATION_CHANNEL, updatedNotification.build())
            }.launchIn(serviceScope)

        startForeground(NOTIFICATION_CHANNEL, notification.build())
    }

    private fun stop() {
        stopForeground(true)
        stopSelf()
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
    }

    companion object {
        const val START_TRACKING = "ACTION_START"
        const val STOP_TRACKING = "ACTION_STOP"
    }
}
