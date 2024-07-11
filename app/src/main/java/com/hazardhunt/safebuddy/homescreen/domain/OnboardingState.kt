package com.hazardhunt.safebuddy.homescreen.domain

import com.hazardhunt.safebuddy.onboarding.data.OnboardingSettings
import com.hazardhunt.safebuddy.onboarding.data.OnboardingState
import kotlinx.coroutines.flow.Flow

interface OnboardingState {

    suspend fun saveOnBoardingState(onboardingState: OnboardingState)

    suspend fun readOnBoardingState(): Flow<OnboardingSettings>
}
