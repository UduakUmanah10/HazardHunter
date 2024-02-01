// ktlint-disable filename
package com.example.hazardhunt.savedtaskscreen.presentation

import com.example.hazardhunt.core.UIText
import com.example.hazardhunt.savedtaskscreen.data.model.SafetyTasks

sealed class SafetyListViewState {

    object loading : SafetyListViewState()

    data class loaded(
        val tasks: List<SafetyTasks>,
    ) : SafetyListViewState()

    data class Error(
        val errorMessage: UIText,
    ) : SafetyListViewState()
}
