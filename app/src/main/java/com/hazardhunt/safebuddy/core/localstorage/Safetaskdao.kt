package com.hazardhunt.safebuddy.core.localstorage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Safetaskdao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Persistedsafetytask)

    @Query("SELECT * FROM safetasks")
    fun fetchallTasks(): Flow<List<Persistedsafetytask>>
}
