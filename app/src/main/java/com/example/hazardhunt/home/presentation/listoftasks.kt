// ktlint-disable filename
package com.example.hazardhunt.home.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hazardhunt.home.model.SafetyTasks
import com.example.hazardhunt.ui.theme.HazardHuntTheme

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
            TaskText()
            RowButton(
                done = onDoneSelectedClicked,
                reschedule = onRescheduleClicked,

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
    TextButton(onClick = recschdule) {
        Text(text = "Reschedule")
    }
}

@Composable
private fun DoneButton(done: () -> Unit) {
    TextButton(onClick = done) {
        Text(text = "finish")
    }
}

@Composable
private fun TaskText() {
    Text(
        modifier =
        Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        text = " clean my ui",
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
    HazardHuntTheme {
        ListofTasksItem(task = SafetyTasks(""))
    }
}
