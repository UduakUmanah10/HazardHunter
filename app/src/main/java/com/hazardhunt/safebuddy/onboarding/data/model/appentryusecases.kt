// ktlint-disable filename
package com.hazardhunt.safebuddy.onboarding.data.model

import com.hazardhunt.safebuddy.onboarding.domain.usecases.ReadOnBoardingState
import com.hazardhunt.safebuddy.onboarding.domain.usecases.SaveOnBoardingState

data class OnBoardingUseCases(
    val readOnBoardingState: ReadOnBoardingState,
    val saveOnBoardingState: SaveOnBoardingState,

)
