// ktlint-disable filename
package com.hazardhunt.safebuddy.insight.presenatation
import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.tehras.charts.bar.BarChart
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.bar.BarChartData.Bar
import com.github.tehras.charts.bar.renderer.xaxis.SimpleXAxisDrawer
import com.github.tehras.charts.bar.renderer.yaxis.SimpleYAxisDrawer
import com.github.tehras.charts.piechart.PieChart
import com.github.tehras.charts.piechart.PieChartData
import com.github.tehras.charts.piechart.PieChartData.Slice
import com.github.tehras.charts.piechart.animation.simpleChartAnimation
import com.github.tehras.charts.piechart.renderer.SimpleSliceDrawer
import com.hazardhunt.safebuddy.ui.theme.HazardHuntTheme

typealias SLICEDATA = Float
const val FIRST_SLICE_VALUE: SLICEDATA = 20f
const val SECOND_SLICE_VALUE: SLICEDATA = 40f
const val THIRD_SLICE_VALUE: SLICEDATA = 40f

@Composable
fun viewchart() {
    val bar = listOf(
        Bar(label = "J", value = 100f, color = MaterialTheme.colorScheme.outline),
        Bar(label = "F", value = 200f, color = MaterialTheme.colorScheme.outline),
        Bar(label = "M", value = 300f, color = MaterialTheme.colorScheme.outline),
        Bar(label = "A", value = 400f, color = MaterialTheme.colorScheme.onSecondary),
        Bar(label = "M", value = 100f, color = MaterialTheme.colorScheme.outline),
        Bar(label = "J", value = 200f, color = MaterialTheme.colorScheme.outline),
        Bar(label = "J", value = 300f, color = MaterialTheme.colorScheme.outline),
        Bar(label = "Au", value = 400f, color = MaterialTheme.colorScheme.outline),
        Bar(label = "S", value = 400f, color = MaterialTheme.colorScheme.outline),
        Bar(label = "O", value = 100f, color = MaterialTheme.colorScheme.outline),
        Bar(label = "N", value = 200f, color = MaterialTheme.colorScheme.outline),
        Bar(label = "D", value = 300f, color = MaterialTheme.colorScheme.outline),
    )
    Column {
        Box(modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp)) {
            BarChartComposable(bar)
        }

        viewPie()
    }
}

@Composable
fun viewPie() {
    val piedata = listOf(
        Slice(FIRST_SLICE_VALUE, MaterialTheme.colorScheme.onSecondary),
        Slice(SECOND_SLICE_VALUE, MaterialTheme.colorScheme.error),
        Slice(THIRD_SLICE_VALUE, MaterialTheme.colorScheme.primary),
    )
    Column {
        Box(modifier = Modifier.padding(vertical = 16.dp)) {
            PieChartComposable(piedata)
        }
    }
}

@Composable
fun PieChartComposable(pieChartContent: List<Slice>) {
    PieChart(
        pieChartData = PieChartData(
            pieChartContent,
        ),
        modifier = Modifier
            .padding(25.dp)
            .height(150.dp)
            .width(120.dp),
        animation = simpleChartAnimation(),
        sliceDrawer = SimpleSliceDrawer(),
    )
}

@Composable
fun BarChartComposable(barContent: List<Bar>) {
    Box(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
        BarChart(
            barChartData = BarChartData(
                bars = barContent,
                // startAtZero = false,
                // padBy = 10f,

            ),
            labelDrawer = LabelDrawer(),

            yAxisDrawer = SimpleYAxisDrawer(
                labelTextColor = MaterialTheme.colorScheme.inverseOnSurface,
                labelValueFormatter = ::formatUnit,
                axisLineColor = MaterialTheme.colorScheme.outline,
            ),
            xAxisDrawer = SimpleXAxisDrawer(axisLineColor = MaterialTheme.colorScheme.outline),
            barDrawer = BarDrawer(),
            modifier = Modifier
                .fillMaxWidth().padding(4.dp)
                .height(147.dp),

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
fun InsightPreview() {
    HazardHuntTheme {
        viewchart()
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
fun PieChartDataPreview() {
    val content = listOf(
        Slice(20f, MaterialTheme.colorScheme.onSecondary),
        Slice(40f, MaterialTheme.colorScheme.error),
        Slice(40f, MaterialTheme.colorScheme.primary),
    )
    HazardHuntTheme {
        PieChartComposable(content)
    }
}
