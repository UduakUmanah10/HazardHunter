// ktlint-disable filename
package com.hazardhunt.safebuddy.tasklocationhistory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Objects are the main classes where you define your database interactions.
 * They can include a variety of query methods as specified by the user.
 * The class marked with @Dao should either be an interface or an abstract class.
 * At compile time, Room will generate an implementation of this class when it is referenced by a Database.
 **/
@Dao
interface PreviousWorkSpotDao {

    /**
     * this is an abstract function that is responsible for inserting  previous work location data into the data base.
     * it takes in @param[spotEntity].if you want to insert a parking spot with an id that already exist,
     * it would be replaced because of the OnConflictStrategy.Replace that is set in the Insert annotation
     * this function would return a flow and a flow is asynchronous by Default

     **/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewWorkLocationSpot(spotEntity: PreviousWorkSpotEntity)

    /**
     * this is an abstract function that is responsible for deleting
     * previously inserted work location data into the data base.
     * it takes in @param[spotEntity] and delete the corresponding entity

     **/

    @Delete
    suspend fun deletePreviousWorkLocation(spotEntity: PreviousWorkSpotEntity)

    /**
     * this is an abstract function that is responsible for querying the data base and
     * returning all previous Work Spot location in accordance with the query parameter
     * this function would return a flow and a flow is asynchronous by Default
     * hence there is no need for the suspend key word to get that flow
     **/

    @Query("SELECT * FROM previousworkspotentity ")
    fun getAllPreviousWorkLocation(): Flow<List<PreviousWorkSpotEntity>>
}
