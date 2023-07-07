package com.example.hazardhunt.core

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hazardhunt.home.HomeScreen
import com.example.hazardhunt.login.presentation.LoginScreen
import com.example.hazardhunt.onboarding.presentation.OnboardingScreen
import com.example.hazardhunt.onboarding.presentation.Screen

@Composable
fun SetUpNavigationGraph(
    navController: NavHostController,
    startDestination: String,
) {
    NavHost(navController = navController, startDestination = Screen.onboardingScreen.route) {
        composable("Home") {
            OnboardingScreen(navController = navController)
        }

        composable("login") {
            LoginScreen(loginCompleted = { navController.navigate("Home") })
        }

        composable("Home") {
        }
    }
}

@Composable
fun ScreenNavigation(
    navHostController: NavHostController,
    startDestination: String,
    // navigationViewModel: NavViewModel = hiltViewModel(),
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
    ) {
        composable(Screen.onboardingScreen.route) {
            OnboardingScreen(navController = navHostController)
        }
        composable(Screen.welcomeScreen.route) {
            LoginScreen(loginCompleted = {
                navHostController.popBackStack()
                navHostController.navigate("first")
            })
        }
        composable("first") {
            HomeScreen()
        }
    }
}
