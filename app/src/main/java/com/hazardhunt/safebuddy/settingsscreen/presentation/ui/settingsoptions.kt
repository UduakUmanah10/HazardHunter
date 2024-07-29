// ktlint-disable filename
package com.hazardhunt.safebuddy.settingsscreen.presentation.ui

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hazardhunt.safebuddy.R
import com.hazardhunt.safebuddy.ui.theme.HazardHuntTheme
import com.hazardhunt.safebuddy.ui.theme.fifth_settings_item
import com.hazardhunt.safebuddy.ui.theme.first_settings_item
import com.hazardhunt.safebuddy.ui.theme.fourth_settings_item
import com.hazardhunt.safebuddy.ui.theme.second_settings_item
import com.hazardhunt.safebuddy.ui.theme.third_settings_item

data class Settings(@DrawableRes val icons: Int, val description: String, val routes: String, val color: Color)

val settingsList = listOf(
    Settings(icons = R.drawable.support, description = "Help and support", routes = "", color = first_settings_item),
    Settings(icons = R.drawable.star, description = "Rate safe buddy", routes = "", color = second_settings_item),
    Settings(icons = R.drawable.language, description = " logout", routes = "", color = fifth_settings_item),
    Settings(icons = R.drawable.sync, description = "Sync database", routes = "", color = third_settings_item),
    Settings(icons = R.drawable.share, description = "Invite friends", routes = "", color = fourth_settings_item),
    Settings(icons = R.drawable.logout, description = " logout", routes = "", color = fifth_settings_item),
)

@Composable
fun settingsoption() {
    Surface(shape = RoundedCornerShape(15.dp), modifier = Modifier.padding(20.dp)) {
        Column {
            settingsList.forEachIndexed { index, settings ->

                Individualsettingsitem(
                    surfaceIcon = settings.icons,
                    surfaceColor = settings.color,
                    textDescription = settings.description,
                    showdivider = index < settingsList.size - 1,
                )
            }
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
fun settingsOptionspreview() {
    HazardHuntTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
        ) {
            settingsoption()
        }
    }
}
