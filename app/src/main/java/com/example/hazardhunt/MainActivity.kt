package com.example.hazardhunt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.hazardhunt.login.presentation.LoginScreen
import com.example.hazardhunt.ui.theme.HazardHuntTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            // ConfigureTransparentSystemBars()
            HazardHuntTheme {
                // A surface container using the 'background' color from the theme
                LoginScreen(
                    modifier = Modifier.navigationBarsPadding(),
                    loginCompleted = {},
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Composable
@Preview(showBackground = true)
fun GreetingPreview() {
    HazardHuntTheme {
        Greeting("Android")
    }
}
