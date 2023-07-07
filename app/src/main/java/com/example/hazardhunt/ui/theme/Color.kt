@file:Suppress("MagicNumber")

package com.example.hazardhunt.ui.theme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

private val light_primary = Color(0xFF006495)
private val light_onPrimary = Color(0xFFffffff)
private val light_primaryContainer = Color(0xFFc9e6ff)
private val light_onPrimaryContainer = Color(0xFF001e31)
private val light_secondary = Color(0xFF50606e)
private val light_onSecondary = Color(0xFFffffff)
private val light_secondaryContainer = Color(0xFFd3e4f5)
private val light_onSecondaryContainer = Color(0xFF0c1d29)
private val light_tertiary = Color(0xFF65587b)
private val light_onTertiary = Color(0xFFffffff)
private val light_tertiaryContainer = Color(0xFFecdcff)
private val light_onTertiaryContainer = Color(0xFF211634)
private val light_error = Color(0xFFba1b1b)
private val light_errorContainer = Color(0xFFffdad4)
private val light_onError = Color(0xFFffffff)
private val light_onErrorContainer = Color(0xFF410001)
private val light_background = Color(0xFFfcfcff)
private val light_onBackground = Color(0xFF1a1c1e)
private val light_surface = Color(0xFFfcfcff)
private val light_onSurface = Color(0xFF1a1c1e)
private val light_surfaceVariant = Color(0xFFdee3ea)
private val light_onSurfaceVariant = Color(0xFF41474d)
private val light_outline = Color(0xFF72787e)
private val light_inverseOnSurface = Color(0xFFf0f0f3)
private val light_inverseSurface = Color(0xFF2f3032)

private val dark_primary = Color(0xFF8bcdff)
private val dark_onPrimary = Color(0xFF003450)
private val dark_primaryContainer = Color(0xFF004b72)
private val dark_onPrimaryContainer = Color(0xFFc9e6ff)
private val dark_secondary = Color(0xFFb7c8d9)
private val dark_onSecondary = Color(0xFFfefefe)
private val dark_secondaryContainer = Color(0xFF394956)
private val dark_onSecondaryContainer = Color(0xFFd3e4f5)
private val dark_tertiary = Color(0xFFd0c0e8)
private val dark_onTertiary = Color(0xFF362b4a)
private val dark_tertiaryContainer = Color(0xFF4d4162)
private val dark_onTertiaryContainer = Color(0xFFecdcff)
private val dark_error = Color(0xFFffb4a9)
private val dark_errorContainer = Color(0xFF930006)
private val dark_onError = Color(0xFF680003)
private val dark_onErrorContainer = Color(0xFFffdad4)
private val dark_background = Color(0xFF2b2b2a)
private val dark_onBackground = Color(0xFFe2e2e5)
private val dark_surface = Color(0xFF1a1c1e)
private val dark_onSurface = Color(0xFFe2e2e5)
private val dark_surfaceVariant = Color(0xFF41474d)
private val dark_onSurfaceVariant = Color(0xFFc2c7ce)
private val dark_outline = Color(0xFF8b9198)
private val dark_inverseOnSurface = Color(0xFF1a1c1e)
private val dark_inverseSurface = Color(0xFFe2e2e5)
private val button_cardBackground = Color(0xFFe6f5fb)
private val dark_fontColor = Color(0xFFe8e9e9)

private val dark_backgroundColor = Color(0xff2b2b2a)
private val onboarding_buttonColor = Color(0xFF292992)
val seed = Color(0xFF0f3750)
val error = Color(0xFFba1b1b)

val LightThemeColors = lightColorScheme(
    primary = light_primary,
    onPrimary = light_onPrimary,
    primaryContainer = light_primaryContainer,
    onPrimaryContainer = light_onPrimaryContainer,
    secondary = light_secondary,
    onSecondary = light_onSecondary,
    secondaryContainer = light_secondaryContainer,
    onSecondaryContainer = light_onSecondaryContainer,
    tertiary = light_secondary,
    onTertiary = light_onTertiary,
    tertiaryContainer = light_tertiaryContainer,
    onTertiaryContainer = light_onTertiaryContainer,
    error = light_error,
    errorContainer = light_errorContainer,
    onError = light_onError,
    onErrorContainer = light_onErrorContainer,
    background = light_background,
    onBackground = light_onBackground,
    surface = light_surface,
    onSurface = light_onSurface,
    surfaceVariant = light_surfaceVariant,
    onSurfaceVariant = light_onSurfaceVariant,
    outline = light_outline,
    inverseOnSurface = light_inverseOnSurface,
    inverseSurface = light_inverseSurface,
)

val DarkThemeColors = darkColorScheme(
    primary = dark_primary,
    onPrimary = dark_onPrimary,
    primaryContainer = dark_primaryContainer,
    onPrimaryContainer = dark_onPrimaryContainer,
    secondary = dark_secondary,
    onSecondary = dark_onSecondary,
    secondaryContainer = dark_onSecondaryContainer,
    onSecondaryContainer = dark_onSecondaryContainer,
    tertiary = button_cardBackground,
    onTertiary = dark_onTertiary,
    tertiaryContainer = dark_tertiaryContainer,
    onTertiaryContainer = dark_onTertiaryContainer,
    error = dark_onError,
    errorContainer = dark_errorContainer,
    onError = dark_onError,
    onErrorContainer = dark_onErrorContainer,
    background = dark_background,
    onBackground = dark_backgroundColor,
    surface = dark_surface,
    onSurface = dark_onSurface,
    surfaceVariant = dark_surfaceVariant,
    onSurfaceVariant = dark_onSurfaceVariant,
    outline = dark_outline,
    inverseOnSurface = dark_inverseOnSurface,
    inverseSurface = onboarding_buttonColor,
)

val DarkMD2Colors = darkColors(
    primary = DarkThemeColors.primary,
    secondary = DarkThemeColors.secondary,
    background = DarkThemeColors.background,
    surface = DarkThemeColors.surface,
    error = DarkThemeColors.error,
    onPrimary = DarkThemeColors.onPrimary,
    onSecondary = DarkThemeColors.onSecondary,
    onBackground = DarkThemeColors.onBackground,
    onSurface = DarkThemeColors.onSurface,
    onError = DarkThemeColors.onError,
)

val LightMD2Colors = lightColors(
    primary = LightThemeColors.primary,
    secondary = LightThemeColors.secondary,
    background = LightThemeColors.background,
    surface = LightThemeColors.surface,
    error = LightThemeColors.error,
    onPrimary = LightThemeColors.onPrimary,
    onSecondary = LightThemeColors.onSecondary,
    onBackground = LightThemeColors.onBackground,
    onSurface = LightThemeColors.onSurface,
    onError = LightThemeColors.onError,
)

val backgroundColor = Color(0xFF2b2b2a)
val cardBackground = Color(0xFFe6f5fb)
val fontColor = Color(0xFFe8e9e9)
