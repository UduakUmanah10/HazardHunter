// ktlint-disable filename
package com.example.hazardhunt.weatherdatailsscreen.presentation

import android.content.res.Configuration
import androidx.annotation.ColorInt
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hazardhunt.homescreen.presentation.subscript
import com.example.hazardhunt.ui.theme.HazardHuntTheme

@Composable
fun weatherdetailsbox(
    @ColorInt backgroundColor: Color = Color.Blue,
    temperatureValue: String = "30",
    subScript: String = "°",
    text: String = "Hottest Day of the Week",

) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .height(70.dp).padding(start = 7.dp)
            .width(256.dp).background(backgroundColor),

    ) {
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .wrapContentHeight()
                .width(200.dp),
        ) {
            subscript(
                normalTextFontSize = MaterialTheme.typography.titleMedium.fontSize,
                normalText = temperatureValue,
                superTextFontSize = MaterialTheme.typography.titleMedium.fontSize,
                superTextFontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Superscript,
                superText = subScript,
            )

            // Text("30")
            Text(
                modifier = Modifier
                    .padding(start = 3.dp, bottom = 3.dp)
                    .fillMaxWidth().wrapContentHeight(),

                // i am adding you
                text = text,
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onPrimary,
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
fun weatherdetailsboxpreview() {
    HazardHuntTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
        ) {
            weatherdetailsbox()
        }
    }
}
