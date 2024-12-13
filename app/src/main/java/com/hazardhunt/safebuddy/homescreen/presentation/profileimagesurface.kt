// ktlint-disable filename
package com.hazardhunt.safebuddy.homescreen.presentation

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.core.view.theme.SafeBuddyTheme
import com.hazardhunt.safebuddy.R

@Composable
fun profileImageSurface(
    surfaceHeight: Dp,
    surfaceWidth: Dp,
    surfaceShape: Shape,
    backgroundColor: Color,
    isimageuploaded: Boolean = false,
    @DrawableRes painterResource: Int,
) {
    Surface(

        modifier = Modifier
            .height(surfaceHeight) // 30.dp
            .width(surfaceWidth) // 30.dp
            .clip(surfaceShape), // RoundedCornerShape(10.dp)
        // MaterialTheme.colorScheme.surface,

    ) {
        Box(modifier = Modifier.background(Color.Transparent)) {
            if (isimageuploaded) {
                Image(
                    painter = painterResource(id = R.drawable.profileimage),
                    contentDescription = "",
                )
            } else {
                Text(
                    text = "UU",
                    modifier = Modifier.align(Alignment.Center),
                    style = MaterialTheme.typography.titleMedium,
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
fun profileimage() {
    SafeBuddyTheme {
    }
}
