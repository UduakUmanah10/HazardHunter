import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

@Stable
data class AppColorScheme(
    val primary :Color,
    val onPrimary:Color,
    val primaryContainer:Color,
    val onPrimaryContainer:Color,
    val secondary:Color,
    val onSecondary:Color ,
    val secondaryContainer:Color ,
    val onSecondaryContainer:Color ,

    val tertiary:Color ,
    val onTertiary :Color,
    val tertiaryContainer:Color ,
    val onTertiaryContainer:Color ,
    val error:Color,
    val errorContainer:Color  ,
    val onError:Color,
    val onErrorContainer:Color  ,
    val background:Color  ,
   val  onBackground:Color ,
   val  surface :Color,
   val  onSurface:Color ,
   val  surfaceVariant:Color,
   val  onSurfaceVariant:Color,
   val  outline:Color,
  val inverseOnSurface:Color ,
   val  inverseSurface:Color,
   val  scrim : Color
    )

@Stable
data class AppTypography(
   val displayLarge : TextStyle,
   val displayMedium : TextStyle,
   val displaySmall : TextStyle,
   val headlineLarge  :TextStyle,
   val headlineMedium : TextStyle,
   val headlineSmal:  TextStyle,
   val titleLarge :TextStyle,
   val titleMedium : TextStyle,
   val titleSmall : TextStyle,
   val labelLarge : TextStyle,
   val bodyLarge : TextStyle,
   val bodyMedium:  TextStyle,
   val bodySmall : TextStyle,
   val labelMedium:  TextStyle,
   val  labelSmall : TextStyle,
   val headlineSmall:TextStyle,


    )
@Stable
data class AppShape(
    val container: Shape,
    val button :Shape
)

@Stable
data class AppSize(
    val large: Dp,
    val medium:Dp,
    val normal:Dp,
    val small:Dp
)

val localAppColorScheme = staticCompositionLocalOf {

    AppColorScheme(
        primary = Color.Unspecified,
        onPrimary =Color.Unspecified,
        primaryContainer =Color.Unspecified,
        onPrimaryContainer =Color.Unspecified,
        secondary =Color.Unspecified,
        onSecondary = Color.Unspecified,
        secondaryContainer =Color.Unspecified,
        onSecondaryContainer =Color.Unspecified ,
        tertiary =Color.Unspecified,
        onTertiary =Color.Unspecified,
        tertiaryContainer =Color.Unspecified ,
        onTertiaryContainer = Color.Unspecified,
        error =Color.Unspecified,
        errorContainer =Color.Unspecified,
        onError =Color.Unspecified,
        onErrorContainer = Color.Unspecified,
        background =Color.Unspecified,
        onBackground = Color.Unspecified,
        surface =Color.Unspecified,
        onSurface = Color.Unspecified,
        surfaceVariant =Color.Unspecified,
        onSurfaceVariant =Color.Unspecified ,
        outline =Color.Unspecified ,
        inverseOnSurface =Color.Unspecified ,
        inverseSurface =Color.Unspecified ,
        scrim = Color.Unspecified

    )
}


val localAppTypography = staticCompositionLocalOf {

    AppTypography(
        displayLarge = TextStyle.Default,
        displayMedium = TextStyle.Default,
        displaySmall = TextStyle.Default,
    headlineLarge  =TextStyle.Default,
     headlineMedium = TextStyle.Default,
     headlineSmal=  TextStyle.Default,
     titleLarge =TextStyle.Default,
     titleMedium = TextStyle.Default,
     titleSmall = TextStyle.Default,
     labelLarge = TextStyle.Default,
     bodyLarge = TextStyle.Default,
     bodyMedium=  TextStyle.Default,
     bodySmall = TextStyle.Default,
     labelMedium=  TextStyle.Default,
        labelSmall = TextStyle.Default,
        headlineSmall =TextStyle.Default

    )


}


val localAppshape = staticCompositionLocalOf {
    AppShape(
        container = RectangleShape,
     button = RectangleShape
    )

}

val lacalAppSize = staticCompositionLocalOf {
    AppSize(
        large =Dp.Unspecified ,
        medium =Dp.Unspecified,
        small = Dp.Unspecified ,
        normal = Dp.Unspecified

    )
}
