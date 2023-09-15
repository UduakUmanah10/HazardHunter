// ktlint-disable filename
package com.example.hazardhunt.addnewtask.presentation

import android.content.res.Configuration
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.hazardhunt.ui.theme.HazardHuntTheme
import com.maxkeppeker.sheets.core.models.base.UseCaseState
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.calendar.models.CalendarStyle
import java.time.LocalDate

val usecase = UseCaseState()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarDialog(
    showDialog: Boolean,
    closeSelection: UseCaseState.() -> Unit,
    currentSelectedDate: (String) -> Unit,
) {
    val currentDate = LocalDate.now()

    val disableDates = (1 until currentDate.dayOfMonth).map { index ->
        LocalDate.now().minusDays(index.toLong())
    }
    CalendarDialog(
        state = rememberUseCaseState(visible = showDialog, onCloseRequest = { closeSelection() }),
        config = CalendarConfig(
            yearSelection = true,
            monthSelection = true,
            style = CalendarStyle.MONTH,
            disabledDates = disableDates,

        ),

        selection = CalendarSelection.Dates { newDates ->
            currentSelectedDate(newDates[0].touiString())
        },
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
fun LazyPreview() {
    HazardHuntTheme {
        Surface() {
            CalendarDialog(showDialog = true, {}, {})
        }
    }
}
