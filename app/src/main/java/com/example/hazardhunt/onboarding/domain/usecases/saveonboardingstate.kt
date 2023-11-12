// ktlint-disable filename
package com.example.hazardhunt.onboarding.domain.usecases

import com.example.hazardhunt.onboarding.domain.reposirory.OnboardingEventManager

class SaveOnBoardingState(
    private val localUserManager: OnboardingEventManager,
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntryState()
    }
}
