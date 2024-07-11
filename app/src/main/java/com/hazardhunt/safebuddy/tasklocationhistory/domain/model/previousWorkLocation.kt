// ktlint-disable filename
package com.hazardhunt.safebuddy.tasklocationhistory.domain.model

data class PreviousWorkLocation(
    val latitude: Double,
    val longitude: Double,
    val id: Int? = null,
)
