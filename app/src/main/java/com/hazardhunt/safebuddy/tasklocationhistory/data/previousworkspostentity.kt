// ktlint-disable filename
package com.hazardhunt.safebuddy.tasklocationhistory.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class PreviousWorkSpotEntity(
    val latitude: Double,
    val longitude: Double,
    @PrimaryKey val id: Int? = null,

)
