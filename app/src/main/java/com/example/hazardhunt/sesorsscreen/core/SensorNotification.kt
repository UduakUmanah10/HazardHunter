package com.example.hazardhunt.sesorsscreen.core

import android.app.Notification
import android.app.Notification.VISIBILITY_PUBLIC
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.net.toUri
import com.example.hazardhunt.MainActivity
import com.example.hazardhunt.R

const val MY_URI = "https://uduakumanah"
const val ARGUEMENT = "default"
const val KEY = "default"

class SensorNotification(
    private val context1: Context,
) {
    val notificationManager = context1.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun checkCodeVersion() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M

    fun CounterNotification(
        context: Context,
        channelId: String,
        notificationMessage: String,
        notificationTitle: String,
    ): Notification {
        val flag = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        val consumedIntent = Intent(context, MainActivity::class.java)

        val deeplinkpendingintent = Intent(
            Intent.ACTION_VIEW,
            "$MY_URI/$KEY=coming from notification".toUri(),
            context1,
            MainActivity::class.java,
        )

        val clickPendingIntent: PendingIntent = TaskStackBuilder.create(context1).run {
            addNextIntentWithParentStack(deeplinkpendingintent)
            getPendingIntent(9, flag)
        }

        val pendingIntent = PendingIntent.getActivity(
            context,
            1,
            consumedIntent,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0,

        )

        return NotificationCompat
            .Builder(context, channelId)
            .setContentText(" the counter is $notificationMessage ")
            .setContentTitle(notificationTitle)
            .setSmallIcon(R.drawable.sensorstate)
            .setContentIntent(clickPendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH) // for olderversion
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .addAction(
                R.drawable.sensorstate,
                "Increment",
                pendingIntent,

            )
            .build()
    }

    fun showNotification(
        notificationId: Int,
        channel_Id: String,
        notificationMessage: String,
        notificationTitle: String,
    ) {
        val notification = CounterNotification(context1, channel_Id, notificationMessage, notificationTitle)
        notificationManager.notify(notificationId, notification)
    }

    fun cancelNotification(notificationId: Int) {
        notificationManager.cancel(notificationId)
    }

    companion object {
        const val SERVICE_CHANNEL_ID = "service_channel"
        const val COUNTER_CHANNEL_ID = "counter_channel"
        const val COUNTER_CHANNEL_NAME = "Lakner Notification_class"
        const val ID = 5
    }
}
