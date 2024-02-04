// ktlint-disable filename
package com.example.hazardhunt.homescreen.presentation
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hazardhunt.R
import com.example.hazardhunt.ui.theme.HazardHuntTheme

@Composable
fun temperatureandWeatherImage() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        SuperScriptText(
            normalText = "35",
            normalTextFontSize = MaterialTheme.typography.displayLarge.fontSize,
            superText = "°",
            superTextFontSize = MaterialTheme.typography.displayLarge.fontSize,
            superTextFontWeight = FontWeight.Thin,
            baselineShift = BaselineShift.Superscript,
        )

        Image(
            painter = painterResource(id = R.drawable.sun_and_cloud),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.padding(top = 8.dp, end = 5.dp)
                .height(77.95.dp)
                .width(80.dp),
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
fun tempPreview() {
    HazardHuntTheme {
        temperatureandWeatherImage()
    }
}