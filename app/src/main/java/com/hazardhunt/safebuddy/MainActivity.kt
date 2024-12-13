package com.hazardhunt.safebuddy
import android.Manifest
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.core.view.theme.SafeBuddyTheme
import com.hazardhunt.safebuddy.core.ScreenNavigation
import com.hazardhunt.safebuddy.core.broadcastRecievers.AirPlaneModeReciever
import com.hazardhunt.safebuddy.onboarding.data.model.OnBoardingUseCases
import com.hazardhunt.safebuddy.onboarding.presentation.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var appentry: OnBoardingUseCases

    private val navigationViewMode by viewModels<MainViewModel>()
    private val airPlaneModeReceiver = AirPlaneModeReciever()

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val splashscreen = installSplashScreen()

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT,
            ),
            navigationBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT,
            ),

        )

        super.onCreate(savedInstanceState)

        splashscreen.setKeepOnScreenCondition {
            navigationViewMode.splashscreenstate
        }

        lifecycleScope.launch {
            appentry.readOnBoardingState().collect {
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                0,
            )
        }

        registerReceiver(
            airPlaneModeReceiver,
            IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED),
        )

        setContent {
            SafeBuddyTheme {
                val navController = rememberNavController()
                val startdestination = navigationViewMode.startdestination

                ScreenNavigation(
                    navHostController = navController,
                    startDestination = startdestination,

                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(airPlaneModeReceiver)
    }
}
