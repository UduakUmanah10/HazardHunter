// ktlint-disable filename
package com.hazardhunt.safebuddy.settingsscreen.presentation.ui

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material3.HorizontalDivider
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
fun Individualsettingsitem() {
    Column() {
        IndividualsettingComponant()
        HorizontalDivider(thickness = 2.dp)
    }
}

@Composable
fun IndividualsettingComponant(
    @DrawableRes surfaceIcon: Int = R.drawable.arrow_circle,
    surfaceColor: Color = Color.Blue,
    text: String = "settings",
    onClickEnabled: Boolean = true,
    onIconClicked: () -> Unit = {},
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,

        modifier = Modifier.wrapContentWidth()
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
    ) {
        Iconandsurface(
            surfaceIcon = surfaceIcon,
            surfacetintColor = surfaceColor,

        )
        Text(text = text, color = Color.White, modifier = Modifier.padding(35.dp))
        Icon(
            painter = painterResource(id = R.drawable.chevron_right),
            contentDescription = "",
            tint = Color.Blue,
            modifier = Modifier
                .padding(3.dp)
                .size(30.dp).clickable(onClick = onIconClicked, enabled = onClickEnabled),
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Iconandsurface(
    @DrawableRes surfaceIcon: Int = R.drawable.arrow_circle,
    surfacetintColor: Color = Color.Blue,
) {
    Surface(
        modifier = Modifier
            .height(37.dp)
            .width(37.dp),
        color = Color.Red,
        shape = RoundedCornerShape(5.dp),
    ) {
        Icon(
            painter = painterResource(id = surfaceIcon),
            contentDescription = "",
            tint = surfacetintColor,
            modifier = Modifier.padding(3.dp),
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
fun iconandtext() {
    HazardHuntTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
        ) {
            Individualsettingsitem()
        }
    }
}
