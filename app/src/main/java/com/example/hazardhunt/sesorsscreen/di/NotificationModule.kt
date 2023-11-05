package com.example.hazardhunt.sesorsscreen.di

import android.content.Context
import com.example.hazardhunt.sesorsscreen.core.SensorNotification
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotificationModule {

    @Module
    @InstallIn(SingletonComponent::class)
    object notificationmodule {

        @Provides
        @Singleton
        fun provideNotificationService(@ApplicationContext context: Context): SensorNotification {
            return SensorNotification(context)
        }
    }
}
