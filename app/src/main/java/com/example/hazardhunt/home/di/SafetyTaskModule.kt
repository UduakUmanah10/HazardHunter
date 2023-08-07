package com.example.hazardhunt.home.di

import com.example.hazardhunt.home.domain.repository.DemoSafetyTaskRepository
import com.example.hazardhunt.home.domain.repository.SafetyTaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SafetyTaskModule {

    @Binds
    abstract fun safetyTaskRepository(safetyTaskUseCase: DemoSafetyTaskRepository): SafetyTaskRepository
}
