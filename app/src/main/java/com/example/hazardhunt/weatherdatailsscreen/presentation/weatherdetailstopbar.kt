// ktlint-disable filename
package com.example.hazardhunt.weatherdatailsscreen.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hazardhunt.R
import com.example.hazardhunt.core.CustomCenterTopAppbar
import com.example.hazardhunt.ui.theme.HazardHuntTheme

@Composable
fun weatherdetailsTopappbar() {
    CustomCenterTopAppbar(
        titleContentColor = MaterialTheme.colorScheme.onSecondary,
        containerColor = MaterialTheme.colorScheme.outline,
        scrollContainerColor = MaterialTheme.colorScheme.error,
        title = "Today",
        // navIcon = R.drawable.mail,
        onNavigationIconClicked = {},
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.chevronleft),
                contentDescription = stringResource(R.string.Password),
                tint = MaterialTheme.colorScheme.secondaryContainer,
                modifier = Modifier.size(80.dp),
            )
        },

        actionIcon = {},
        actionIconAction = {},
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
fun weathecentertopbarpreview() {
    HazardHuntTheme {
        weatherdetailsTopappbar()
    }
}
