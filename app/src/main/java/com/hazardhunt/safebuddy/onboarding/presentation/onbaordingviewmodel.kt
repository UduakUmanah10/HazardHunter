// ktlint-disable filename
package com.hazardhunt.safebuddy.onboarding.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hazardhunt.safebuddy.onboarding.data.model.OnBoardingUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val onBoardingUseCases: OnBoardingUseCases,
) : ViewModel() {

    fun onEvent(event: OnBoardingScreenEvent) {
        when (event) {
            is OnBoardingScreenEvent.SaveOnBoardingState -> {
                saveOnboardingState()
            }
        }
    }

    private fun saveOnboardingState() {
        viewModelScope.launch(Dispatchers.IO) {
            onBoardingUseCases.saveOnBoardingState()
        }
    }
}
