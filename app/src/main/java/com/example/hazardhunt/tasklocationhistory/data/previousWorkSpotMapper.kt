// ktlint-disable filename
package com.example.hazardhunt.tasklocationhistory.data

import com.example.hazardhunt.tasklocationhistory.domain.model.PreviousWorkLocation
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
