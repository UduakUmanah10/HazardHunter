// ktlint-disable filename

package com.example.hazardhunt.homescreen.presentation
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hazardhunt.R
import com.example.hazardhunt.ui.theme.HazardHuntTheme

@Composable
fun airquality() {
    Row(
        modifier = Modifier
            // .height(100.dp)
            .wrapContentSize(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.airpolution),
            contentDescription = "",
            modifier = Modifier
                .height(70.dp)
                .width(70.dp).padding(top = 3.dp),
        )

        textComponentOfairQuality()
    }
}

@Composable
fun textComponentOfairQuality() {
    Column(modifier = Modifier.padding(5.dp).height(100.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "162",
                style = MaterialTheme.typography.displayMedium,
            )
            Divider(
                modifier =
                Modifier
                    .padding(start = 5.dp, top = 15.dp)
                    .height(25.dp)
                    .width(3.dp),

                color = Color.Black,
                thickness = 200.dp,
            )

            Text(
                modifier = Modifier
                    .padding(start = 7.dp, top = 15.dp)
                    .fillMaxWidth(),
                text = "Micro Dust / Pm 2.5",
                style = MaterialTheme.typography.displaySmall,
            )
        }

        Text(
            modifier = Modifier
                .padding(bottom = 3.dp)
                .fillMaxWidth().wrapContentHeight(),

            // i am adding you
            text = "Unhealthy",
            style = MaterialTheme.typography.displaySmall,
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
fun airqualityPreview() {
    HazardHuntTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
        ) {
            airquality()
        }
    }
}
