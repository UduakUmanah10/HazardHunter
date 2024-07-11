// ktlint-disable filename
package com.hazardhunt.safebuddy.savedtaskscreen.presentation

import com.hazardhunt.safebuddy.core.UIText
import com.hazardhunt.safebuddy.savedtaskscreen.data.model.SafetyTasks

sealed class SafetyListViewState {

    object loading : SafetyListViewState()

    data class loaded(
        val tasks: List<SafetyTasks>,
    ) : SafetyListViewState()

    data class Error(
        val errorMessage: UIText,
    ) : SafetyListViewState()
}
