package com.example.hazardhunt.home.domain.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hazardhunt.core.UIText
import com.example.hazardhunt.home.domain.usecase.GetTaskUseCase
import com.example.hazardhunt.home.presentation.SafetyListViewState
import com.example.hazardhunt.login.domain.util.CustomResults
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
/**
 * This class is responsible for managing and exposing the ui State of the
 * Safety Task screen
 * @param[getAllSafetyTasks]
 * **/
@HiltViewModel
class SafetyTaskViewmodel @Inject constructor(
    private val getAllSafetyTasks: GetTaskUseCase,
) : ViewModel() {

    private val _viewState: MutableStateFlow<SafetyListViewState> = MutableStateFlow(SafetyListViewState.loading)

    val viewState: StateFlow<SafetyListViewState> = _viewState

    init {
        viewModelScope.launch {
            val getSafetyTaskResults = getAllSafetyTasks()

            _viewState.value = when (getSafetyTaskResults) {
                is CustomResults.Success -> {
                    SafetyListViewState.loaded(
                        tasks = getSafetyTaskResults.data,
                    )
                }

                is CustomResults.Error -> {
                    SafetyListViewState.Error(UIText.StringText("error loading"))
                }
            }
        }
    }
}
