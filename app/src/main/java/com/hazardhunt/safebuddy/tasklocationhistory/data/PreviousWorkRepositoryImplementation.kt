package com.hazardhunt.safebuddy.tasklocationhistory.data

import com.hazardhunt.safebuddy.tasklocationhistory.domain.model.PreviousWorkLocation
import com.hazardhunt.safebuddy.tasklocationhistory.domain.repository.PreviousWorkLocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PreviousWorkRepositoryImplementation(private val dao: PreviousWorkSpotDao) : PreviousWorkLocationRepository {
    override suspend fun insertWorkLocation(locationDetails: PreviousWorkLocation) {
        dao.insertNewWorkLocationSpot(locationDetails.topreviousWorkSpotEntity())
    }

    override suspend fun deletePreviousWorkLocation(location: PreviousWorkLocation) {
        dao.deletePreviousWorkLocation(location.topreviousWorkSpotEntity())
    }

    override suspend fun getAllPreviousLocation(): Flow<List<PreviousWorkLocation>> {
        return dao.getAllPreviousWorkLocation().map { listofpreviousworkentity ->

            listofpreviousworkentity.map {
                it.toWorkSpot()
            }
        }
    }
}
