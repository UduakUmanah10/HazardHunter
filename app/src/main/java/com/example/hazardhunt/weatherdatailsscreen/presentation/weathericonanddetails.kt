// ktlint-disable filename
package com.example.hazardhunt.weatherdatailsscreen.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hazardhunt.R
import com.example.hazardhunt.ui.theme.HazardHuntTheme

typealias start = Int
typealias end = Int

const val BEGIN: start = 1
const val STOP: end = 4

@Composable
fun weathericonanddetails(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Blue,
    subScript: String = "°",
    temperatureValue: String = "30",
    timeoftheDay: String = "Afternoon",
    imageComponent: Int = R.drawable.sun_and_cloud,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier,
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

@Composable
fun new(
    modifier: Modifier =
        Modifier.width(380.dp)
            .padding(bottom = 40.dp),

    columModifier: Modifier = Modifier
        .fillMaxSize()
        .fillMaxWidth(),

    backgroundColor: Color = Color.Blue,
    subScript: String = "°",
    temperatureValue: String = "30",
    timeoftheDay: String = "Afternoon",
    imageComponent: Int = R.drawable.sun_and_cloud,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth(),
    ) {
        for (i in BEGIN..STOP) {
            weathericonanddetails(
                backgroundColor = backgroundColor,
                subScript = subScript,
                temperatureValue = temperatureValue,
                timeoftheDay = timeoftheDay,
                imageComponent = imageComponent,
                modifier = modifier,
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
fun weathericonanddetailspreview(
    modifier: Modifier =
        Modifier.width(380.dp)
            .padding(bottom = 40.dp),

    columModifier: Modifier = Modifier
        .fillMaxSize()
        .fillMaxWidth(),

    backgroundColor: Color = Color.Blue,
    subScript: String = "°",
    temperatureValue: String = "30",
    timeoftheDay: String = "Afternoon",
    imageComponent: Int = R.drawable.sun_and_cloud,
) {
    HazardHuntTheme {
        new(
            modifier = Modifier.width(380.dp)
                .padding(bottom = 40.dp),
            columModifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),

            backgroundColor = Color.Blue,
            subScript = "°",
            temperatureValue = "30",
            timeoftheDay = "Afternoon",
            imageComponent = R.drawable.sun_and_cloud,
        )
    }
}
