package com.example.hazardhunt.homescreen.di

import com.example.hazardhunt.homescreen.data.Onboardingrepository
import com.example.hazardhunt.homescreen.domain.onboardingState
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SafetyTaskModule {

    @Binds
    abstract fun safetyTaskRepository(SafetyTaskUseCase: Onboardingrepository): onboardingState
}
