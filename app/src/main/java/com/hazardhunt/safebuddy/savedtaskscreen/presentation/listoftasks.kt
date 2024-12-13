// ktlint-disable filename
package com.hazardhunt.safebuddy.savedtaskscreen.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.view.theme.SafeBuddyTheme
import com.hazardhunt.safebuddy.R
import com.hazardhunt.safebuddy.savedtaskscreen.data.model.SafetyTasks

@Composable
fun ListofTasksItem(
    task: SafetyTasks,
    onDoneSelectedClicked: () -> Unit = {},
    onRescheduleClicked: () -> Unit = {},

) {
    Card {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.End,

        ) {
            TaskText(task.taskTitle)
            RowButton(
                done = { onDoneSelectedClicked() },
                reschedule = { onRescheduleClicked() },

            )
        }
    }
}

@Composable
private fun RowButton(done: () -> Unit, reschedule: () -> Unit) {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Reschedule(reschedule)
        DoneButton(done)
    }
}

@Composable
private fun Reschedule(recschdule: () -> Unit) {
    DefaultTextButton(
        text = stringResource(id = R.string.Reschedue),
        onClick = recschdule,
    )
}

@Composable
private fun DoneButton(done: () -> Unit) {
    DefaultTextButton(
        text = stringResource(id = R.string.done),
        onClick = done,
    )
}

@Composable
private fun TaskText(text: String) {
    Text(
        modifier =
        Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        text = text,
    )
}

@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Day mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
fun SignupPreview() {
    SafeBuddyTheme {
        ListofTasksItem(task = SafetyTasks(""))
    }
}
