// ktlint-disable filename
package com.example.hazardhunt.sensorscreen.di

import android.app.Application
import com.example.hazardhunt.sensorscreen.data.LightSensor
import com.example.hazardhunt.sensorscreen.data.MeasurableSensor
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
