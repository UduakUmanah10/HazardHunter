// ktlint-disable filename
package com.hazardhunt.safebuddy.addnewtask.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.hazardhunt.safebuddy.R
import com.maxkeppeker.sheets.core.models.base.UseCaseState
import java.time.LocalDate
import java.time.LocalTime

@Composable
fun DateAndTime(
    dateTextFieldContent: String,
    timeTextFieldContent: String,
    shouldShowDateDialog: Boolean,
    onTimeIconClicked: () -> Unit,
    shouldShowTimeDialog: Boolean,
    onTimeSelected: (LocalTime) -> Unit,
    onDateValueChanged: (String) -> Unit,
    onTimeValueChanged: (String) -> Unit,
    dismissDatePicker: UseCaseState.() -> Unit,
    dismissTimePicker: UseCaseState.() -> Unit,

    onDateIconClicked: () -> Unit,
    currentSelectedDate: (LocalDate) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
    ) {
        if (shouldShowDateDialog) {
            CalendarDialog(
                showDialog = true,
                closeSelection = dismissDatePicker,
                currentSelectedDate = currentSelectedDate,
            )
        }

        if (shouldShowTimeDialog) {
            timePicker(
                is24hoursClock = false,
                showTimePicker = true,
                closeTimeSelection = dismissTimePicker,
                onTimeSelected = onTimeSelected,

            )
        }

        SimpleOutlinedTextFieldSample(

            textContent = dateTextFieldContent,
            textFieldLabel = "Date",
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.date),
                    contentDescription = stringResource(R.string.Password),
                    tint = MaterialTheme.colorScheme.secondaryContainer,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.Icon_height))
                        .clickable(onClick = onDateIconClicked),
                )
            },
            numberOfLines = 1,
            onvalueChanged = onDateValueChanged,
            modifier = Modifier
                .weight(1f)
                .padding(10.dp),
        )

        SimpleOutlinedTextFieldSample(
            textContent = timeTextFieldContent,
            textFieldLabel = "Time",
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.time),
                    contentDescription = stringResource(R.string.Password),
                    tint = MaterialTheme.colorScheme.secondaryContainer,

                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.Icon_height))
                        .clickable(onClick = onTimeIconClicked),
                )
            },
            numberOfLines = 1,
            onvalueChanged = onTimeValueChanged,
            modifier = Modifier
                .weight(1f)
                .padding(10.dp),
        )
    }
}
