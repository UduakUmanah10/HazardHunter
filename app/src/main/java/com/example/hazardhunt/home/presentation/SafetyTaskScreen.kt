package com.example.hazardhunt.home.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hazardhunt.home.domain.viewmodel.SafetyTaskViewmodel

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
