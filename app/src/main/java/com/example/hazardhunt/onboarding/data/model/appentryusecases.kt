// ktlint-disable filename
package com.example.hazardhunt.onboarding.data.model

import com.example.hazardhunt.onboarding.domain.usecases.ReadOnBoardingState
import com.example.hazardhunt.onboarding.domain.usecases.SaveOnBoardingState

data class OnBoardingUseCases(
    val readOnBoardingState: ReadOnBoardingState,
    val saveOnBoardingState: SaveOnBoardingState,

)
