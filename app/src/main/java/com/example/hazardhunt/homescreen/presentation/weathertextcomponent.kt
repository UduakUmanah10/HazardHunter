// ktlint-disable filename
package com.example.hazardhunt.homescreen.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hazardhunt.ui.theme.HazardHuntTheme

@Composable
fun weathertextComposable(
    locationText: String = "Surulere Lagos",
    coordinateText: String = "South West Nigeria",
) {
    Text(
        text = locationText,
        style = MaterialTheme.typography.headlineMedium,

    )
    Text(
        text = coordinateText,
        style = MaterialTheme.typography.displaySmall,

    )
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
fun weathertextComponent() {
    HazardHuntTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
        ) {
            weathertextComposable()
        }
    }
}
