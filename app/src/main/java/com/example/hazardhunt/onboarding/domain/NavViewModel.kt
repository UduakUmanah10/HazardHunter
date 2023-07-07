package com.example.hazardhunt.onboarding.domain

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hazardhunt.onboarding.data.OnBoardingRepository
import com.example.hazardhunt.onboarding.data.OnboardingState
import com.example.hazardhunt.onboarding.presentation.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class NavViewModel
@Inject constructor(
    private val repository: OnBoardingRepository,
) : ViewModel() {
    private val _isLoading = MutableStateFlow<Boolean>(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _startDestination: MutableState<String> = mutableStateOf(Screen.onboardingScreen.route)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect { completed ->
                println(completed)
                if (completed.completed == OnboardingState.COMPLETED) {
                    _startDestination.value = Screen.welcomeScreen.route
                } else {
                    _startDestination.value = Screen.onboardingScreen.route
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
