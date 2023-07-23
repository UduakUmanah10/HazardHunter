package com.example.hazardhunt.homescreen.presentation

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import com.example.hazardhunt.ui.theme.HazardHuntTheme
import kotlin.math.absoluteValue

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
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun pagerScreen() {
    val pagerState = rememberPagerState(pageCount = {
        4
    })
    HorizontalPager(state = pagerState) { page ->
        Card(
            Modifier.height(200.dp)
                .width(400.dp).padding(10.dp)
                .graphicsLayer {
                    // Calculate the absolute offset for the current page from the
                    // scroll position. We use the absolute value which allows us to mirror
                    // any effects for both directions
                    val pageOffset = (
                        (pagerState.currentPage - page) + pagerState
                            .currentPageOffsetFraction
                        ).absoluteValue

                    // We animate the alpha, between 50% and 100%
                    alpha = lerp(
                        start = 5.dp,
                        stop = 1.dp,
                        fraction = 1f - pageOffset
                            .coerceIn(0f, 1f)
                            .toFloat(),
                    ).value
                },
        ) {
            Text("first")
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
private fun LoginPreview() {
    HazardHuntTheme {
        HomeScreen()
    }
}
