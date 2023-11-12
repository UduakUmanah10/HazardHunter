package com.example.hazardhunt.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hazardhunt.core.UIText
import com.example.hazardhunt.home.data.model.SafetyTasks
import com.example.hazardhunt.home.domain.usecase.GetTaskUseCase
import com.example.hazardhunt.login.domain.util.CustomResults
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
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
            getAllSafetyTasks()
                .collectLatest {
                    _viewState.value = getViewStateForTaskListResult(it)
                    Timber.tag("gig").d("flow triggered")
                }
        }
    }

    private fun getViewStateForTaskListResult(result: CustomResults<List<SafetyTasks>>): SafetyListViewState {
        return when (result) {
            is CustomResults.Success -> {
                SafetyListViewState.loaded(
                    tasks = result.data,
                )
            }

            is CustomResults.Error -> {
                SafetyListViewState.Error(
                    errorMessage = UIText.StringText("something is wrong"),
                )
            }
        }
    }
}
