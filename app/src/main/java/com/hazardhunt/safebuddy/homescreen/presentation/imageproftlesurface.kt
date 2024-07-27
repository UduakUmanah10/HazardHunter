// ktlint-disable filename
package com.hazardhunt.safebuddy.homescreen.presentation

import android.content.res.Configuration
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hazardhunt.safebuddy.settingsscreen.presentation.ui.surface
import com.hazardhunt.safebuddy.ui.theme.HazardHuntTheme
/**
 *
 * This is a surface composable that has a functionality of displaying the profile picture of the users in two
 * modes. one of the display mode is to display the profile pictures with a moving animated background and the
 * other mode is to display the user profile picture without an animated border.
 * the functionality of the border is controlled by a boolean @param[animate] parameter in the function.
 * other parameters in the composable are:
 *
 * @param[modifier] to modify the composable
 * @param[shape] specifies the shape of the composable
 * @param[animatedBorderwidth] specifies the width of the animation border width
 * @param[gradient] specifies thw width of the gradient
 * @param[animationDuration]  specifies the animation duration
 * @param[onCardClick] provides a clickable response for the composable
 * @param[content] specifies the composable item that would be wrapped in the surface.
 *
 * **/

@Composable
fun AnimatedBorderCard(
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    animatedBorderwidth: Dp = 2.dp,
    unanimatedBorderWidth: Dp = 1.dp,
    gradient: Brush = Brush.sweepGradient(listOf(Color.Gray, Color.White)),
    animationDuration: Int = 10000,
    onCardClick: () -> Unit = {},
    animate: Boolean = true,
    content: @Composable () -> Unit,
) {
    val infiniteTransition = rememberInfiniteTransition(label = "Infinite Color Animation")
    val degrees by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = animationDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart,
        ),
        label = "Infinite Colors",
    )

    Surface(
        modifier = modifier
            .clip(shape)
            .clickable { onCardClick() },
        shape = shape,

    ) {
        Surface(
            modifier = Modifier.then(
                if (animate) {
                    Modifier
                        .wrapContentSize()
                        .padding()
                        .drawWithContent {
                            rotate(degrees = degrees) {
                                drawCircle(
                                    brush = gradient,
                                    radius = size.width,
                                    blendMode = BlendMode.SrcIn,
                                )
                            }
                            drawContent()
                        }
                } else {
                    Modifier
                        .wrapContentSize()
                },

            ),
            color = MaterialTheme.colorScheme.surface,
            shape = shape,
            border = if (animate) null else BorderStroke(unanimatedBorderWidth, Color.Red),

        ) {
            content()
        }
    }
}

@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Day mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
fun PofileImagSurface() {
    HazardHuntTheme {
        // ProfileImageSurface()
        AnimatedBorderCard(animate = false) {
            surface()
        }
    }
}
