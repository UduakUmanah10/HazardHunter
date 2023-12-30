// ktlint-disable filename
package com.example.hazardhunt.homescreen.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun profileImageSurface(
    surfaceHeight: Dp,
    surfaceWidth: Dp,
    surfaceShape: Shape,
    backgroundColor: Color,
    @DrawableRes painterResource: Int,
) {
    Surface(
        modifier = Modifier
            .height(surfaceHeight) // 30.dp
            .width(surfaceWidth) // 30.dp
            .clip(surfaceShape) // RoundedCornerShape(10.dp)
            .background(backgroundColor), // MaterialTheme.colorScheme.surface
    ) {
        Box {
            Image(
                painter = painterResource(id = painterResource),
                contentDescription = "",
            )

            addSurface(
                modifier = Modifier
                    .padding(start = 3.dp, top = 3.dp, end = 3.dp, bottom = 3.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surface)
                    .border(1.dp, Color.Red, CircleShape)
                    .size(7.dp)
                    .align(Alignment.BottomEnd),
            )
        }
    }
}
