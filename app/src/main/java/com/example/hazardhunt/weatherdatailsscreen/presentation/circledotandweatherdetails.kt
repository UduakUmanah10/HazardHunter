// ktlint-disable filename
package com.example.hazardhunt.weatherdatailsscreen.presentation

import android.content.res.Configuration
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

@Composable
fun circleddotandweatherdetails() {
    Row {
        dotanddashedline(modifier = Modifier.padding(top = 35.dp))

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

@Preview(
    name = "Day mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
fun circledotandweatherpreview(
    modifier: Modifier =
        Modifier.width(380.dp)
            .padding(bottom = 40.dp),

    columModifier: Modifier = Modifier
        .fillMaxSize()
        .fillMaxWidth(),

) {
    HazardHuntTheme {
        circleddotandweatherdetails()
    }
}
