// ktlint-disable filename
package com.example.hazardhunt.weatherdatailsscreen.presentation

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hazardhunt.R
import com.example.hazardhunt.ui.theme.HazardHuntTheme

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
) {
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
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 13.dp, end = 13.dp),
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
fun weathertextpreview() {
    HazardHuntTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
        ) {
            weatherscrentest()
        }
    }
}
