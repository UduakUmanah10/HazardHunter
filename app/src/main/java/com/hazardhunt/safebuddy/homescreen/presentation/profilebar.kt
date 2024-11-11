// ktlint-disable filename
package com.hazardhunt.safebuddy.homescreen.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hazardhunt.safebuddy.ui.theme.HazardHuntTheme

@Composable
fun profileBar(
    notificationModifier: Modifier,
    rowModifier: Modifier = Modifier,
    notificationSurfaceHeight: Dp,
    notificationSurfaceWidth: Dp,
    notificationSurfaceShape: Shape,
    notifiactionBackgroundcolor: Color,
    animatedBorderHeight: Dp,
    animatedBorderWidth: Dp,
    animatedSurfaceShape: Shape,
    animatedBackgroundColor: Color,

) {
    Row(
        modifier = Modifier.padding(start = 17.dp, end = 17.dp).height(80.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        profilebarText(
            columModifier = Modifier
                .padding()
                .height(70.dp)
                .wrapContentSize(),
            upperText = "Hi Temi !",
            upperTextModifier = Modifier,
            upperTextFontWeight = FontWeight.ExtraBold,
            upperTextStyle = MaterialTheme.typography.titleMedium,
            upperTextColor = MaterialTheme.colorScheme.secondaryContainer,
            lowerText = "Good Morning",
            lowerTextModifier = Modifier,
            lowerTextFontWeight = FontWeight.Bold,
            lowerTextColor = MaterialTheme.colorScheme.secondaryContainer,
            lowerTextStyle = MaterialTheme.typography.headlineMedium,

        )

        profileSurfaceandNotification(
            notificationModifier = notificationModifier,
            rowModifier = rowModifier,
            notificationSurfaceHeight = notificationSurfaceHeight,
            notificationSurfaceWidth = notificationSurfaceWidth,
            notificationSurfaceShape = notificationSurfaceShape,
            notifiactionBackgroundcolor = notifiactionBackgroundcolor,
            animatedBorderHeight = animatedBorderHeight,
            animatedBorderWidth = animatedBorderWidth,
            animatedSurfaceShape = animatedSurfaceShape,
            animatedBackgroundColor = animatedBackgroundColor,

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
fun ProfilebarPreview() {
    HazardHuntTheme {
        profileBar(
            notificationModifier = Modifier.padding(7.dp),
            rowModifier = Modifier.padding(10.dp).width(90.dp),
            notificationSurfaceHeight = 30.dp,
            notificationSurfaceWidth = 20.dp,
            notificationSurfaceShape = RoundedCornerShape(10.dp),
            notifiactionBackgroundcolor = Color.Transparent,
            animatedBorderHeight = 30.dp,
            animatedBorderWidth = 30.dp,
            animatedSurfaceShape = CircleShape,
            animatedBackgroundColor = Color.Transparent,
        )
    }
}
