package com.example.hazardhunt.savedtaskscreen.di
import com.example.hazardhunt.addnewtask.data.repository.RoomtasklistRepository
import com.example.hazardhunt.savedtaskscreen.domain.repository.SafetyTaskRepository
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
