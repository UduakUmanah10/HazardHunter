// ktlint-disable filename
package com.hazardhunt.safebuddy.tasklocationhistory.presentation

import com.google.android.gms.maps.model.LatLng
import com.hazardhunt.safebuddy.tasklocationhistory.domain.model.PreviousWorkLocation

sealed class MapScreenEvent {
    object ToggleFalloutMap : MapScreenEvent()

    data class onMapLongClick(val latitudeAndLongitude: LatLng) : MapScreenEvent()
    data class onInfoWindowLongClick(val location: PreviousWorkLocation) : MapScreenEvent()
}
