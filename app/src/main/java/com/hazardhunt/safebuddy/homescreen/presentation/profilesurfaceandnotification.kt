// ktlint-disable filename
package com.hazardhunt.safebuddy.homescreen.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hazardhunt.safebuddy.R
import com.hazardhunt.safebuddy.ui.theme.HazardHuntTheme

@Composable
fun profileSurfaceandNotification(
    notificationSurfaceHeight: Dp,
    notificationSurfaceWidth: Dp,
    notificationSurfaceShape: Shape,
    notifiactionBackgroundcolor: Color,
    animatedBorderHeight: Dp,
    animatedBorderWidth: Dp,
    animatedSurfaceShape: Shape,
    animatedBackgroundColor: Color,
    notificationModifier: Modifier = Modifier,
    rowModifier: Modifier = Modifier,

) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = rowModifier,

    ) {
        notoficationIcon(
            modifier = notificationModifier,
            surfaceHeight = notificationSurfaceHeight,
            surfaceWidth = notificationSurfaceWidth,
            surfaceShape = notificationSurfaceShape,
            backgroundColor = notifiactionBackgroundcolor,
            painterResource = R.drawable.notifications,
        )
        AnimatedBorderCard {
            profileImageSurface(
                surfaceHeight = animatedBorderHeight,
                surfaceWidth = animatedBorderWidth,
                surfaceShape = animatedSurfaceShape,
                backgroundColor = animatedBackgroundColor,
                painterResource = R.drawable.profileimage,
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
fun profilesurfaceandnotification() {
    HazardHuntTheme {
        profileSurfaceandNotification(
            notificationModifier = Modifier.padding(10.dp),
            rowModifier = Modifier.padding(10.dp).width(70.dp),
            notificationSurfaceHeight = 20.dp,
            notificationSurfaceWidth = 20.dp,
            notificationSurfaceShape = CircleShape,
            notifiactionBackgroundcolor = Color.Transparent,
            animatedBorderHeight = 30.dp,
            animatedBorderWidth = 30.dp,
            animatedSurfaceShape = CircleShape,
            animatedBackgroundColor = Color.Transparent,

        )
    }
}
