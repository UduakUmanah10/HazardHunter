package com.example.hazardhunt.savedtaskscreen.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SafetyTaskScreen(
    viewmodel: SafetyTaskViewmodel = hiltViewModel(),
    navigationClicked: () -> Unit,
    onAddnewTaskClicked: () -> Unit,
) {
    val viewstate = viewmodel.viewState.collectAsState()

    TaskListContent(
        viewState = viewstate.value,
        onclick = {},
        onReschedule = {},
        onAddButtonClicked = onAddnewTaskClicked,
        navigationClicked = navigationClicked,

    )
}
