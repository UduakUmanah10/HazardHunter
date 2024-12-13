// ktlint-disable filename
package com.hazardhunt.safebuddy.weatherdatailsscreen.presentation
import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.view.theme.SafeBuddyTheme
import com.hazardhunt.safebuddy.R

@Composable
fun iconandvalue(
    @DrawableRes icon: Int = R.drawable.humidity,
    calibration: String = "E 8 kmh",
    element: String = "wind",

) {
    Row(
        modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier
                .size(60.dp)
                .padding(10.dp),
            painter = painterResource(icon),
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onPrimary,
        )
        Column {
            Text(
                modifier = Modifier.width(100.dp),

                text = calibration,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary,
            )
            Text(
                modifier = Modifier.wrapContentSize().padding(2.dp),
                text = element,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary,
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
fun iconandtext() {
    SafeBuddyTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
        ) {
            //       iconandvalue()
            multipleRow()
            multipleRow()
        }
    }
}
