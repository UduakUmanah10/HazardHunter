// ktlint-disable filename
package com.example.hazardhunt.sesorsscreen.di

import android.app.Application
import com.example.hazardhunt.sesorsscreen.data.LightSensor
import com.example.hazardhunt.sesorsscreen.data.MeasurableSensor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SensorModule {

    @Provides
    @Singleton
    fun provideLightSensor(app: Application): MeasurableSensor {
        return LightSensor(app)
    }
}
