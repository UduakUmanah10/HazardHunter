// ktlint-disable filename
package com.example.hazardhunt.homescreen.presentation

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.example.hazardhunt.R
import com.example.hazardhunt.ui.theme.HazardHuntTheme

@Composable
fun addSurface() {
    Surface(
        modifier = Modifier
            .height(20.dp)
            .width(20.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surface)
            .border(3.dp, Color.Red, CircleShape),

    ) {
        Icon(
            painter = painterResource(id = R.drawable.add),
            contentDescription = "add image",
            tint = Color.Black,
            modifier = Modifier
                .padding(start = 3.dp, top = 3.dp, end = 3.dp, bottom = 3.dp)
                .size(2.dp)
                .clip(CircleShape),

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
fun AddSurfacePreview() {
    HazardHuntTheme {
        addSurface()
    }
}
