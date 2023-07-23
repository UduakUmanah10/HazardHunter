package com.example.hazardhunt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.example.hazardhunt.core.ScreenNavigation
import com.example.hazardhunt.onboarding.domain.NavViewModel
import com.example.hazardhunt.ui.theme.HazardHuntTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //  lateinit var startdestination:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navigationViewModel by viewModels<NavViewModel>()

        installSplashScreen()
        setContent {
            WindowCompat.setDecorFitsSystemWindows(window, false)
            val startdestination by navigationViewModel.startDestination.collectAsState()

            HazardHuntTheme {
                val navController = rememberNavController()
                ScreenNavigation(navHostController = navController)
            }
        }
    }
}
