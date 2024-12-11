// ktlint-disable filename
package com.hazardhunt.safebuddy.homescreen.presentation

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hazardhunt.safebuddy.R
import com.hazardhunt.safebuddy.ui.theme.HazardHuntTheme


@Composable
fun addSurface(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int = R.drawable.add,
) {
    Surface(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier.wrapContentSize(),
            // horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "add image",
                tint = Color.Black,
                modifier = Modifier
                    .size(10.dp),
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
fun AddSurfacePreview() {
    HazardHuntTheme {
        addSurface(
            modifier = Modifier
                .height(20.dp)
                .width(20.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface)
                .border(3.dp, Color.Red, CircleShape)
                .padding(end = 1.dp, bottom = 3.dp)
                .size(10.dp),
        )
    }
}
