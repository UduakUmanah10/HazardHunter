package com.example.hazardhunt.home.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hazardhunt.R
import com.example.hazardhunt.core.CustomCenterTopAppbar
import com.example.hazardhunt.home.data.model.SafetyTasks
import com.example.hazardhunt.ui.theme.HazardHuntTheme

@Composable
fun safetyTaskList(
    modifier: Modifier = Modifier,
    tasks: List<SafetyTasks>,
    onRescheduleClicked: (SafetyTasks) -> Unit,
    onDoneClicked: (SafetyTasks) -> Unit,
    navigationClicked: () -> Unit,
    onAddNewTaskClicked: () -> Unit,

) {
    Box {
        Column {
            CustomCenterTopAppbar(
                titleContentColor = MaterialTheme.colorScheme.onSecondary,
                containerColor = MaterialTheme.colorScheme.outline,
                scrollContainerColor = MaterialTheme.colorScheme.error,
                title = "Task List",
                // navIcon = R.drawable.mail,
                onNavigationIconClicked = navigationClicked,
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.chevronleft),
                        contentDescription = stringResource(R.string.Password),
                        tint = MaterialTheme.colorScheme.secondaryContainer,
                        modifier = Modifier.size(dimensionResource(id = R.dimen.centerBarIcon)),
                    )
                },
                actionIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.segment),
                        contentDescription = stringResource(R.string.Password),
                        tint = MaterialTheme.colorScheme.secondaryContainer,
                        modifier = Modifier.size(dimensionResource(id = R.dimen.centerBarIcon)),
                    )
                },
                actionIconAction = {},
            )

            LazyColumn(
                contentPadding = PaddingValues(20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                items(tasks) { safetytask ->

                    ListofTasksItem(
                        task = safetytask,
                        onDoneSelectedClicked = { onDoneClicked(safetytask) },
                        onRescheduleClicked = { onRescheduleClicked(safetytask) },
                    )
                }
            }
        }
        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd).padding(end = 20.dp, bottom = 20.dp),
            onClick = onAddNewTaskClicked,
        ) {
            Icon(Icons.Filled.Add, "Localized description")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun centerAppbar() {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                "Centered TopAppBar",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        navigationIcon = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Localized description",
                )
            }
        },
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                )
            }
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
    val tasks = (0..10).map { num ->
        SafetyTasks("Task no $num")
    }
    HazardHuntTheme {
        safetyTaskList(
            tasks = tasks,
            onRescheduleClicked = {},
            onDoneClicked = {},
            navigationClicked = {},
            onAddNewTaskClicked = {},
        )
    }
}
