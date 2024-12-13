// ktlint-disable filename
package com.hazardhunt.safebuddy.weatherdatailsscreen.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.core.view.theme.SafeBuddyTheme

@Composable
fun weatherdetailsSecrren() {
    //
    val name = ""
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
            weatherdetailsSecrren()
        }
    }
}
