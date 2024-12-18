// ktlint-disable filename
package com.hazardhunt.safebuddy.homescreen.presentation
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.view.theme.SafeBuddyTheme

@Composable
fun weathercard() {
    Card(
        modifier = Modifier
            .padding(
                start = 15.dp,
                end =
                15.dp,
                top = 10.dp,
                bottom = 5.dp,
            ),

        shape = RoundedCornerShape(15.dp),

    ) {
        Column(
            modifier = Modifier.wrapContentSize()
                .padding(16.dp),
        ) {
            temperatureandWeatherImage()
            weathertextComposable(
                locationText = "Surulere Lagos",
                coordinateText = "South West Nigeria",
            )
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
    SafeBuddyTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
        ) {
            weathercard()
        }
    }
}
