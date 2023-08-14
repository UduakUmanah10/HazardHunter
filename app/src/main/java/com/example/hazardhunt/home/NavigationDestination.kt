// ktlint-disable filename
package com.example.hazardhunt.home

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hazardhunt.R
import com.example.hazardhunt.home.presentation.SafetyTaskScreen
import com.example.hazardhunt.homescreen.presentation.HomeScreen
import com.example.hazardhunt.insight.presenatation.InsightsScreen
import com.example.hazardhunt.ui.theme.HazardHuntTheme

sealed class NavigationDestination(val name: String, @DrawableRes val icons: Int, val route: String) {

    object Home : NavigationDestination("Home ", icons = R.drawable.home, "HomeScreen")
    object Tasks : NavigationDestination("Tasks", icons = R.drawable.tasks, "TaskScreen")
    object Insights : NavigationDestination("Insights", icons = R.drawable.insights, "InsightScreen")
    object Settings : NavigationDestination("Settings", icons = R.drawable.settingsx, "SettingsScreen")
}

val NavigationDestinationItems = arrayListOf(
    NavigationDestination.Home,
    NavigationDestination.Tasks,
    NavigationDestination.Insights,
    NavigationDestination.Settings,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    destinations: ArrayList<NavigationDestination> = NavigationDestinationItems,
    onAddButtonClicked: () -> Unit,
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            val backStackEntry by navController.currentBackStackEntryAsState()
            var showBottomBar by rememberSaveable { mutableStateOf(true) }
            showBottomBar = when (backStackEntry?.destination?.route) {
                "TaskScreen" -> false
                "InsightScreen" -> false
                else -> true
            }

            AnimatedVisibility(
                showBottomBar,
                enter = expandVertically(expandFrom = Alignment.Top) { 20 },
                exit = shrinkVertically(
                    animationSpec = tween(1200),
                ) { fullHeight ->
                    fullHeight / 2
                },

            ) {
                NavigationBar(
                    modifier = Modifier,
                    windowInsets = NavigationBarDefaults.windowInsets,
                    tonalElevation = NavigationBarDefaults.Elevation,
                    containerColor = MaterialTheme.colorScheme.secondary,

                ) {
                    destinations.forEach { content ->

                        NavigationBarItem(
                            modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars),
                            selected = backStackEntry?.destination?.route == content.route,
                            onClick = { navController.navigate(content.route) },
                            label = {
                                Text(
                                    content.name,
                                    style = MaterialTheme.typography.bodySmall,
                                )
                            },
                            icon = {
                                Icon(
                                    painterResource(id = content.icons),
                                    contentDescription = content.name,
                                    Modifier.size(24.dp),
                                )
                            },
                        )
                    }

//
                }
            }
        },
        content = { innerPadding ->
            NavHost(navController = navController, startDestination = "HomeScreen") {
                composable("HomeScreen") {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),

                    ) {
                        // modulehomeScreen()
                        HomeScreen()
                    }
//
                }
                composable("TaskScreen") {
                    Surface(
                        modifier = Modifier.navigationBarsPadding(),
                    ) {
                        SafetyTaskScreen() {
                            navController.navigate("HomeScreen")
                        }
                    }
                }
                composable("InsightScreen") {
                    Surface(
                        modifier = Modifier,
                        color = MaterialTheme.colorScheme.onBackground,

                    ) {
                        InsightsScreen() {
                            navController.navigate("HomeScreen")
                        }
                        // viewchart()
                    }
                }
                composable("SettingsScreen") {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                    ) {
                        // SettingsScreen(navController = navController)
                    }
                }
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
fun SignupPreview() {
    HazardHuntTheme {
        HomeScreen(
            NavigationDestinationItems,
            {},
        )
    }
}



