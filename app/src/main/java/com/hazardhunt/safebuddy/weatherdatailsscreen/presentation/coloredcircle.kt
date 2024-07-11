// ktlint-disable filename
package com.hazardhunt.safebuddy.weatherdatailsscreen.presentation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun coloredcircle(
    modifier: Modifier = Modifier
        .height(20.dp)
        .width(20.dp),
    circleColor: Color = Color.Blue,
) {
    Surface(
        modifier = modifier,
        color = circleColor,
        shape = CircleShape,
    ) {
    }
}
