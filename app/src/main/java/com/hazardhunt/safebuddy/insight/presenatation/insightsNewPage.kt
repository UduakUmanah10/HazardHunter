// ktlint-disable filename
package com.hazardhunt.safebuddy.insight.presenatation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.piechart.PieChartData
import com.hazardhunt.safebuddy.R
import com.hazardhunt.safebuddy.core.CustomCenterTopAppbar
import com.hazardhunt.safebuddy.ui.theme.HazardHuntTheme


@Composable
fun InsightsScreen(onNavigationIconClicked: () -> Unit) {
    val pieChartContent = listOf(
        PieChartData.Slice(FIRST_SLICE_VALUE, MaterialTheme.colorScheme.onSecondary),
        PieChartData.Slice(SECOND_SLICE_VALUE, MaterialTheme.colorScheme.error),
        PieChartData.Slice(THIRD_SLICE_VALUE, MaterialTheme.colorScheme.primary),
    )
    val bar = listOf(
        BarChartData.Bar(label = "J", value = 100f, color = MaterialTheme.colorScheme.onSecondary),
        BarChartData.Bar(label = "F", value = 200f, color = MaterialTheme.colorScheme.onSecondary),
        BarChartData.Bar(label = "M", value = 300f, color = MaterialTheme.colorScheme.onSecondary),
        BarChartData.Bar(label = "A", value = 400f, color = MaterialTheme.colorScheme.onSecondary),
        BarChartData.Bar(label = "My", value = 100f, color = MaterialTheme.colorScheme.onSecondary),
        BarChartData.Bar(label = "Ju", value = 200f, color = MaterialTheme.colorScheme.onSecondary),
        BarChartData.Bar(label = "Jl", value = 300f, color = MaterialTheme.colorScheme.onSecondary),
        BarChartData.Bar(label = "A", value = 400f, color = MaterialTheme.colorScheme.onSecondary),
        BarChartData.Bar(label = "S", value = 400f, color = MaterialTheme.colorScheme.onSecondary),
        BarChartData.Bar(label = "O", value = 100f, color = MaterialTheme.colorScheme.onSecondary),
        BarChartData.Bar(label = "N", value = 200f, color = MaterialTheme.colorScheme.onSecondary),
        BarChartData.Bar(label = "D", value = 300f, color = MaterialTheme.colorScheme.onSecondary),
    )
    InsightsPage(barComponent = bar, pieChartContent, onNavigationIconClicked)
}

@Composable
fun InsightsPage(
    barComponent: List<BarChartData.Bar>,
    pieChartContent: List<PieChartData.Slice>,
    onNavigationIconClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        CustomCenterTopAppbar(

            titleContentColor = MaterialTheme.colorScheme.onSecondary,
            containerColor = MaterialTheme.colorScheme.outline,
            scrollContainerColor = MaterialTheme.colorScheme.error,
            title = "Analytics",
            // navIcon = R.drawable.mail,
            onNavigationIconClicked = onNavigationIconClicked,
            navigationIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.chevronleft),
                    contentDescription = stringResource(R.string.Password),
                    tint = MaterialTheme.colorScheme.secondaryContainer,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.centerBarIcon)),
                )
            },
            actionIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.segment),
                    contentDescription = stringResource(R.string.Password),
                    tint = MaterialTheme.colorScheme.secondaryContainer,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.centerBarIcon)),
                )
            },
            actionIconAction = {},
        )

        Spacer(modifier = Modifier.padding(5.dp))
        DiagramTitleAndDescription(" Incident Statistics", "ChartKeys")

        val description = listOf(
            DoughnutKeyDescription("Over Thresh Hold", MaterialTheme.colorScheme.primary),
            DoughnutKeyDescription("Within Thresh Hold", MaterialTheme.colorScheme.onSecondary),
            DoughnutKeyDescription("Under Thresh Hold", MaterialTheme.colorScheme.error),
        )

        BarAndKeys(description, pieChartContent)
        Spacer(modifier = Modifier.padding(5.dp))

        DiagramTitleAndDescription(" Incident Occurences", " Monthly")

        Spacer(modifier = Modifier.padding(10.dp))
        BarChartComposable(barComponent)
        Spacer(modifier = Modifier.padding(3.dp))
        StatisticReport(
            percentIncrease = 10,
            firstAppbarContent = "Incident",
            firstAppbarSceondContent = "Monthly",
            secondAppbarContent = "Incident",
            secondAppbarSecondContent = "Monthly",
            scondAppBArPerCentageIncrease = 20,

        )
    }
}

