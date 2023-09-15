// ktlint-disable filename
package com.example.hazardhunt.tasklocationhistory.presentation

import com.example.hazardhunt.tasklocationhistory.domain.model.PreviousWorkLocation
import com.google.android.gms.maps.model.LatLng

sealed class MapScreenEvent {
    object ToggleFalloutMap : MapScreenEvent()

    data class onMapLongClick(val latitudeAndLongitude: LatLng) : MapScreenEvent()
    data class onInfoWindowLongClick(val location: PreviousWorkLocation) : MapScreenEvent()
}
