// ktlint-disable filename
package com.hazardhunt.safebuddy.homescreen.presentation

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.core.view.theme.SafeBuddyTheme
import com.hazardhunt.safebuddy.R

@Composable
fun notoficationIcon(
    modifier: Modifier = Modifier,
    surfaceHeight: Dp,
    surfaceWidth: Dp,
    surfaceShape: Shape,
    backgroundColor: Color,
    @DrawableRes painterResource: Int,
) {
    Surface(
        color = Color.Transparent,
        modifier = Modifier
            .height(surfaceHeight) // 30.dp
            .width(surfaceWidth) // 30.dp
            .clip(surfaceShape) // RoundedCornerShape(10.dp)
            .background(backgroundColor), // MaterialTheme.colorScheme.surface
    ) {
        Box(modifier = Modifier.height(100.dp).width(70.dp)) {
            Icon(
                tint = Color.Black,
                modifier = Modifier.height(50.dp).width(50.dp),
                painter = painterResource(id = painterResource),
                contentDescription = "dashboard",
            )

            notificationIcon(
                modifier = Modifier
                    .padding(start = 3.dp, top = 7.dp, end = 3.dp, bottom = 3.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surface)
                    .border(1.dp, Color.Red, CircleShape)
                    .size(7.dp)
                    .align(Alignment.TopEnd),
            )
        }
    }
}

@Composable
private fun notificationIcon(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        color = Color.Red,
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                color = Color.Black,
                text = "12",
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
fun NotificationIcon() {
    SafeBuddyTheme {
        notoficationIcon(
            surfaceHeight = 30.dp,
            surfaceWidth = 20.dp,
            surfaceShape = RoundedCornerShape(10.dp),
            backgroundColor = Color.Transparent,
            painterResource = R.drawable.notifications,
        )
    }
}
