// ktlint-disable filename
package com.example.hazardhunt.core.localstorage

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SafeTasks")
data class Persistedsafetytask(
    @PrimaryKey val id: Int? = null,
    val taskTitle: String,
    val description: String,
    val scheduledDate: String,
    val scheduledTime: String,
    val longitude: Double,
    val latitude: Double,
    val completionStatus: String,
    val turnOnLight: Boolean,
    val turnOnTemperatureSensor: Boolean,
    val turnOnPressureSensor: Boolean,
    val turnOnProximitySensor: Boolean,

)
