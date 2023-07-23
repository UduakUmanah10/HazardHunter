// ktlint-disable filename
package com.example.hazardhunt.home.presentation

import com.example.hazardhunt.core.UIText
import com.example.hazardhunt.home.data.model.SafetyTasks

sealed class SafetyListViewState {

    object loading : SafetyListViewState()

    data class loaded(
        val tasks: List<SafetyTasks>,
    ) : SafetyListViewState()

    data class Error(
        val errorMessage: UIText,
    ) : SafetyListViewState()
}
