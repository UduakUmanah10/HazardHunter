// ktlint-disable filename
package com.example.hazardhunt.onboarding.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hazardhunt.onboarding.data.model.OnBoardingUseCases
import com.example.hazardhunt.onboarding.presentation.navgraph.NavigationRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

const val DELAY_TIME = 200L

@HiltViewModel
class MainViewModel @Inject constructor(
    private val readOnBoardingUseCases: OnBoardingUseCases,
) : ViewModel() {

    var splashscreenstate by mutableStateOf(true)
        private set

    var startdestination by mutableStateOf(NavigationRoutes.StartNavigation.routes)
        private set

    init {

        readOnBoardingUseCases.readOnBoardingState().onEach { shouldstartfromOnboardingScreen ->

            startdestination = if (!shouldstartfromOnboardingScreen) {
                NavigationRoutes.StartNavigation.routes
            } else {
                NavigationRoutes.LoginandSignup.routes
            }

            delay(DELAY_TIME)

            splashscreenstate = false
        }.launchIn(viewModelScope)
    }
}
