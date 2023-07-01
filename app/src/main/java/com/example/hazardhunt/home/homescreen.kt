package com.example.hazardhunt.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import com.example.hazardhunter.homescreen.Homescreen

@Composable
fun HomeScreen() {
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
                    containerColor = NavigationBarDefaults.containerColor,
                    tonalElevation = NavigationBarDefaults.Elevation,
                    windowInsets = NavigationBarDefaults.windowInsets,

                ) {
                    NavigationBarItem(
                        selected = backStackEntry?.destination?.route == "HomeScreen",
                        onClick = { navController.navigate("HomeScreen") },
                        label = {
                            Text("Home")
                        },
                        icon = {
                            Icon(painterResource(id = R.drawable.home),
                                contentDescription = "home", Modifier.size(24.dp))
                        },
                        interactionSource = MutableInteractionSource(),
                    )

                    NavigationBarItem(
                        selected = backStackEntry?.destination?.route == "TaskScreen",
                        onClick = { navController.navigate("TaskScreen") },
                        label = {
                            Text("Task")
                        },
                        icon = { Icon(painterResource(id = R.drawable.tasks),
                            contentDescription = "tasks", Modifier.size(24.dp)) },
                    )

                    NavigationBarItem(
                        selected = backStackEntry?.destination?.route == "InsightScreen",
                        onClick = { navController.navigate("InsightScreen") },
                        label = {
                            Text(text = "Insights",
                                style = MaterialTheme.typography.bodySmall)
                        },
                        icon = { Icon(painterResource(id = R.drawable.insights),
                            contentDescription = "insights", Modifier.size(24.dp)) },
                    )

                    NavigationBarItem(
                        selected = backStackEntry?.destination?.route?.startsWith("SettingsScreen") ?: false,

                        onClick = {
                            navController.navigate("SettingsScreen")
                                  },
                        label = {
                            Text("Setting")
                        },
                        icon = { Icon(painterResource(id = R.drawable.settingsx),
                            contentDescription = "settings", Modifier.size(24.dp)) },
                    )
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
                        Homescreen(navController = navController)
                        // HomeScreen(navController = navController)
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

sealed class NavigationDestination(name: String, @DrawableRes icons: Int) {

    object Home : NavigationDestination("home", icons = R.drawable.home)
    object Tasks : NavigationDestination("Tasks", icons = R.drawable.tasks)
    object Insights : NavigationDestination("Insights", icons = R.drawable.insights)
    object Settings : NavigationDestination("Settings", icons = R.drawable.settingsx)
    object Others : NavigationDestination("home", icons = R.drawable.home)
}
