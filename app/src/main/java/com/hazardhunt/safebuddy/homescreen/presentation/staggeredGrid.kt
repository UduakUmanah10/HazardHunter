// ktlint-disable filename
package com.hazardhunt.safebuddy.homescreen.presentation

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hazardhunt.safebuddy.ui.theme.HazardHuntTheme

const val FIRST_COLOUR = 0xFF6b1b0f
const val SECOND_COLOR = 0xFFa46b41
const val THIRD_COLOR = 0xFF333236
const val FOURTH_COLOR = 0xFFB19C83

data class ListItem(
    val height: Dp,
    val color: Color,
    val width: Dp,
)

val listofitem = listOf(
    ListItem(230.dp, Color(FIRST_COLOUR), 3.dp),
    ListItem(120.dp, Color(SECOND_COLOR), 3.dp),
    ListItem(230.dp, Color(THIRD_COLOR), 3.dp),
    ListItem(120.dp, Color(FOURTH_COLOR), 3.dp),
)

@Composable
fun RandomColorBox(item: ListItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(item.height)
            .clip(RoundedCornerShape(10.dp))
            .background(item.color),
    )
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
fun staggeredViewPreview() {
    HazardHuntTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
        ) {
            staggeredGrid()
        }
    }
}

@Composable
fun staggeredGrid() {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.wrapContentSize().padding(start = 6.dp, end = 6.dp),
        contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalItemSpacing = 10.dp,
    ) {
        items(listofitem.size) { index ->
            RandomColorBox(listofitem[index])
        }
    }
}
