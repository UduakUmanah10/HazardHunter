// ktlint-disable filename
package com.example.hazardhunt.weatherdatailsscreen.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hazardhunt.R
import com.example.hazardhunt.ui.theme.HazardHuntTheme

@Composable
fun weathericonanddetails(
    backgroundColor: Color = Color.Blue,
    subScript: String = "°",
    temperatureValue: String = "30",
    timeoftheDay: String = "Afternoon",
    imageComponent: Int = R.drawable.sun_and_cloud,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.width(380.dp),
    ) {
        weathericonandtimeoftheday(
            textComponent = timeoftheDay,
            imageComponent = imageComponent,
        )
        weatherdetailsbox(
            backgroundColor = backgroundColor,
            subScript = subScript,
            temperatureValue = temperatureValue,
        )
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
fun weathericonanddetailspreview() {
    HazardHuntTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
        ) {
            weathericonanddetails()
        }
    }
}
