package com.example.hazardhunt.sesorsscreen.di

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.hazardhunt.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotificationModule {

    @Singleton
    @Provides
    fun provideNotificationBuilder(
        @ApplicationContext context: Context,
    ): NotificationCompat.Builder {
        return NotificationCompat
            .Builder(context, "Main Channel ID")
            .setContentTitle("Active Sensor")
            .setContentText(" Active Sensor: value")
            .setSmallIcon(R.drawable.sensorstate)
            .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.sensorpng))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT) // done to support older devices
    }

    @SuppressLint("SuspiciousIndentation")
    @Singleton
    @Provides
    fun provideNotificationManager(
        @ApplicationContext context: Context,
    ): NotificationManagerCompat {
        val notificationManager = NotificationManagerCompat.from(context)

        val channel = NotificationChannel(
            "Main Channel Id",
            "Main channel",
            NotificationManager.IMPORTANCE_DEFAULT,
        )
        notificationManager.createNotificationChannel(channel)

        return notificationManager
    }
}
