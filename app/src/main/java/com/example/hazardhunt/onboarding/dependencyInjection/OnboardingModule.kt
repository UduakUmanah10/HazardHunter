package com.example.hazardhunt.onboarding.dependencyInjection

import com.example.hazardhunt.onboarding.data.OnboardingEventManagerImpl
import com.example.hazardhunt.onboarding.domain.reposirory.OnboardingEventManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class OnboardingModule {

    @Binds
    abstract fun onboardingService(onboarding: OnboardingEventManagerImpl): OnboardingEventManager
}
