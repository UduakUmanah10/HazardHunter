// ktlint-disable filename
package com.hazardhunt.safebuddy.homescreen.presentation

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hazardhunt.safebuddy.R
import com.hazardhunt.safebuddy.ui.theme.HazardHuntTheme

typealias PAGER = Int
const val PAGER_COUNT = 4

@DrawableRes val nam: Int = R.drawable.safetyofficer

@Composable
fun CardWithMultipleViews(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier,

) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp,
        ),

    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .width(400.dp),
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth(),
            )

            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.CenterStart,
            ) {
                Text(text = "Goodmorning")
            }
        }
    }
}

@Composable
fun imagec() {
    Image(
        painter = painterResource(id = R.drawable.sun_and_cloud),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(50.19.dp)
            .width(50.dp),
    )
}

@Composable
fun HomeScreen() {
    Scaffold(modifier = Modifier.background(MaterialTheme.colorScheme.onBackground)) {
            padding ->

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .statusBarsPadding()
                .background(MaterialTheme.colorScheme.onBackground),

        ) {
            profileBar(
                notificationModifier = Modifier.padding(7.dp),
                rowModifier = Modifier
                    .padding()
                    .width(90.dp)
                    .height(50.dp),
                notificationSurfaceHeight = 30.dp,
                notificationSurfaceWidth = 30.dp,
                notificationSurfaceShape = RoundedCornerShape(10.dp),
                notifiactionBackgroundcolor = MaterialTheme.colorScheme.onBackground,
                animatedBorderHeight = 40.dp,
                animatedBorderWidth = 40.dp,
                animatedSurfaceShape = CircleShape,
                animatedBackgroundColor = Color.Transparent,
            )
            // pagerScreen()
            weathercard()
            staggeredGrid()
        }
    }
}

@Composable
fun pagerScreen() {
    val pageCount = PAGER_COUNT
    val pagerState = rememberPagerState(pageCount = {
        4
    })
    HorizontalPager(state = pagerState) { page ->

        CardWithMultipleViews(
            painter = painterResource(id = nam),
            contentDescription = "********",
            title = ">>>>>>",
            modifier = Modifier.padding(10.dp),
        )
    }

    Row(
        Modifier
            .height(20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        repeat(pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
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
fun LoginPreview() {
    HazardHuntTheme {
        HomeScreen()
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
fun LoginPre() {
    HazardHuntTheme {
        imagec()
    }
}
