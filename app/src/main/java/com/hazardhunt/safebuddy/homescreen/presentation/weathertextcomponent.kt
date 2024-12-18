// ktlint-disable filename
package com.hazardhunt.safebuddy.homescreen.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.view.theme.SafeBuddyTheme
import com.hazardhunt.safebuddy.R

@Composable
fun weathertextComposable(
    locationText: String = "Surulere Lagos",
    coordinateText: String = "South West Nigeria",
) {
    Column(
        modifier = Modifier.padding(4.dp),
        // horizontalAlignment = Alignment.CenterHorizontally,
        // verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = locationText,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onPrimary,
            )
            Icon(
                modifier = Modifier
                    .size(30.dp)
                    .padding(vertical = 5.dp),
                painter = painterResource(id = R.drawable.location),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onPrimary,
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Text(
                text = coordinateText,
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onPrimary,

            )
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.drop_down_arrow),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onPrimary,
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
fun weathertextComponent() {
    SafeBuddyTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
        ) {
            weathertextComposable()
        }
    }
}
