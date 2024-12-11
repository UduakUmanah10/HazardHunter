// ktlint-disable filename
package com.hazardhunt.safebuddy.weatherdatailsscreen.presentation

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
import com.hazardhunt.safebuddy.R
import com.hazardhunt.safebuddy.ui.theme.HazardHuntTheme
import com.hazardhunt.safebuddy.ui.theme.circledot
import com.hazardhunt.safebuddy.ui.theme.first
import com.hazardhunt.safebuddy.ui.theme.fourth
import com.hazardhunt.safebuddy.ui.theme.second
import com.hazardhunt.safebuddy.ui.theme.third

val item1: List<Weatherdetails> = arrayListOf(
    Weatherdetails("Morning", R.drawable.sun_and_cloud, "30", "warmest day of the week", first),
    Weatherdetails("Afternoon", R.drawable.clearsky, "30", "turning cloudy and windy", second),
    Weatherdetails("Evening", R.drawable.moonandrain, "30", "wind light and chance of rain", third),
    Weatherdetails("Night", R.drawable.halfmoon, "30", "chance of heavy rain", fourth),
)

@Composable
fun circleddotandweatherdetails(

    dottedlinecolor: Color = circledot,
    circlesurfaceColor: Color = circledot,
    dotanddashedlineModifier: Modifier = Modifier.padding(top = 29.dp, start = 20.dp),
    weatherdata: List<Weatherdetails> = item1,

    ) {
    Row(modifier = Modifier.fillMaxWidth()) {
        dotanddashedline(
            dottedlineColor = dottedlinecolor,
            circleColor = circlesurfaceColor,
            modifier = dotanddashedlineModifier,
        )
        refactoredWeatherdetails(
            modifier = Modifier
                .width(380.dp)
                .padding(bottom = 40.dp),
            items = weatherdata,
        )

        // new(
        //   modifier = Modifier.width(380.dp)
        //     .padding(bottom = 40.dp, start = 5.dp),
        // columModifier = Modifier
        //     .fillMaxSize()
        //   .fillMaxWidth(),

        //  backgroundColor = weatherinfobackgrounColor,
        //  subScript = subscriptValue,
        //   temperatureValue = "30",
        //  timeoftheDay = "Afternoon",
        //   imageComponent = R.drawable.sun_and_cloud,
        // )
    }
}

@Preview(
    name = "Day mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
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
