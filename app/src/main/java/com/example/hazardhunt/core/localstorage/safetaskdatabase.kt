// ktlint-disable filename
package com.example.hazardhunt.core.localstorage

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(
    entities = [Persistedsafetytask::class],
    version = 3,
    exportSchema = false,
)
abstract class Safetaskdatabase : RoomDatabase() {

    abstract fun taskDao(): Safetaskdao
}
