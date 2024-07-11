// ktlint-disable filename
package com.hazardhunt.safebuddy.tasklocationhistory.presentation

import com.google.maps.android.compose.MapProperties
import com.hazardhunt.safebuddy.tasklocationhistory.domain.model.PreviousWorkLocation

/**
 *
 *
 * this is a class that is responsible for handling the state of the map screen
 * it takes in parameters such as:
 * @param[properties] which is responsible for changing som map specific configurations
 * @param[isFalloutMap] which is responsible for switching the fallout map mode on or off
 *
 *
 * */
data class Mapscreenstate(
    val properties: MapProperties = MapProperties(),
    val previousWorkSpot: List<PreviousWorkLocation> = emptyList(),
    val isFalloutMap: Boolean = false,
)
