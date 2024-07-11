// ktlint-disable filename
package com.hazardhunt.safebuddy.addnewtask.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hazardhunt.safebuddy.addnewtask.data.model.TaskinputModel
import com.hazardhunt.safebuddy.addnewtask.domain.usecase.ProdAddTaskUseCase
import com.hazardhunt.safebuddy.core.UIText
import com.hazardhunt.safebuddy.login.domain.util.CustomResults
import com.hazardhunt.safebuddy.savedtaskscreen.data.model.SafetyTasks
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class AddNewTaskVieModel @Inject constructor(
    private val addTaskUsecase: ProdAddTaskUseCase,
) : ViewModel() {

    private val _viewState = MutableStateFlow<Addtaskviewstate>(Addtaskviewstate.InitialState)
    val viewState = _viewState.asStateFlow()

    private val _localDate = MutableStateFlow(LocalDate.now().minusDays(1).touiString())
    val currentDate = _localDate.asStateFlow()

    private val _showtimeIcon = MutableStateFlow(false)
    val showtimeIcon = _showtimeIcon.asStateFlow()

    private val _showDatePicker = MutableStateFlow(false)
    val showDatePicker = _showDatePicker.asStateFlow()

    // private val _selectedtime = MutableStateFlow(LocalTime.now().formatToDayAndNight())
    // val selectedtime = _selectedtime.asStateFlow()

    fun onTimeIconClicked() {
        val currentState = _showtimeIcon.value
        _showtimeIcon.value = !currentState
    }

    fun onTimeSelected(currentTime: LocalTime) {
        val currentTaskInput = _viewState.value.taskInput

        val updatedTaskInput = currentTaskInput.copy(
            scheduledTime = currentTime.formatToDayAndNight(),
        )

        _viewState.value = Addtaskviewstate.ActiveState(
            taskInput = updatedTaskInput,
        )
    }
    fun ontaskTitleChanged(currentTaskContent: String) {
        val currentTaskInput = _viewState.value.taskInput

        val updatedTaskInput = currentTaskInput.copy(
            taskTitle = currentTaskContent,
        )

        _viewState.value = Addtaskviewstate.ActiveState(
            taskInput = updatedTaskInput,
        )
    }

    fun onTaskDescriptionChanged(currentTaskDescriptionContent: String) {
        val currentTaskInput = _viewState.value.taskInput

        val updatedTaskInput = currentTaskInput.copy(
            description = currentTaskDescriptionContent,
        )

        _viewState.value = Addtaskviewstate.ActiveState(
            taskInput = updatedTaskInput,
        )
    }
    fun onTaskTitleCleared() {
        val currentTaskInput = _viewState.value.taskInput
        val updatedTaskInput = currentTaskInput.copy(
            taskTitle = "",
        )

        _viewState.value = Addtaskviewstate.ActiveState(
            taskInput = updatedTaskInput,
        )
    }

    fun shouldShowDatePicker() {
        val toggleValue = _showDatePicker.value
        _showDatePicker.value = !toggleValue
    }

    fun onDateSelected(currentTime: LocalDate) {
        val currentTaskInput = _viewState.value.taskInput

        val updatedTaskInput = currentTaskInput.copy(
            scheduledDate = currentTime.touiString(),
        )

        _viewState.value = Addtaskviewstate.ActiveState(
            taskInput = updatedTaskInput,
        )
    }

    fun onSubmitButtonClicked() {
        val currentTastDetails = _viewState.value.taskInput.toEntity()

        viewModelScope.launch {
            val result = addTaskUsecase(currentTastDetails)

            _viewState.value = when (result) {
                is CustomResults.Success -> {
                    Addtaskviewstate.Successful
                }
                is CustomResults.Error -> {
                    Addtaskviewstate.SubmittingErrorState(
                        taskInput = _viewState.value.taskInput,
                        errorMessage = UIText.StringText("cannot add text"),
                    )
                }
            }
        }
    }
}

/**
 * this is an extension function that is responsible for
 * converting Local Date into day, Month and Year format
 */

fun LocalDate.touiString(): String {
    val formatter = DateTimeFormatter.ofPattern("MMM dd,yyyy")
    return formatter.format(this)
}

/**
 * this is an extension function that is responsible for
 * converting Local time into day and night format
 */
fun LocalTime.formatToDayAndNight(): String {
    val formatter = DateTimeFormatter.ofPattern("hh:mm a")
    return this.format(formatter)
}

fun TaskinputModel.toEntity(): SafetyTasks {
    return SafetyTasks(
        taskTitle = this.taskTitle,
        description = this.description,
        scheduledDate = this.scheduledDate,
        scheduledTime = this.scheduledTime,
    )
}
