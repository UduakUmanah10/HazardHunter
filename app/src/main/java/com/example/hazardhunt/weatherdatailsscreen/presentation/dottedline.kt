// ktlint-disable filename
package com.example.hazardhunt.weatherdatailsscreen.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.unit.dp

@Composable
fun dottedline(
    dottedlineColor: Color = Color.Blue,
) {
    Canvas(
        modifier = Modifier
            .padding(start = 10.dp, top = 5.dp, bottom = 5.dp)
            .width(10.dp)
            .height(80.dp),

    ) {
        drawLine(
            color = dottedlineColor,
            start = Offset(0f, 0f),
            end = Offset(0f, y = size.height),
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f)),
            strokeWidth = 1.dp.toPx(),
        )
    }
}
