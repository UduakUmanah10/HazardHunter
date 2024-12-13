// ktlint-disable filename
package com.hazardhunt.safebuddy.homescreen.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.core.view.theme.SafeBuddyTheme

@Composable
fun profilebarText(
    columModifier: Modifier = Modifier,
    upperText: String,
    upperTextModifier: Modifier = Modifier,
    upperTextFontWeight: FontWeight,
    upperTextStyle: TextStyle,
    upperTextColor: Color,
    lowerText: String,
    lowerTextModifier: Modifier = Modifier,
    lowerTextFontWeight: FontWeight,
    lowerTextColor: Color,
    lowerTextStyle: TextStyle,

) {
    Column(
        modifier = columModifier,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = upperText,
            modifier = upperTextModifier,
            fontWeight = upperTextFontWeight,
            style = upperTextStyle,
            color = upperTextColor,
        )
        Text(
            text = lowerText,
            fontWeight = lowerTextFontWeight,
            style = lowerTextStyle,
            color = lowerTextColor,
            modifier = lowerTextModifier,
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
fun profileText() {
    SafeBuddyTheme {
        profilebarText(
            upperText = "Hi Temi !",
            upperTextModifier = Modifier,
            upperTextFontWeight = FontWeight.Bold,
            upperTextStyle = MaterialTheme.typography.bodySmall,
            upperTextColor = MaterialTheme.colorScheme.secondaryContainer,
            lowerText = "Good Morning",
            lowerTextModifier = Modifier,
            lowerTextFontWeight = FontWeight.Bold,
            lowerTextColor = MaterialTheme.colorScheme.secondaryContainer,
            lowerTextStyle = MaterialTheme.typography.titleMedium,

        )
    }
}
