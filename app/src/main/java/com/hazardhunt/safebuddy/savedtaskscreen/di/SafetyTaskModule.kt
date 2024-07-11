package com.hazardhunt.safebuddy.savedtaskscreen.di
import com.hazardhunt.safebuddy.addnewtask.data.repository.RoomtasklistRepository
import com.hazardhunt.safebuddy.savedtaskscreen.domain.repository.SafetyTaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SafetyTaskModule {

    @Binds
    @Singleton
    abstract fun safetyTaskRepository(safetyTaskUseCase: RoomtasklistRepository): SafetyTaskRepository
}
