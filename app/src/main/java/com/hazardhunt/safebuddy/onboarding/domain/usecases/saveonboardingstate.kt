// ktlint-disable filename
package com.hazardhunt.safebuddy.onboarding.domain.usecases

import com.hazardhunt.safebuddy.onboarding.domain.reposirory.OnboardingEventManager

class SaveOnBoardingState(
    private val localUserManager: OnboardingEventManager,
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntryState()
    }
}
