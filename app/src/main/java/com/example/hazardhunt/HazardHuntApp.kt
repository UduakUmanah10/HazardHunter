package com.example.hazardhunt

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.example.hazardhunt.sesorsscreen.core.SensorNotification
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HazardHuntApp : Application() {

    override fun onCreate() {
        super.onCreate()

        super.onCreate()
        /**
         * this is done for the very first her so that the channel is instiated when the
         * app run for the firdt time
         *
         *
         * notificitation channels were introduced in android oreo so we need to check first
         */

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(
                SensorNotification.SERVICE_CHANNEL_ID,
                "service channel",
                "Test Notification",
            )
        }
    }

    /**
     * a notification channel is a class that consumes notifications uses specific id to
     * categorizing the notifications  into various types for the purpose of updates
     **/

    private fun createNotificationChannel(
        channelId: String,
        channelName: String,
        channelDescription: String,
    ) {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channel = NotificationChannel(
            channelId,
            channelName,
            NotificationManager.IMPORTANCE_HIGH,
        )
        channel.description = channelDescription

        notificationManager.createNotificationChannel(channel)
    }
}
