// ktlint-disable filename
package com.example.hazardhunt.weatherdatailsscreen.presentation

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
    circleColor: Color = Color.Blue,
) {
    Surface(
        modifier = Modifier
            .height(20.dp)
            .width(20.dp),
        color = circleColor,
        shape = CircleShape,
    ) {
    }
}
