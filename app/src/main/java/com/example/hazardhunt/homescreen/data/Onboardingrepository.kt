package com.example.hazardhunt.homescreen.data

import com.example.hazardhunt.onboarding.data.OnBoardingRepository
import com.example.hazardhunt.onboarding.data.OnboardingSettings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Onboardingrepository @Inject constructor(private val onboarding: OnBoardingRepository) :
    com.example.hazardhunt.homescreen.domain.OnboardingState {
    override suspend fun saveOnBoardingState(onboardingState: com.example.hazardhunt.onboarding.data.OnboardingState) {
        onboarding.saveOnBoardingState(onboardingState)
    }

    override suspend fun readOnBoardingState(): Flow<OnboardingSettings> {
        return onboarding.readOnBoardingState()
    }

    suspend fun chech() = flow<OnboardingSettings> {
        onboarding.readOnBoardingState()
            .flowOn(Dispatchers.IO)
            .collect {
                emit(it)
            }
    }
}
