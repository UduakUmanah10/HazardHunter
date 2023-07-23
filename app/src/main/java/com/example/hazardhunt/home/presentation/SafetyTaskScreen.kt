package com.example.hazardhunt.home.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hazardhunt.home.domain.viewmodel.safetyTaskViewmodel

@Composable
fun SafetyTaskScreen(
    viewmodel: safetyTaskViewmodel = hiltViewModel(),
) {
    val viewstate = viewmodel.viewState.collectAsState()

    TaskListContent(
        viewState = viewstate.value,
        onclick = {},
        onReschedule = {},
        onAddButtonClicked = {},
    )
}
