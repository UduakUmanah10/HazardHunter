// ktlint-disable filename
package com.hazardhunt.safebuddy.addnewtask.presentation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hazardhunt.safebuddy.R

@Composable
fun MultipleSurfaceWithICons() {
    Row(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Text(

            " Turn on Sensor :",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(TEXTFIELDWEIGHT),

        )
        Row(
            modifier = Modifier
                .fillMaxWidth() // 1.5f
                .weight(TEXTFIELDWEIGHT),
        ) {
            for (circulraSurface in START..END) {
                CategorySurface(
                    icon = R.drawable.time,
                    color = MaterialTheme.colorScheme.inversePrimary,
                )
            }
        }
    }
}
