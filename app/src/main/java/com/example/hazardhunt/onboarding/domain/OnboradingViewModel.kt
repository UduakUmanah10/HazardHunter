package com.example.hazardhunt.onboarding.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hazardhunt.onboarding.data.OnBoardingRepository
import com.example.hazardhunt.onboarding.data.OnboardingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboradingViewModel @Inject constructor(private val repository: OnBoardingRepository) : ViewModel() {

    fun saveOnBoardingState(completed: OnboardingState) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveOnBoardingState(onboardingState = completed)
        }
    }
}