@Composable
private fun StatisticReport(
    percentIncrease: Int,
    firstAppbarContent: String,
    firstAppbarSceondContent: String,
    secondAppbarContent: String,
    secondAppbarSecondContent: String,
    scondAppBArPerCentageIncrease: Int,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth().padding(10.dp, top = 35.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AfterBar(percentIncrease, firstAppbarContent, firstAppbarSceondContent)
        HorizontalDivider(
            modifier = Modifier
                .padding(1.dp)
                .height(40.dp)
                .width(3.dp),
            color = Color.White,
        )

        AfterBar(
            scondAppBArPerCentageIncrease,
            secondAppbarContent,
            secondAppbarSecondContent,

        )
    }
}

@Composable
private fun DiagramTitleAndDescription(title: String, surfaceContent: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSecondary,
            style = MaterialTheme.typography.labelSmall,
        )
        ContentSurface(surfaceContent)
    }
}

@Composable
private fun BarAndKeys(description: List<DoughnutKeyDescription>, pieChartContent: List<PieChartData.Slice>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        PieChartComposable(pieChartContent)
        DoughnutKeys(doughnutKeyDescription = description)
    }
}

@Composable
fun IndividualKey(description: String, color: Color) {
    Row(
        modifier = Modifier.padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Surface(
            color = color,
            modifier = Modifier
                .width(10.dp)
                .height(10.dp)
                .clip(CircleShape),
        ) {
        }
        Text(
            text = description,
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .wrapContentSize(),
            color = MaterialTheme.colorScheme.onSecondary,
            style = MaterialTheme.typography.labelMedium,
        )
    }
}

data class DoughnutKeyDescription(val name: String, val color: Color)

@Composable
fun DoughnutKeys(
    doughnutKeyDescription: List<DoughnutKeyDescription>,
) {
    Column {
        doughnutKeyDescription.forEach {
            IndividualKey(it.name, it.color)
        }
    }
}

@Composable
fun ContentSurface(textContent: String) {
    Surface(
        modifier =
        Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(5.dp)),

        color = MaterialTheme.colorScheme.outline,
    ) {
        Row(
            modifier = Modifier.padding(5.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = textContent,
                color = Color.White,
                style = MaterialTheme.typography.labelMedium,
            )
        }
    }
}

@Composable
fun AfterBar(percentIncrease: Int, firstContent: String, secondContent: String) {
    Row(
        modifier = Modifier.wrapContentSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.padding(start = 3.dp),
            text = "$percentIncrease%",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
        )

        Column(modifier = Modifier.padding(7.dp)) {
            Text(
                modifier = Modifier.wrapContentSize(),
                text = firstContent,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleSmall,
                color = Color.White,
            )
            Text(
                text = secondContent,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleSmall,
                color = Color.White,
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
fun multipleKey() {
    val pieContent = listOf(
        PieChartData.Slice(20f, MaterialTheme.colorScheme.onSecondary),
        PieChartData.Slice(40f, MaterialTheme.colorScheme.error),
        PieChartData.Slice(40f, MaterialTheme.colorScheme.primary),
    )
    val description = listOf(
        DoughnutKeyDescription(
            "Risk Higher than thresh hold",
            Color.Red,
        ),
        DoughnutKeyDescription("Second", Color.Blue),
        DoughnutKeyDescription("Third", Color.Yellow),
    )

    val name = listOf("first", "Second ", "Third")
    HazardHuntTheme {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val description = listOf(
                DoughnutKeyDescription("Risk higher than thresh hold", Color.Red),
                DoughnutKeyDescription("Second", Color.Blue),
                DoughnutKeyDescription("Third", Color.Yellow),
            )
            PieChartComposable(pieContent)
            DoughnutKeys(doughnutKeyDescription = description)
        }
    }
}
