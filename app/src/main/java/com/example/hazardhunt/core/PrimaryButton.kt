package com.example.hazardhunt.core

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import com.example.hazardhunt.R
import com.example.hazardhunt.ui.theme.HazardHuntTheme

/**
 * This is a custom [Button] that  provides the shape and styling expected in the application
 * @param[text] the text inside the button
 * @param[onclick] a callback that is invoked when the button is clicked
 * @param[modifier] to configure components of the button
 * @param[backgroundColor] an optional parameter to change the background color
 */

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onclick: () -> Unit,
    backgroundColor: Color = androidx.compose.material3.MaterialTheme.colorScheme.secondaryContainer,
    textColor: Color = MaterialTheme.colors.background,
) {
    val buttonColors = ButtonDefaults.buttonColors(
        backgroundColor = backgroundColor,
    )
    Button(
        onClick = onclick,
        modifier = modifier
            .clip(CircleShape)
            .height(dimensionResource(id = R.dimen.button_height))
            .fillMaxWidth(),
        colors = buttonColors,
    ) {
        Text(
            text = text.toUpperCase(Locale.current),
            color = textColor,
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
@Suppress("UnusedPrivateMember")
private fun PreviewPrimaryButton() {
    HazardHuntTheme {
        PrimaryButton(
            text = "primary button",
            onclick = {},
        )
    }
}
