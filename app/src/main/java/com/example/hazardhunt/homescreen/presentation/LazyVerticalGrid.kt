package com.example.hazardhunt.homescreen.presentation

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.abs

data class Features(
    val title: String,
    @DrawableRes
    val icon: Int,
    val color: Color,
    val lightcolor: Color,
    val mediumcolor: Color,
)

@Composable
fun lazyVerticalGrid(features: List<Features>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            "Features",
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(15.dp),
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxHeight(),
            contentPadding = PaddingValues(
                start = 7.5.dp,
                end = 7.5.dp,
                bottom = 100.dp,
            ),
        ) {
            items(features.size) {
                GridFeature(features = features[it])
            }
        }
    }
}

@Composable
fun GridFeature(features: Features) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(features.color),
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        val mediumColouredPoint1 = Offset(0f, height * 0.3f)
        val mediumColouredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColouredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColouredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColouredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColouredPoint1.x, mediumColouredPoint1.y)
            standardQuadtTo(mediumColouredPoint1, mediumColouredPoint2)
            standardQuadtTo(mediumColouredPoint2, mediumColouredPoint3)
            standardQuadtTo(mediumColouredPoint3, mediumColouredPoint4)
            standardQuadtTo(mediumColouredPoint4, mediumColouredPoint5)

            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.035f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat())

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadtTo(lightPoint1, lightPoint2)
            standardQuadtTo(lightPoint2, lightPoint3)
            standardQuadtTo(lightPoint3, lightPoint4)
            standardQuadtTo(lightPoint4, lightPoint5)

            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        Canvas(modifier = Modifier.fillMaxSize()) {
            drawPath(
                path = mediumColoredPath,
                color = features.mediumcolor,
            )
            drawPath(
                path = lightColoredPath,
                color = features.lightcolor,
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
        ) {
            Text(
                text = features.title,
                style = MaterialTheme.typography.bodySmall,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart),
            )
            Icon(
                painter = painterResource(
                    id = features.icon,
                ),
                contentDescription = features.title,
                modifier = Modifier.align(Alignment.BottomStart),
            )
            Text(
                text = "start",
                color = MaterialTheme.colorScheme.inversePrimary,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {}
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.background)
                    .padding(vertical = 6.dp, horizontal = 15.dp),

            )
        }
    }
}

fun Path.standardQuadtTo(from: Offset, to: Offset) {
    quadraticBezierTo(
        from.x,
        from.y,
        abs(from.x + to.x) / 2f,
        abs(from.y + to.y) / 2f,
    )
}
