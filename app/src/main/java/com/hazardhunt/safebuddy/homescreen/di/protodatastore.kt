// ktlint-disable filename
package com.hazardhunt.safebuddy.homescreen.di

import com.hazardhunt.safebuddy.homescreen.data.Onboardingrepository
import com.hazardhunt.safebuddy.homescreen.domain.OnboardingState
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SafetyTaskModule {

    @Binds
    abstract fun safetyTaskRepository(safetyTaskUseCase: Onboardingrepository): OnboardingState
}
