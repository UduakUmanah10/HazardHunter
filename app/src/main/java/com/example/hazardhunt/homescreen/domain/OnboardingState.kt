package com.example.hazardhunt.homescreen.domain

import com.example.hazardhunt.onboarding.data.OnboardingSettings
import com.example.hazardhunt.onboarding.data.OnboardingState
import kotlinx.coroutines.flow.Flow

interface OnboardingState {

    suspend fun saveOnBoardingState(onboardingState: OnboardingState)

    suspend fun readOnBoardingState(): Flow<OnboardingSettings>
}
