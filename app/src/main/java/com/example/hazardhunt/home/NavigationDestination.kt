// ktlint-disable filename
package com.example.hazardhunt.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hazardhunt.R

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

@Composable
fun HomeScreen(destinations: ArrayList<NavigationDestination> = NavigationDestinationItems) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            val backStackEntry by navController.currentBackStackEntryAsState()
            var showBottomBar by rememberSaveable { mutableStateOf(true) }
            showBottomBar = when (backStackEntry?.destination?.route) {
                "settingscategory" -> true
                else -> true
            }

            if (showBottomBar) {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    tonalElevation = NavigationBarDefaults.Elevation,
                    windowInsets = NavigationBarDefaults.windowInsets,

                ) {
                    destinations.forEach { content ->

                        NavigationBarItem(
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
                    }
//
                }
                composable("TaskScreen") {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                    ) {
                        // TaskScreen(navController = navController)
                    }
                }
                composable("InsightScreen") {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                    ) {
                        // InsightsScreen(navController)
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
