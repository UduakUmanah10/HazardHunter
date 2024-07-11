package com.hazardhunt.safebuddy.onboarding.dependencyInjection

import com.hazardhunt.safebuddy.onboarding.data.OnboardingEventManagerImpl
import com.hazardhunt.safebuddy.onboarding.domain.reposirory.OnboardingEventManager
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
