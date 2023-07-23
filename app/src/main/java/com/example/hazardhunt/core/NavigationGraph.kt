package com.example.hazardhunt.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hazardhunt.home.HomeScreen
import com.example.hazardhunt.login.presentation.LoginScreen
import com.example.hazardhunt.onboarding.domain.NavViewModel
import com.example.hazardhunt.onboarding.presentation.OnboardingScreen
import com.example.hazardhunt.onboarding.presentation.Screen

@Composable
fun ScreenNavigation(
    navHostController: NavHostController,
    navigationViewModel: NavViewModel = hiltViewModel(),
    onboardingbm: OnbaordingViewModel1 = viewModel(),
) {
    val startDest = navigationViewModel.startDestination.collectAsState()

    NavHost(
        navController = navHostController,
        startDestination = startDest.value,
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
            HomeScreen(onAddButtonClicked = {})
        }
    }
}
