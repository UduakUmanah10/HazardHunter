// ktlint-disable filename
package com.hazardhunt.safebuddy.addnewtask.presentation

import android.content.res.Configuration
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties
import com.example.core.view.theme.SafeBuddyTheme
import com.maxkeppeker.sheets.core.models.base.UseCaseState
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.clock.ClockDialog
import com.maxkeppeler.sheets.clock.models.ClockConfig
import com.maxkeppeler.sheets.clock.models.ClockSelection
import java.time.LocalTime
/**
 * this is a composable function that is responsible for displaying the time picker dialog using the
 * @author[maxkeppeler] library.
 * @see(https://maxkeppeler.notion.site/Sheets-Compose-Dialogs-804f0ebcb2c84b98b7afa5f687295aed) .
 * it has three parameters:
 * @param[is24hoursClock] -> responsible for switching the clock  format to 24 or 12 hours format.
 * @param[showTimePicker] -> this is responsible for displaying and hiding the time picker dialog.
 * @param[onTimeSelected] -> thi is a lambda the=at is responsible for exposing the selected time
 * to components that require it.
 *
 * */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun timePicker(
    is24hoursClock: Boolean,
    showTimePicker: Boolean,
    closeTimeSelection: UseCaseState.() -> Unit,
    onTimeSelected: (LocalTime) -> Unit,

) {
    val selectedTime = remember { mutableStateOf<LocalTime>(LocalTime.now()) }

    ClockDialog(

        state = rememberUseCaseState(visible = showTimePicker, onCloseRequest = { closeTimeSelection() }),

        selection = ClockSelection.HoursMinutesSeconds { hours, minutes, seconds ->
            selectedTime.value = LocalTime.of(hours, minutes, seconds)
            onTimeSelected(LocalTime.of(hours, minutes, seconds))
        },

        config = ClockConfig(
            is24HourFormat = is24hoursClock,
        ),

        properties = DialogProperties(),

        // header = Header.Custom() //

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
fun TimePicker() {
    SafeBuddyTheme {
        timePicker(true, true, closeTimeSelection = {}) {
            it.formatToDayAndNight()
        }
    }
}
