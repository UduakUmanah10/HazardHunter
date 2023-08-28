package com.example.hazardhunt.homescreen.presentation

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
import com.example.hazardhunt.R
import com.example.hazardhunt.ui.theme.HazardHuntTheme

typealias PAGER = Int
const val PAGER_COUNT = 4

@DrawableRes val nam: Int = R.drawable.safetypager

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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),

    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .background(MaterialTheme.colorScheme.error)
                .basicMarquee(
                    iterations = Int.MAX_VALUE,
                    delayMillis = 0,
                    initialDelayMillis = 0,
                    velocity = 100.dp,

                ),

            color = MaterialTheme.colorScheme.inverseSurface,
            text = " Safety Alert oil spill detected at oml 25............. ",
        )
        pagerScreen()
        lazyVerticalGrid(
            features = listOf(
                Features(
                    title = "Sensors",
                    icon = R.drawable.person,
                    MaterialTheme.colorScheme.inversePrimary,
                    MaterialTheme.colorScheme.secondaryContainer,
                    MaterialTheme.colorScheme.onPrimary,

                ),
                Features(
                    title = "Sensors",
                    icon = R.drawable.person,
                    MaterialTheme.colorScheme.inversePrimary,
                    MaterialTheme.colorScheme.secondaryContainer,
                    MaterialTheme.colorScheme.onPrimary,

                ),
                Features(
                    title = "Sensors",
                    icon = R.drawable.person,
                    MaterialTheme.colorScheme.inversePrimary,
                    MaterialTheme.colorScheme.secondaryContainer,
                    MaterialTheme.colorScheme.onPrimary,

                ),
                Features(
                    title = "Sensors",
                    icon = R.drawable.person,
                    MaterialTheme.colorScheme.inversePrimary,
                    MaterialTheme.colorScheme.secondaryContainer,
                    MaterialTheme.colorScheme.onPrimary,

                ),
                Features(
                    title = "Sensors",
                    icon = R.drawable.person,
                    MaterialTheme.colorScheme.inversePrimary,
                    MaterialTheme.colorScheme.secondaryContainer,
                    MaterialTheme.colorScheme.onPrimary,

                ),
            ),
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
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
