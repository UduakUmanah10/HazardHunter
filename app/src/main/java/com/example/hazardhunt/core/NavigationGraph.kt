package com.example.hazardhunt.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hazardhunt.home.HomeScreen
import com.example.hazardhunt.login.presentation.LoginScreen
import com.example.hazardhunt.onboarding.domain.Navigationviewmodel
import com.example.hazardhunt.onboarding.presentation.OnboardingScreen
import com.example.hazardhunt.onboarding.presentation.Screen
import com.example.hazardhunt.signup.presentation.SignUpPage

@Composable
fun ScreenNavigation(
    navHostController: NavHostController,
    navigationViewModel: Navigationviewmodel = hiltViewModel(),
) {
    // val startDest = navigationViewModel.startDestination.collectAsState()

    NavHost(
        navController = navHostController,
        startDestination = "New", // startDest.value,
    ) {
        composable("New") {
            newOnboarding(
                navHostController = navHostController,
                signup = { navHostController.navigate("signup") },
            )
        }
        // composable(Screen.onboardingScreen.route) {
        //   OnboardingScreen(navController = navHostController)
        // }
        composable(Screen.welcomeScreen.route) {
            LoginScreen(
                loginCompleted = {
                    navHostController.popBackStack()
                    navHostController.navigate("first")
                },
                signup = { navHostController.navigate("signup") },
            )
        }
        composable("first") {
            HomeScreen(
                onAddButtonClicked = {},
            )
        }
        composable("signup") {
            SignUpPage()
        }
    }
}

@Composable
fun newOnboarding(
    navHostController: NavHostController,
    navigationViewModel: Navigationviewmodel = hiltViewModel(),
    signup: () -> Unit,
) {
    val start = navigationViewModel.startDestination.collectAsState()

    if (start.value == Screen.onboardingScreen.route) {
        OnboardingScreen(navController = navHostController)
    }

    if (start.value == Screen.welcomeScreen.route) {
        LoginScreen(
            loginCompleted = {
                navHostController.popBackStack()
                navHostController.navigate("first")
            },
            signup = signup,
        )
    }
}
