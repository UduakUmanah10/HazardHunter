// ktlint-disable filename
package com.hazardhunt.safebuddy.weatherdatailsscreen.presentation

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hazardhunt.safebuddy.R
import com.hazardhunt.safebuddy.ui.theme.HazardHuntTheme

@Composable
fun multipleRow(
    @DrawableRes firstIcon: Int = R.drawable.humidity,
    @DrawableRes secondIcon: Int = R.drawable.humidity,
    firstCalibration: String = "E 8 kmh",
    secondCalibration: String = "E 8 kmh",
    firstweatherElement: String = "wind",
    secondweatherElement: String = "wind",
    modifier: Modifier = Modifier.fillMaxWidth().padding(10.dp),
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        iconandvalue(
            icon = firstIcon,
            calibration = firstCalibration,
            element = firstweatherElement,

        )

        iconandvalue(
            icon = secondIcon,
            calibration = secondCalibration,
            element = secondweatherElement,
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
fun fouriconpreview() {
    HazardHuntTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
        ) {
            //       iconandvalue()
            multipleRow()
        }
    }
}
