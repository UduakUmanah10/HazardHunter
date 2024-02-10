// ktlint-disable filename
package com.example.hazardhunt.weatherdatailsscreen.presentation

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hazardhunt.ui.theme.HazardHuntTheme

@Composable
fun coloredcircle() {
    Surface(
        modifier = Modifier
            .height(20.dp)
            .width(20.dp),
        color = Color.Blue,
        shape = CircleShape,
    ) {
    }
}

@Composable
fun dottedline() {
    Surface {
        Canvas(
            modifier = Modifier.padding(start = 3.dp)
                .width(10.dp)
                .height(100.dp),

        ) {
            drawLine(
                color = Color.Red,
                start = Offset(0f, 0f),
                end = Offset(0f, y = size.height),
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f)),
                strokeWidth = 1.dp.toPx(),
            )
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
fun coloredcirclepreview() {
    HazardHuntTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
        ) {
            // coloredcircle()
            dottedline()
        }
    }
}
