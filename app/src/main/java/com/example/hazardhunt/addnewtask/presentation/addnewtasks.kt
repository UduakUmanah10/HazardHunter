// ktlint-disable filename
package com.example.hazardhunt.addnewtask.presentation

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hazardhunt.R
import com.example.hazardhunt.core.CustomCenterTopAppbar
import com.example.hazardhunt.core.PrimaryButton
import com.example.hazardhunt.ui.theme.HazardHuntTheme
import com.maxkeppeker.sheets.core.models.base.UseCaseState

typealias textWeight = Float
typealias Loop =Int
const val TEXTFIELDWEIGHT: textWeight = 1.5f
const val START:Loop =1
const val END:Loop =3
@Composable
fun AddNewTasksScreen(vm: Addnewtaskviewmodel = hiltViewModel()) {
    val showdialog = vm.showDatePicker.collectAsState()
    Column(modifier = Modifier.fillMaxSize()) {
        CustomCenterTopAppbar(
            titleContentColor = Color.White,
            scrollContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            containerColor = MaterialTheme.colorScheme.secondary,
            title = "Add new Task",
            navigationIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.chevronleft),
                    contentDescription = stringResource(R.string.Password),
                    tint = MaterialTheme.colorScheme.secondaryContainer,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.Icon_height)),
                )
            },

            onNavigationIconClicked = { /*TODO*/ },
            actionIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = stringResource(R.string.Password),
                    tint = MaterialTheme.colorScheme.secondaryContainer,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.Icon_height))
                        .clickable { },
                )
            },
            actionIconAction = {},

        )

        SimpleOutlinedTextFieldSample(
            onvalueChanged = {}, // complete tomorroe ,
            textContent = "",
            textFieldLabel = "Task Title",
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.cancel),
                    contentDescription = stringResource(R.string.Password),
                    tint = MaterialTheme.colorScheme.secondaryContainer,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.Icon_height))
                        .clickable { },
                )
            },
            numberOfLines = 1,

            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 17.dp, end = 17.dp),
        )

        val calnel = UseCaseState()

        DateAndTime(
            onDateValueChanged = {}, // complete tomorrem ,
            onTimeValueChanged = {}, // complete tomorrow,
            dateTextFieldContent = "${vm.currentDate.value}",
            timeTextFieldContent = "",
            shouldShowDialog = showdialog.value,
            dismissDatePicker = {
                calnel.hide()
                vm.shouldShowDatePicker()
            },
            showDatePicker = { vm.shouldShowDatePicker() },
            currentSelectedDate = vm::onDateValueChanged,
        )

        MultipleSurfaceWithICons()

        SimpleOutlinedTextFieldSample(

            "",
            numberOfLines = 5,
            textFieldLabel = "Task Description",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 17.dp, end = 17.dp, bottom = 20.dp),
            onvalueChanged = {}, // complete tomorrow
        )
        SubmitTask(submitTaskButtonClicked = { vm.shouldShowDatePicker() })
        Text(text = "")
    }
}

@Composable
fun MultipleSurfaceWithICons() {
    Row(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Text(

            "Task Category :",
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.weight(TEXTFIELDWEIGHT),

        )
        Row(
            modifier = Modifier
                .fillMaxWidth() // 1.5f
                .weight(TEXTFIELDWEIGHT),
        ) {
            for (circulraSurface in START..END) {
                CategorySurface(
                    icon = R.drawable.time,
                    color = MaterialTheme.colorScheme.inversePrimary,
                )
            }
        }
    }
}

@Composable
fun SimpleOutlinedTextFieldSample(
    textContent: String,
    modifier: Modifier,
    textFieldLabel: String,
    numberOfLines: Int,
    onvalueChanged: (String) -> Unit,
    trailingIcon: (@Composable () -> Unit)? = null,
) {
    OutlinedTextField(

        modifier = modifier,
        value = textContent,
        onValueChange = onvalueChanged,
        minLines = numberOfLines,

        label = {
            Text(
                textFieldLabel,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.bodySmall,
            )
        },

        trailingIcon = trailingIcon,
        singleLine = false,
        textStyle = MaterialTheme.typography.bodySmall,

    )
}

@Composable
fun SubmitTask(submitTaskButtonClicked: () -> Unit) {
    PrimaryButton(
        modifier = Modifier.padding(15.dp),
        text = stringResource(id = R.string.submit_Task),
        onclick = submitTaskButtonClicked,
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
fun NewTaskPage() {
    HazardHuntTheme {
        AddNewTasksScreen()
    }
}
