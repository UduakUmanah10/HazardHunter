// ktlint-disable filename
package com.hazardhunt.safebuddy.weatherdatailsscreen.presentation

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hazardhunt.safebuddy.R
import com.hazardhunt.safebuddy.ui.theme.HazardHuntTheme

@Composable
fun modulatedfourbottomicon(
    @DrawableRes firstIcon: Int = R.drawable.air,
    @DrawableRes secondIcon: Int = R.drawable.humidity_low,
    firstCalibration: String = "E 8 kmh",
    secondCalibration: String = "61%",
    firstweatherElement: String = "wind",
    secondweatherElement: String = "humidity",
    modifier: Modifier = Modifier,
    @DrawableRes thirdIcon: Int = R.drawable.sunny,
    @DrawableRes fourthIcon: Int = R.drawable.arrow_circle,
    thirdCalibration: String = "11",
    fourthCalibration: String = "11 mkPa",
    thirdweatherElement: String = "uv index",
    fourthweatherElement: String = "pressure",
) {
    Column(modifier = modifier) {
        multipleRow(
            firstIcon = firstIcon,
            secondIcon = secondIcon,
            firstCalibration = firstCalibration,
            secondCalibration = secondCalibration,
            firstweatherElement = firstweatherElement,
            secondweatherElement = secondweatherElement,
            modifier,

        )
        multipleRow(
            firstIcon = thirdIcon,
            secondIcon = fourthIcon,
            firstCalibration = thirdCalibration,
            secondCalibration = fourthCalibration,
            firstweatherElement = thirdweatherElement,
            secondweatherElement = fourthweatherElement,
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
fun completefouriconpreview() {
    HazardHuntTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
        ) {
            //       iconandvalue()
            modulatedfourbottomicon()
        }
    }
}
