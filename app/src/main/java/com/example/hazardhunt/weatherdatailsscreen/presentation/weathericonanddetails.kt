// ktlint-disable filename
package com.example.hazardhunt.weatherdatailsscreen.presentation

import android.content.res.Configuration
import androidx.annotation.DrawableRes
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
import com.example.hazardhunt.ui.theme.first
import com.example.hazardhunt.ui.theme.fourth
import com.example.hazardhunt.ui.theme.second
import com.example.hazardhunt.ui.theme.third

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
    text: String = "initials ",
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier,
    ) {
        reuseableiconandtext(
            textComponent = timeoftheDay,
            imageComponent = imageComponent,
        )
        weatherdetailsbox(
            backgroundColor = backgroundColor,
            subScript = subScript,
            temperatureValue = temperatureValue,
            text = text,

        )
    }
}

@Composable
fun new(
    modifier: Modifier =
        Modifier
            .width(380.dp)
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

data class Weatherdetails(
    val timeoftheDay: String,
    @DrawableRes val icon: Int,
    val temperature: String,
    val details: String,
    val color: Color,
)

val items: List<Weatherdetails> = arrayListOf(
    Weatherdetails("Morning", R.drawable.sun_and_cloud, "30", "warmest day of the week", first),
    Weatherdetails("Afternoon", R.drawable.clearsky, "30", "turning cloudy and windy", second),
    Weatherdetails("Evening", R.drawable.moonandrain, "30", "wind light and chance of rain", third),
    Weatherdetails("Night", R.drawable.halfmoon, "30", "chance of heavy rain", fourth),
)

@Composable
fun refactoredWeatherdetails(
    modifier: Modifier =
        Modifier
            .width(380.dp)
            .padding(bottom = 40.dp),
    subScript: String = "°",
    items: List<Weatherdetails>,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        items.forEach { details ->

            weathericonanddetails(
                backgroundColor = details.color,
                subScript = subScript,
                temperatureValue = details.temperature,
                timeoftheDay = details.timeoftheDay,
                imageComponent = details.icon,
                text = details.details,
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
        Modifier
            .width(380.dp)
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
        refactoredWeatherdetails(
            modifier = Modifier
                .width(380.dp)
                .padding(bottom = 40.dp),
            items = items,
        )
        //  new(
        //    modifier = Modifier
        //      .width(380.dp)
        //    .padding(bottom = 40.dp),
        // columModifier = Modifier
        //   .fillMaxSize()
        //  .fillMaxWidth(),

        // backgroundColor = Color.Blue,
        // subScript = "°",
        // temperatureValue = "30",
        // timeoftheDay = "Afternoon",
        // imageComponent = R.drawable.sun_and_cloud,
        // )
    }
}
