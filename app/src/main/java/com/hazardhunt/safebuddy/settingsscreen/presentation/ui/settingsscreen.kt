package com.hazardhunt.safebuddy.settingsscreen.presentation.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hazardhunt.safebuddy.R
import com.hazardhunt.safebuddy.ui.theme.HazardHuntTheme

/**
 * this would also have a motion layout
* the logic behind this uio component is the ere would be number of horizontal component drawn
* and the number of lines to be bottom  horizontal line to be drawn would depend on the the amount of icons to
* be displayed on the screen.
* a list of data classes would be iterated over and this would be used to determine the number of lines
* that would be drawn horizontally
* */

@Composable
fun settingsscreen() {
    Row(
        verticalAlignment = Alignment.CenterVertically,

        modifier = Modifier.fillMaxWidth().padding(start = 20.dp),
    ) {
        Icon(painter = painterResource(id = R.drawable.arrow_circle), contentDescription = "", tint = Color.Blue)
        Text(text = " settings", color = Color.White, modifier = Modifier.padding(15.dp))
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
fun iconandtext() {
    HazardHuntTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
        ) {
            settingsscreen()
        }
    }
}
