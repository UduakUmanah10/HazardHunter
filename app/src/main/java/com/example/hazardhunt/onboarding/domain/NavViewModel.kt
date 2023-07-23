package com.example.hazardhunt.onboarding.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hazardhunt.homescreen.data.onboardingrepository
import com.example.hazardhunt.onboarding.data.OnBoardingRepository
import com.example.hazardhunt.onboarding.data.OnboardingState
import com.example.hazardhunt.onboarding.presentation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NavViewModel
@Inject constructor(
    private val repository: OnBoardingRepository,
    private val repository1: onboardingrepository,
) : ViewModel() {

    private val _isLoading = MutableStateFlow<Boolean>(true)
    val isLoading = _isLoading.asStateFlow()

    private val _isLoading1 = MutableStateFlow<OnboardingState>(OnboardingState.NOTCOMPLETED)
    val isLoading1 = _isLoading.asStateFlow()

    private val _startDestination: MutableStateFlow<String> = MutableStateFlow(Screen.onboardingScreen.route)
    val startDestination: StateFlow<String> = _startDestination

    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect { completed ->
                when (completed.completed) {
                    OnboardingState.COMPLETED -> {
                        _startDestination.value = Screen.welcomeScreen.route }
                    else -> { _startDestination.value = Screen.onboardingScreen.route }
                }
            }
            _isLoading.value = false
        }
    }
    fun saveOnBoardingState(completed: OnboardingState) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveOnBoardingState(onboardingState = completed)
        }
    }
}
