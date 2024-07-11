// ktlint-disable filename
package com.hazardhunt.safebuddy.core.location

import android.location.Location
import kotlinx.coroutines.flow.Flow

interface Locationclient {

    fun getLocationUpdate(interval: Long): Flow<Location>

    class LocationException(message: String) : Exception()
}
