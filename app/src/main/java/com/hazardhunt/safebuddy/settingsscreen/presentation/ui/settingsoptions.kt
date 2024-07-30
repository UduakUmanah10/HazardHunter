// ktlint-disable filename
package com.hazardhunt.safebuddy.settingsscreen.presentation.ui

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
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

data class Settings(
    @DrawableRes val icons: Int,
    val description: String,
    val routes: String,
    val surfacecolor: Color,
    val shouldbeenabled: Boolean,
)

val settingsList = listOf(
    Settings(
        icons = R.drawable.support,
        description = "Help and support",
        routes = "",
        surfacecolor = first_settings_item,
        shouldbeenabled = true,
    ),
    Settings(
        icons = R.drawable.star,
        description = "Rate safe buddy",
        routes = "",
        surfacecolor = second_settings_item,
        shouldbeenabled = true,
    ),
    Settings(
        icons = R.drawable.language,
        description = "Languages",
        routes = "",
        surfacecolor = fifth_settings_item,
        shouldbeenabled = true,
    ),
    Settings(
        icons = R.drawable.sync,
        description = "Sync database",
        routes = "",
        surfacecolor = third_settings_item,
        shouldbeenabled = true,
    ),
    Settings(
        icons = R.drawable.share,
        description = "Invite friends",
        routes = "",
        surfacecolor = fourth_settings_item,
        shouldbeenabled = true,
    ),
    Settings(
        icons = R.drawable.logout,
        description = " logout",
        routes = "",
        surfacecolor = fifth_settings_item,
        shouldbeenabled = true,
    ),
)

// the size of the icon is controlled by the padding on the ixon
@Composable
fun settingsoption(
    list: List<Settings> = settingsList,
    onSurfaceclicked: () -> Unit = {},
) {
    Surface(shape = RoundedCornerShape(15.dp), modifier = Modifier.padding(15.dp)) {
        Column {
            list.forEachIndexed { index, settings ->

                Individualsettingsitem(
                    surfaceIcon = settings.icons,
                    surfaceColor = settings.surfacecolor,
                    textDescription = settings.description,
                    showdivider = index < settingsList.size - 1,
                    onsurfaceClicked = onSurfaceclicked,
                    isclickenabled = settings.shouldbeenabled,
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
        settingsoption()
    }
}
