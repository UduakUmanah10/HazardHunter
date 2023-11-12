// ktlint-disable filename
package com.example.hazardhunt.home.presentation

import android.content.res.Configuration
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection.Companion.Left
import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection.Companion.Right
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hazardhunt.core.loadingScreen
import com.example.hazardhunt.home.data.model.SafetyTasks
import com.example.hazardhunt.ui.theme.HazardHuntTheme

typealias TWIN = Int
const val TWEEN_VALUE = 450

@Composable
fun TaskListContent(
    modifier: Modifier = Modifier,
    viewState: SafetyListViewState,
    onclick: (SafetyTasks) -> Unit,
    onReschedule: (SafetyTasks) -> Unit,
    onAddButtonClicked: () -> Unit,
    navigationClicked: () -> Unit,
) {
//    AnimatedContent(
//        targetState = viewState,
//        label = "",
//        transitionSpec = {
//            slideIntoContainer(
//                animationSpec = tween(TWEEN_VALUE, easing = EaseIn),
//                towards = Right,
//            ).togetherWith(
//                slideOutOfContainer(
//                    animationSpec = tween(TWEEN_VALUE, easing = EaseOut),
//                    towards = Left,
//                ),
//            )
//        },
//    ) { targetState ->
        when (viewState) {
            is SafetyListViewState.loaded -> LoadedTask(
                viewState,
                onAddButtonClicked,
                onReschedule,
                onclick,
                navigationClicked = navigationClicked,
            )
            is SafetyListViewState.loading -> loadingScreen()
            else -> {}
        }
//    }
}

@Composable
private fun LoadedTask(
    viewState: SafetyListViewState.loaded,
    onAddButtonClicked: () -> Unit,
    onReschedule: (SafetyTasks) -> Unit,
    onclick: (SafetyTasks) -> Unit,
    navigationClicked: () -> Unit,
) {
    safetyTaskList(
        modifier = Modifier,
        tasks = viewState.tasks,
        onRescheduleClicked = onReschedule,
        onDoneClicked = onclick,
        navigationClicked = navigationClicked,
        onAddNewTaskClicked = onAddButtonClicked,
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
fun TaskPreview() {
    val tasks = (0..10).map { num ->
        SafetyTasks("Task no $num")
    }
    HazardHuntTheme {
        TaskListContent(
            viewState = SafetyListViewState.loaded(tasks = tasks),
            onclick = {},
            onReschedule = {},
            onAddButtonClicked = {},
            navigationClicked = {},
        )
    }
}
