// ktlint-disable filename
package com.hazardhunt.safebuddy.tasklocationhistory.data

import com.hazardhunt.safebuddy.tasklocationhistory.domain.model.PreviousWorkLocation
/**
 * Mapper class
 * */

fun PreviousWorkSpotEntity.toWorkSpot(): PreviousWorkLocation {
    return PreviousWorkLocation(
        latitude = latitude,
        longitude = longitude,
        id = id,
    )
}

fun PreviousWorkLocation.topreviousWorkSpotEntity(): PreviousWorkSpotEntity {
    return PreviousWorkSpotEntity(
        latitude = latitude,
        longitude = longitude,
        id = id,
    )
}
