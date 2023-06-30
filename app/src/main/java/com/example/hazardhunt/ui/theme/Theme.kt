package com.example.hazardhunt.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView

@Composable
fun HazardHuntTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> LightThemeColors
        else -> DarkThemeColors
    }
    val view = LocalView.current
    // if (!view.isInEditMode) {
    //   SideEffect {
    //    val window = (view.context as Activity).window
    //     window.statusBarColor = colorScheme.primary.toArgb()
    //      WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
    //    }
    // }

    androidx.compose.material.MaterialTheme(
        colors = if (darkTheme) {
            DarkMD2Colors
        } else {
            LightMD2Colors
        },
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppTypography,
            content = content,
        )
    }
}
