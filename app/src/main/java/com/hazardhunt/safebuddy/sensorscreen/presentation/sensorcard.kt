// ktlint-disable filename

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hazardhunt.safebuddy.ui.theme.HazardHuntTheme
import com.hazardhunt.safebuddy.weatherdatailsscreen.presentation.coloredcircle
import com.hazardhunt.safebuddy.weatherdatailsscreen.presentation.reuseableiconandtext

@Composable
fun sensorcard() {
    Surface(
        shape = RoundedCornerShape(20.dp),
        color = Color.Green,
        modifier = Modifier
            .height(200.dp)
            .width(150.dp),
    ) {
        Box {
            coloredcircle(
                circleColor = Color.Blue,
                modifier = Modifier.padding(10.dp)
                    .height(20.dp)
                    .width(20.dp).align(Alignment.TopEnd),
            )

            reuseableiconandtext(
                modifier = Modifier.align(Alignment.Center),
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
fun csensorcard() {
    HazardHuntTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
        ) {
            sensorcard()
            // coloredcircle(circleColor = Color.Blue)
        }
    }
}
