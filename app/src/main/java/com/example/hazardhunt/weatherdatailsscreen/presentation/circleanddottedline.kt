// ktlint-disable filename
package com.example.hazardhunt.weatherdatailsscreen.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.hazardhunt.ui.theme.HazardHuntTheme

@Composable
fun dotanddashedline(
    circleColor: Color = Color.Blue,
    dottedlineColor: Color = Color.Blue,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        for (i in BEGIN..STOP) {
            coloredcircle(circleColor = circleColor)
            if (i < STOP) {
                dottedline(dottedlineColor = dottedlineColor)
            }
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
            dotanddashedline()
        }
    }
}
