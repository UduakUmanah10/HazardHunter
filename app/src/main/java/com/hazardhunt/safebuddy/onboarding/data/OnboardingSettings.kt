package com.hazardhunt.safebuddy.onboarding.data

import kotlinx.serialization.Serializable

@Serializable
data class OnboardingSettings(
    val completed: OnboardingState = OnboardingState.NOTCOMPLETED,
)

enum class OnboardingState {
    COMPLETED, NOTCOMPLETED
}
