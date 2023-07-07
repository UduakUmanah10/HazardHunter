package com.example.hazardhunt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.example.hazardhunt.core.ScreenNavigation
import com.example.hazardhunt.onboarding.data.OnboardingSettings
import com.example.hazardhunt.onboarding.data.OnboardingState
import com.example.hazardhunt.onboarding.data.datastore
import com.example.hazardhunt.onboarding.domain.NavViewModel
import com.example.hazardhunt.onboarding.presentation.Screen
import com.example.hazardhunt.ui.theme.HazardHuntTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    // lateinit var navigationViewModel: NavigationViewModel
    lateinit var navigationViewModel: NavViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()

        setContent {
            val screenn = datastore.data.collectAsState(initial = OnboardingSettings())
            val screen = checkOnborrding(screenn.value.completed)
            HazardHuntTheme {
                val appsettings = navigationViewModel.startDestination.value
                val navController = rememberNavController()

                ScreenNavigation(navHostController = navController, appsettings)
            }
        }
    }
}

fun checkOnborrding(input: OnboardingState): String {
    return if (input == OnboardingState.COMPLETED) {
        Screen.welcomeScreen.route
    } else {
        Screen.onboardingScreen.route
    }
}
