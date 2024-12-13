package com.example.core.view.theme

import AppColorScheme
import AppShape
import AppSize
import AppTypography
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import localAppColorScheme
import localAppTypography
import localAppshape


val Roboto = UrbanistBold

val first = Color(0xFF90D0FF)
val second = Color(0xFFFFE1B2)
val third = Color(0xFFFFBAC1)
val fourth = Color(0xFF02A8A8)
val circledot = Color(0xFF617BE3)
val first_settings_item = Color(0xFFcebbfb)
val second_settings_item = Color(0xFF5f7c8c)
val third_settings_item = Color(0xFF9a2aae)
val fourth_settings_item = Color(0xFF1896fa)
val fifth_settings_item = Color(0xFFfc6c2b)

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
private val light_inverseOnSurface = Color(0xFFcdc9c2)
private val light_inverseSurface = Color(0xFF2f3032)
private val light_ColorBar = Color(0xFFf4f4f2)

private val dark_primary = Color(0xFF8bcdff)
private val dark_onPrimary = Color(0xFF111810)
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
private val dark_ColorBar = Color(0xFFf4f4f2)

private val dark_backgroundColor = Color(0xff2b2b2a)
private val onboarding_buttonColor = Color(0xFF292992)
private val seed = Color(0xFF0f3750)
private val error = Color(0xFFba1b1b)

private  val lightColorScheme = AppColorScheme(

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
    scrim = light_ColorBar,

)


private val darkColorScheme = AppColorScheme(
    onPrimary = dark_onPrimary,
    onPrimaryContainer = dark_onPrimaryContainer,
    secondary = dark_secondary,
    primary = dark_primary,
    primaryContainer = dark_primaryContainer,
    onSecondary = light_onSecondary,
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
    scrim = light_ColorBar,
)

private val typography =     AppTypography(
    displayLarge = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W400,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp,
    ),
    displayMedium = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W400,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp,
    ),
    displaySmall = TextStyle(
        fontFamily = UrbanistMedium,
        fontWeight = FontWeight.W400,
        fontSize = 17.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W400,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W400,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W400,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W400,
        fontSize = 23.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = UrbanistMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.1.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W400,
        fontSize = 24.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
    ),
    headlineSmal =TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
    )
)

private  val shape =AppShape(
    container = RoundedCornerShape(12.dp),
    button = RoundedCornerShape(50)

)
private val size = AppSize(
    large =24.dp,
    medium =16.dp,
    normal =12.dp,
    small =8.dp
)


@Composable
fun SafeBuddyTheme(
    isDarkTheme:Boolean = isSystemInDarkTheme(),
    content : @Composable ()-> Unit
){
   val colorScheme = if (isDarkTheme) darkColorScheme else lightColorScheme
   CompositionLocalProvider(
       localAppColorScheme provides colorScheme,
       localAppTypography provides  typography ,
       localAppshape provides shape,
       content= content
   )
}
