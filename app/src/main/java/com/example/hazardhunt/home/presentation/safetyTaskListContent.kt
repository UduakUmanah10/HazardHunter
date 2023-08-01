// ktlint-disable filename
package com.example.hazardhunt.home.presentation

import android.content.res.Configuration
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hazardhunt.core.loadingScreen
import com.example.hazardhunt.home.data.model.SafetyTasks
import com.example.hazardhunt.ui.theme.HazardHuntTheme

@Composable
fun TaskListContent(
    modifier: Modifier = Modifier,
    viewState: SafetyListViewState,
    onclick: (SafetyTasks) -> Unit,
    onReschedule: (SafetyTasks) -> Unit,
    onAddButtonClicked: () -> Unit,
    navigationClicked: () -> Unit
) {
    Surface {
        if (viewState is SafetyListViewState.loaded) {
            LoadedTask(
                viewState,
                onAddButtonClicked,
                onReschedule,
                onclick,
                navigationClicked =navigationClicked

            )
        }

        if (viewState is SafetyListViewState.loading) {
            loadingScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LoadedTask(
    viewState: SafetyListViewState.loaded,
    onAddButtonClicked: () -> Unit,
    onReschedule: (SafetyTasks) -> Unit,
    onclick: (SafetyTasks) -> Unit,
    navigationClicked : ()->Unit
) {
    safetyTaskList(
        modifier = Modifier,
        tasks = viewState.tasks,
        onRescheduleClicked = onReschedule,
        onDoneClicked = onclick,
        navigationClicked =navigationClicked
    )
}

@Preview(
    name = "Day mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Day mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
fun taskPreview() {
    val tasks = (0..10).map { num ->
        SafetyTasks("Task no $num")
    }
    HazardHuntTheme {
        TaskListContent(
            viewState = SafetyListViewState.loaded(tasks = tasks),
            onclick = {},
            onReschedule = {},
            onAddButtonClicked = {},
            navigationClicked = {}
        )
    }
}
