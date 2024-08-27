// ktlint-disable filename
package com.hazardhunt.safebuddy.settingsscreen.presentation.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hazardhunt.safebuddy.R
import com.hazardhunt.safebuddy.homescreen.presentation.AnimatedBorderCard
import com.hazardhunt.safebuddy.homescreen.presentation.profileImageSurface
import com.hazardhunt.safebuddy.ui.theme.HazardHuntTheme

@Composable
fun surface(
    surfaceheights: Dp = 100.dp,
    surfacewidth: Dp = 100.dp,
    isimageUploaded: Boolean = false,
) {
    Box(
        modifier = Modifier
            .height(100.dp)
            .width(100.dp).padding(2.dp, bottom = 7.dp),
    ) {
        AnimatedBorderCard(animate = false, unanimatedBorderWidth = 2.dp) {
            profileImageSurface(
                surfaceHeight = 100.dp,
                surfaceWidth = 100.dp,
                surfaceShape = CircleShape,
                backgroundColor = MaterialTheme.colorScheme.surface,
                painterResource = R.drawable.profileimage,
                isimageuploaded = isimageUploaded,
            )
        }

        Iconandsurface(
            modifier = Modifier
                .height(30.dp)
                .width(30.dp).align(Alignment.BottomEnd),
            surfaceIcon = R.drawable.edit,
            surfacetintColor = Color.Blue,
            surfacecolor = Color.Red,
            shape = CircleShape,
        )
//        Icon(
//            painter = painterResource(id = R.drawable.edit),
//            contentDescription = "",
//            tint = Color.Black,
//            modifier = Modifier
//                .padding(end = 3.dp, bottom = 15.dp)
//                .size(30.dp)
//                .align(Alignment.BottomEnd),
//        )
        //        Icon(
//            painter = painterResource(id = R.drawable.edit),
//            contentDescription = "",
//            tint = Color.Black,
//            modifier = Modifier
//                .padding(end = 3.dp, bottom = 15.dp)
//                .size(30.dp)
//                .align(Alignment.BottomEnd),
//        )
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
fun imagesurface() {
    HazardHuntTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
        ) {
            surface()
        }
    }
}
