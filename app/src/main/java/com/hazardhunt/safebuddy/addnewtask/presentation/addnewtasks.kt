// ktlint-disable filename
package com.hazardhunt.safebuddy.addnewtask.presentation

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.core.view.theme.SafeBuddyTheme
import com.hazardhunt.safebuddy.R
import com.hazardhunt.safebuddy.addnewtask.data.model.TaskinputModel
import com.hazardhunt.safebuddy.core.CustomCenterTopAppbar
import com.hazardhunt.safebuddy.core.PrimaryButton
import com.hazardhunt.safebuddy.core.UIText
import com.maxkeppeker.sheets.core.models.base.UseCaseState
import java.time.LocalDate

typealias textWeight = Float
typealias Loop = Int
const val TEXTFIELDWEIGHT: textWeight = 1.5f
const val START: Loop = 1
const val END: Loop = 3

@Composable
fun AddNewTasksScreen(
    vm: AddNewTaskVieModel = hiltViewModel(),
    navController: NavController,
) {
    val viewState: Addtaskviewstate = vm.viewState.collectAsState().value
    val showtimeDialog = vm.showtimeIcon.collectAsState()
    val showDateDialog = vm.showDatePicker.collectAsState()

    LaunchedEffect(viewState) {
        if (viewState is Addtaskviewstate.Successful) {
            navController.navigate("TaskScreen")
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        CustomCenterTopAppbar(
            titleContentColor = Color.White,
            scrollContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            containerColor = MaterialTheme.colorScheme.outline,
            title = "Add new Task",
            navigationIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.chevronleft),
                    contentDescription = stringResource(R.string.Password),
                    tint = MaterialTheme.colorScheme.secondaryContainer,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.centerBarIcon)),
                )
            },

            onNavigationIconClicked = { /*TODO*/ },
            actionIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = stringResource(R.string.Password),
                    tint = MaterialTheme.colorScheme.secondaryContainer,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.centerBarIcon))
                        .clickable { },
                )
            },
            actionIconAction = {},

        )

        SimpleOutlinedTextFieldSample(
            onvalueChanged = { vm.ontaskTitleChanged(it) }, // complete tomorroe ,
            textContent = viewState.taskInput.taskTitle,
            textFieldLabel = "Task Title",
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.cancel),
                    contentDescription = stringResource(R.string.Password),
                    tint = MaterialTheme.colorScheme.secondaryContainer,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.Icon_height))
                        .clickable { vm.onTaskTitleCleared() },
                )
            },
            numberOfLines = 1,

            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 17.dp, end = 17.dp),
        )

        val calnel = UseCaseState()

        dateandTime(vm, showtimeDialog, showDateDialog, viewState, calnel)

        MultipleSurfaceWithICons()

        SimpleOutlinedTextFieldSample(
            enableTextField = viewState.inputEnabled,
            textContent = viewState.taskInput.description,
            numberOfLines = 5,
            textFieldLabel = "Task Description",
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 10.dp,
                    start = 17.dp,
                    end = 17.dp,
                    bottom = 20.dp,
                ),
            onvalueChanged = { vm.onTaskDescriptionChanged(it) }, // complete tomorrow
        )
        SubmitTask(submitTaskButtonClicked = { vm.onSubmitButtonClicked() })
        Text(text = "")
    }
}

@Composable
private fun dateandTime(
    vm: AddNewTaskVieModel,
    showtimeDialog: State<Boolean>,
    showDateDialog: State<Boolean>,
    viewState: Addtaskviewstate,
    calnel: UseCaseState,
) {
    DateAndTime(
        onDateIconClicked = vm::shouldShowDatePicker,
        onTimeIconClicked = vm::onTimeIconClicked,
        shouldShowTimeDialog = showtimeDialog.value,
        shouldShowDateDialog = showDateDialog.value,
        onTimeSelected = vm::onTimeSelected,
        currentSelectedDate = vm::onDateSelected,
        onDateValueChanged = {}, // complete tomorrem ,
        onTimeValueChanged = {}, // complete tomorrow,
        dateTextFieldContent = viewState.taskInput.scheduledDate, // date.value,
        timeTextFieldContent = viewState.taskInput.scheduledTime, // time.value,

        dismissDatePicker = {
            calnel.hide()
            vm.shouldShowDatePicker()
        },

        dismissTimePicker = {
            calnel.hide()
            vm.onTimeIconClicked()
        },

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

class AddTaskViewStateProvider : PreviewParameterProvider<Addtaskviewstate> {

    override val values: Sequence<Addtaskviewstate> get() {
        val activeInput = TaskinputModel(
            "Measure weather",
            scheduledDate = LocalDate.now().touiString(),

        )

        return sequenceOf(
            Addtaskviewstate.InitialState,
            Addtaskviewstate.ActiveState(activeInput),
            Addtaskviewstate.SubmittingState(taskInput = activeInput),
            Addtaskviewstate.SubmittingErrorState(
                taskInput = activeInput,
                errorMessage = UIText.StringText("Error Message"),
            ),
            Addtaskviewstate.Successful,
        )
    }
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
fun NewTaskPage(
    @PreviewParameter(AddTaskViewStateProvider::class)
    addtaskviewstate: Addtaskviewstate,
) {
    val vm: AddNewTaskVieModel = hiltViewModel()
    SafeBuddyTheme {
        // AddNewTasksScreen(
        //   vm)
    }
}
