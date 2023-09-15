// ktlint-disable filename
package com.example.hazardhunt.tasklocationhistory.di

import android.app.Application
import androidx.room.Room
import com.example.hazardhunt.tasklocationhistory.data.PreviousWorkLocationDataBase
import com.example.hazardhunt.tasklocationhistory.data.PreviousWorkRepositoryImplementation
import com.example.hazardhunt.tasklocationhistory.domain.repository.PreviousWorkLocationRepository
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
