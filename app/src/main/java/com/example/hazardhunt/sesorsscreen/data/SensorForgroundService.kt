package com.example.hazardhunt.sesorsscreen.data

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.hazardhunt.R

class SensorForgroundService : Service() {

    /**
     * this method receives an intent and returns an Ibinder that is used
     * to create a bound service. you can have one single instance of the ibinder
     * and multiple component connects to this service instance and have a stream for
     * communication and also receiving events or call backs from the service
     */

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    /**
     *this methods determines what triggers the service to start.
     * this is triggered when another android component sends an intent to this running service.
     * intents can contain data.
     *
     * the stopSelfIf() function is used to stop the service
     *
     * */

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            Actions.START.toString() -> start()
            Actions.STOP.toString() -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    /**
     *fore fround service needs to come with persistent notification to notify the user
     * that there is a running service running in the background.
     *
     * */

    private fun start() {
        /**
         *startForeGround takes in an Id and Notification that corresponds to a specific notification
         * to update the notification you should call the function with expected id.
         * do not use Zero it needs to have an integer value of 1.
         * this key word is used because every service is a context.
         * this context is limited to the lifetime of the service.
         *
         * */

        val notification = NotificationCompat
            .Builder(this, "running_channel")
            .setSmallIcon(R.drawable.shield)
            .setContentTitle("Sensor is Active")
            .setContentText("------------")
            .build()

        startForeground(1, notification)
    }

    enum class Actions {
        START, STOP
    }
}
