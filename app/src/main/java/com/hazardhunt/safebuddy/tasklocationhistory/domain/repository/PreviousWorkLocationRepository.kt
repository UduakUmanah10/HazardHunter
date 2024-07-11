package com.hazardhunt.safebuddy.tasklocationhistory.domain.repository

import com.hazardhunt.safebuddy.tasklocationhistory.domain.model.PreviousWorkLocation
import kotlinx.coroutines.flow.Flow

interface PreviousWorkLocationRepository {

    suspend fun insertWorkLocation(locationDetails: PreviousWorkLocation)

    suspend fun deletePreviousWorkLocation(location: PreviousWorkLocation)

    suspend fun getAllPreviousLocation(): Flow<List<PreviousWorkLocation>>
}
