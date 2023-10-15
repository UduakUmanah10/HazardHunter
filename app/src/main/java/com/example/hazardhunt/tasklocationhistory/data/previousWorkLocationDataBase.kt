// ktlint-disable filename
package com.example.hazardhunt.tasklocationhistory.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ PreviousWorkSpotEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class PreviousWorkLocationDataBase : RoomDatabase() {

    abstract val dao: PreviousWorkSpotDao
}
