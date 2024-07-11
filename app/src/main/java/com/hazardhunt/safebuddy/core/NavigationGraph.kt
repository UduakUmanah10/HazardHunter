package com.hazardhunt.safebuddy.core
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.hazardhunt.safebuddy.login.presentation.LoginScreen
import com.hazardhunt.safebuddy.onboarding.domain.Navigationviewmodel
import com.hazardhunt.safebuddy.onboarding.presentation.OnBoardingViewModel
import com.hazardhunt.safebuddy.onboarding.presentation.OnboardingScreen
import com.hazardhunt.safebuddy.onboarding.presentation.Screen
import com.hazardhunt.safebuddy.onboarding.presentation.navgraph.NavigationRoutes
import com.hazardhunt.safebuddy.savedtaskscreen.HomeScreen
import com.hazardhunt.safebuddy.signup.presentation.SignUpPage

@Composable
fun ScreenNavigation(
    navHostController: NavHostController,
    startDestination: String,
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
    ) {
        navigation(
            route = NavigationRoutes.StartNavigation.routes,
            startDestination = NavigationRoutes.OnBoardingScreen.routes,
        ) {
            composable(NavigationRoutes.OnBoardingScreen.routes) {
                val viewmodel: OnBoardingViewModel = hiltViewModel()
                OnboardingScreen(
                    navController = navHostController,
                    event = viewmodel::onEvent,
                )
            }
        }

        navigation(
            route = NavigationRoutes.LoginandSignup.routes,
            startDestination = NavigationRoutes.LoginScreen.routes,
        ) {
            composable(NavigationRoutes.SignupScreen.routes) {
                SignUpPage()
            }

            composable(NavigationRoutes.LoginScreen.routes) {
                LoginScreen(
                    loginCompleted = {
                        navHostController.popBackStack()
                        navHostController.navigate("first")
                    },
                    signup = { navHostController.navigate("newSignup") },
                )
            }
        }

        navigation(
            route = "newSignup",
            startDestination = "n",
        ) {
            composable("n") {
                Surface(
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.fillMaxSize(),
                ) {
                    SignUpPage()
                }
            }
        }

        navigation(
            route = NavigationRoutes.HomeNavigation.routes,
            startDestination = "first",
        ) {
            composable("first") {
                HomeScreen(
                    onAddButtonClicked = {},
                )
            }
        }

        composable("first") {
            HomeScreen(
                onAddButtonClicked = {},
            )
        }
    }
}

@Composable
fun onBoarding(
    navHostController: NavHostController,
    navigationViewModel: Navigationviewmodel = hiltViewModel(),
    signup: () -> Unit,
) {
    val viewmodel: OnBoardingViewModel = hiltViewModel()

    val start = navigationViewModel.startDestination.collectAsState()

    if (start.value == Screen.onboardingScreen.route) {
        OnboardingScreen(
            navController = navHostController,
            event = viewmodel::onEvent,
        )
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
