package com.example.hazardhunt.insight.presenatation
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
import com.example.hazardhunt.ui.theme.HazardHuntTheme
import com.github.tehras.charts.bar.BarChart
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.bar.BarChartData.Bar
import com.github.tehras.charts.bar.renderer.label.SimpleValueDrawer
import com.github.tehras.charts.bar.renderer.yaxis.SimpleYAxisDrawer
import com.github.tehras.charts.piechart.PieChart
import com.github.tehras.charts.piechart.PieChartData
import com.github.tehras.charts.piechart.PieChartData.Slice
import com.github.tehras.charts.piechart.animation.simpleChartAnimation
import com.github.tehras.charts.piechart.renderer.SimpleSliceDrawer

@Composable
fun viewchart() {
    val bar =listOf(
        Bar(label = "Jan", value = 100f, color = MaterialTheme.colorScheme.outline),
        Bar(label = "Feb", value = 200f, color = MaterialTheme.colorScheme.outline),
        Bar(label = "Mar", value = 300f, color = MaterialTheme.colorScheme.outline),
        Bar(label = "Apr", value = 400f, color = MaterialTheme.colorScheme.onSecondary),
        Bar(label = "May", value = 100f, color = MaterialTheme.colorScheme.outline),
        Bar(label = "Jun", value = 200f, color = MaterialTheme.colorScheme.outline),
        Bar(label = "Jul", value = 300f, color = MaterialTheme.colorScheme.outline),
        Bar(label = "Aug", value = 400f, color = MaterialTheme.colorScheme.outline),
        Bar(label = "Sep", value = 400f, color = MaterialTheme.colorScheme.outline),
        Bar(label = "Oct", value = 100f, color = MaterialTheme.colorScheme.outline),
        Bar(label = "Nov", value = 200f, color = MaterialTheme.colorScheme.outline),
        Bar(label = "Dec", value = 300f, color = MaterialTheme.colorScheme.outline),
        )
    Column {
        Box(modifier = Modifier.padding(vertical = 16.dp)) {
            BarChartComposable(bar)
        }

        viewPie()
    }
}

@Composable
fun viewPie() {
   val piedata = listOf(
        Slice(20f, MaterialTheme.colorScheme.onSecondary),
        Slice(40f, MaterialTheme.colorScheme.error),
        Slice(40f, MaterialTheme.colorScheme.primary),
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
fun BarChartComposable(barContent:List<Bar>) {
    BarChart(
        barChartData = BarChartData(
            bars = barContent,
            startAtZero = false,
            padBy = 10f,

        ),
         barDrawer = barDrawer(),
        modifier = Modifier
            .fillMaxWidth().padding(10.dp)
            .height(147.dp),

        labelDrawer = SimpleValueDrawer(
            drawLocation = SimpleValueDrawer.DrawLocation.XAxis,
            labelTextColor = MaterialTheme.colorScheme.inverseOnSurface,
        ),

        yAxisDrawer = SimpleYAxisDrawer(
            labelTextColor = MaterialTheme.colorScheme.inverseOnSurface,
        ),

    )
}
fun roundNumberUp(value:Float):String{
   return when {
        value >= 1000 && value < 1_000_000 -> {
             String.format("%.1fk","${value / 1000}")
        }
        value >= 1_000_000 -> {
            String.format("%.1fM","${value / 1000_000}")
        }
        else -> {
            String.format("%.1f","$value")
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
