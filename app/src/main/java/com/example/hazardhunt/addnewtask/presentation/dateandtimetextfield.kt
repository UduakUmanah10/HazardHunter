// ktlint-disable filename
package com.example.hazardhunt.addnewtask.presentation

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
import com.example.hazardhunt.R
import com.maxkeppeker.sheets.core.models.base.UseCaseState

@Composable
fun DateAndTime(
    dateTextFieldContent: String,
    timeTextFieldContent: String,
    shouldShowDialog: Boolean,
    onDateValueChanged: (String) -> Unit,
    onTimeValueChanged: (String) -> Unit,
    dismissDatePicker: UseCaseState.() -> Unit,
    showDatePicker: () -> Unit,
    currentSelectedDate: (String) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
    ) {
        if (shouldShowDialog) {
            CalendarDialog(
                showDialog = true,
                closeSelection = dismissDatePicker,
                currentSelectedDate = currentSelectedDate,
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
                        .clickable(onClick = showDatePicker),
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
                        .clickable { },
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
