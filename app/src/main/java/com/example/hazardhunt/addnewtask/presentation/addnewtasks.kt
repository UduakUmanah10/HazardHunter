package com.example.hazardhunt.addnewtask.presentation

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hazardhunt.R
import com.example.hazardhunt.core.CustomCenterTopAppbar
import com.example.hazardhunt.core.PrimaryButton
import com.example.hazardhunt.ui.theme.HazardHuntTheme

@Composable
fun AddNewTasksScreen() {
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
            textfieldlabel = "Task Title",
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
            numberofLines = 1,

            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 17.dp, end = 17.dp),
        )
        DateAndTime()

        MultipleSurfaceWithICons()

        SimpleOutlinedTextFieldSample(
            numberofLines = 5,
            textfieldlabel = "Task Description",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 17.dp, end = 17.dp, bottom = 20.dp),
        )
        SubmitTask(submitTaskButtonClicked = {})
    }
}

@Composable
fun MultipleSurfaceWithICons(){

    Row(
        modifier = Modifier.padding(15.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Text(

            "Task Category :",
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.weight(1.5f),

        )
        Row(modifier = Modifier.fillMaxWidth().weight(1.5f)) {
            for (circulraSurface in 1..3){
                CategorySurface(
                    icon = R.drawable.time,
                    color = MaterialTheme.colorScheme.inversePrimary
                )
            }
        }

    }

}

@Composable
fun CategorySurface(
    @DrawableRes icon:Int,
    color:Color


){
    Surface(
        modifier =Modifier
            .padding(4.dp)
            .width(50.dp)
            .height(50.dp)
            .clip(CircleShape),

        color = color
    ){

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
        Icon(
            painter = painterResource(icon),
            contentDescription = stringResource(R.string.Password),
            tint = MaterialTheme.colorScheme.error,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.Icon_height))
                .clickable { },
        )
        }

    }

}

@Composable
fun SimpleOutlinedTextFieldSample(
    modifier: Modifier,
    textfieldlabel: String,
    numberofLines:Int,
    trailingIcon: (@Composable () -> Unit)? = null,
) {
    var text by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        modifier = modifier,
        value = text,
        minLines = numberofLines,
        onValueChange = { text = it },
        label = {
            Text(
                textfieldlabel,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.bodyLarge,
            )
        },

        trailingIcon = trailingIcon,

    )
}




@Composable
fun DateAndTime() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(10.dp),
    ){
        SimpleOutlinedTextFieldSample(
            textfieldlabel = "Date",
            trailingIcon = {
                Icon(
                painter = painterResource(id = R.drawable.date),
                contentDescription = stringResource(R.string.Password),
                tint = MaterialTheme.colorScheme.secondaryContainer,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.Icon_height))
                    .clickable { },
            )},
            numberofLines = 1,
            modifier = Modifier.weight(1f).padding(10.dp)
        )
        SimpleOutlinedTextFieldSample(
            textfieldlabel = "Time",
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.time),
                    contentDescription = stringResource(R.string.Password),
                    tint = MaterialTheme.colorScheme.secondaryContainer,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.Icon_height))
                        .clickable { },
                )},
            numberofLines = 1,
            modifier = Modifier.weight(1f).padding(10.dp)
        )
    }
}

@Composable
fun SubmitTask(submitTaskButtonClicked:()->Unit){
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
