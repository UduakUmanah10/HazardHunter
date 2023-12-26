// ktlint-disable filename
package com.example.hazardhunt.onboarding.domain.usecases

import com.example.hazardhunt.onboarding.domain.reposirory.OnboardingEventManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadOnBoardingState @Inject constructor(
    private val localUserManager: OnboardingEventManager,
) {

    operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntryState()
    }
}
