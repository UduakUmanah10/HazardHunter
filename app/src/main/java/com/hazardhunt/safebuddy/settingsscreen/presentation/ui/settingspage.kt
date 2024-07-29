// ktlint-disable filename
package com.hazardhunt.safebuddy.settingsscreen.presentation.ui
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hazardhunt.safebuddy.R
import com.hazardhunt.safebuddy.core.CustomCenterTopAppbar
import com.hazardhunt.safebuddy.ui.theme.HazardHuntTheme

@Composable
fun settingspage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CustomCenterTopAppbar(
            containerColor = Color.Transparent,

            modifier = Modifier.padding(bottom = 20.dp),

            titleContentColor = MaterialTheme.colorScheme.onSecondary,

            scrollContainerColor = MaterialTheme.colorScheme.error,
            title = "Settings",
            // navIcon = R.drawable.mail,
            onNavigationIconClicked = {},
            navigationIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.chevronleft),
                    contentDescription = stringResource(R.string.Password),
                    tint = MaterialTheme.colorScheme.secondaryContainer,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.centerBarIcon)),
                )
            },
            actionIcon = {
            },
            actionIconAction = {},
        )
        surface()

        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Uduak Umanah", style = MaterialTheme.typography.headlineLarge)
            Text(text = "UduakUmanah10@gmail.com", style = MaterialTheme.typography.bodyMedium)
            Text(
                text = "Registered at Feb 21 2024",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 7.dp),
            )
        }
        settingsoption()

        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Version 3.1.0 (10)",
                style = MaterialTheme.typography.titleSmall,
                color = Color.White,
                modifier = Modifier.padding(top = 20.dp),
            )
            Text(text = "By Uduak Unmanah", style = MaterialTheme.typography.titleSmall, color = Color.White)
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
fun settingspagepreview() {
    HazardHuntTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
        ) {
            settingspage()
        }
    }
}
