// ktlint-disable filename
package com.example.hazardhunt.homescreen.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hazardhunt.ui.theme.HazardHuntTheme

@Composable
fun weathercard() {
    Card(
        modifier = Modifier
            .padding(10.dp),

        shape = RoundedCornerShape(15.dp),

    ) {
        Column(
            modifier = Modifier
                .height(200.dp)
                .width(400.dp)
                .padding(2.dp),
        ) {
            temperatureandWeatherImage()
            airquality()
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
fun weathercardpreview() {
    HazardHuntTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
        ) {
            weathercard()
        }
    }
}
