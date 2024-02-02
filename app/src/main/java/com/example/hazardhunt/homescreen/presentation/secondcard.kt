// ktlint-disable filename
package com.example.hazardhunt.homescreen.presentation
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hazardhunt.R
import com.example.hazardhunt.ui.theme.HazardHuntTheme

@Composable
fun temperatureandWeatherImage() {
    Row {
        Text(
            text = buildAnnotatedString {
                append("30")
            },
        )

        Image(
            painter = painterResource(id = R.drawable.sun_and_cloud),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(50.19.dp)
                .width(50.dp),
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
