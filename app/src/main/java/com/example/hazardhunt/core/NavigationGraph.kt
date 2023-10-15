package com.example.hazardhunt.core
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
import com.example.hazardhunt.home.HomeScreen
import com.example.hazardhunt.login.presentation.LoginScreen
import com.example.hazardhunt.onboarding.domain.Navigationviewmodel
import com.example.hazardhunt.onboarding.presentation.OnBoardingViewModel
import com.example.hazardhunt.onboarding.presentation.OnboardingScreen
import com.example.hazardhunt.onboarding.presentation.Screen
import com.example.hazardhunt.onboarding.presentation.navgraph.NavigationRoutes
import com.example.hazardhunt.signup.presentation.SignUpPage

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
