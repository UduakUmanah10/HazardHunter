package com.hazardhunt.safebuddy.homescreen.data
import com.hazardhunt.safebuddy.onboarding.data.OnBoardingRepository
import com.hazardhunt.safebuddy.onboarding.data.OnboardingSettings
import com.hazardhunt.safebuddy.onboarding.data.OnboardingState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Onboardingrepository @Inject constructor(private val onboarding: OnBoardingRepository) :
    com.hazardhunt.safebuddy.homescreen.domain.OnboardingState {
    override suspend fun saveOnBoardingState(onboardingState: OnboardingState) {
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
