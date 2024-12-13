// ktlint-disable filename
package com.hazardhunt.safebuddy.weatherdatailsscreen.presentation
import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.view.theme.SafeBuddyTheme
import com.hazardhunt.safebuddy.R

@Composable
fun weatherscrentest(
    titleContentColor: Color = MaterialTheme.colorScheme.onSecondary,
    containerColor: Color = MaterialTheme.colorScheme.outline,
    titleText: String = "Today",
    onClick: () -> Unit = {},
    @DrawableRes icon: Int = R.drawable.chevronleft,
    iconColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    clickable: () -> Unit = {},
    datetext: String = "Feburary 2020",
    @DrawableRes firstIcon: Int = R.drawable.air,
    @DrawableRes secondIcon: Int = R.drawable.humidity_low,
    firstCalibration: String = "E 8 kmh",
    secondCalibration: String = "61%",
    firstweatherElement: String = "wind",
    secondweatherElement: String = "humidity",
    @DrawableRes thirdIcon: Int = R.drawable.sunny,
    @DrawableRes fourthIcon: Int = R.drawable.arrow_circle,
    thirdCalibration: String = "11",
    fourthCalibration: String = "11 mkPa",
    thirdweatherElement: String = "uv index",
    fourthweatherElement: String = "pressure",

) {
    Column(modifier = Modifier.fillMaxHeight()) {
        weatherdetailsTopappbar(
            titleContentColor = titleContentColor,
            containerColor = containerColor,
            titleText = titleText,
            onClick = onClick,
            iconColor = iconColor,
            clickable = clickable,
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
            text = datetext,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onPrimary,
        )
        circleddotandweatherdetails()
        Text(
            text = "Todays Details",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, bottom = 10.dp),
            color = MaterialTheme.colorScheme.onPrimary,
        )
        modulatedfourbottomicon(
            firstIcon = firstIcon,
            secondIcon = secondIcon,
            thirdIcon = thirdIcon,
            fourthIcon = fourthIcon,
            firstweatherElement = firstweatherElement,
            secondweatherElement = secondweatherElement,
            thirdweatherElement = thirdweatherElement,
            fourthweatherElement = fourthweatherElement,
            firstCalibration = firstCalibration,
            secondCalibration = secondCalibration,
            thirdCalibration = thirdCalibration,
            fourthCalibration = fourthCalibration,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 13.dp, end = 13.dp),
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
    device = Devices.PIXEL_7_PRO,

)
@Composable
fun Weathertextpreview() {
    SafeBuddyTheme {
        // Text("i am ")
        Column() {
            weatherscrentest()
        }
    }
}
