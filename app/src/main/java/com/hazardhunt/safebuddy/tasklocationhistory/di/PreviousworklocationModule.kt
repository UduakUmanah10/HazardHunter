// ktlint-disable filename
package com.hazardhunt.safebuddy.tasklocationhistory.di

import android.app.Application
import androidx.room.Room
import com.hazardhunt.safebuddy.tasklocationhistory.data.PreviousWorkLocationDataBase
import com.hazardhunt.safebuddy.tasklocationhistory.data.PreviousWorkRepositoryImplementation
import com.hazardhunt.safebuddy.tasklocationhistory.domain.repository.PreviousWorkLocationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module()
@InstallIn(SingletonComponent::class)
object PreviousworklocationModule {

    @Provides
    @Singleton
    fun providePreviousWorkLocationDataBase(app: Application): PreviousWorkLocationDataBase {
        return Room.databaseBuilder(
            app,
            PreviousWorkLocationDataBase::class.java,
            "Previous_work_location_database",

        ).build()
    }

    @Singleton
    @Provides
    fun providePreviousWorkLocationRepository(db: PreviousWorkLocationDataBase): PreviousWorkLocationRepository {
        return PreviousWorkRepositoryImplementation(db.dao)
    }
}
