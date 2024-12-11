// ktlint-disable filename
package com.hazardhunt.safebuddy.settingsscreen.presentation.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hazardhunt.safebuddy.ui.theme.HazardHuntTheme

/**
 *
 * these is a composable that tis responsible for updating the profile picture when
 * clicked. the composable function takes in two parameters which are:
 * @param[modifier]: responsible for modifying the composable and click events.
 * @param[textdescription]: responsible for rendering test in the composable.
 *
 * **/

@Composable
fun updateprofilepicture(
    modifier: Modifier,
    textdescription: String = "Update Profile Picture",
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(4.dp),
    ) {
        Text(
            text = textdescription,
            modifier = Modifier.padding(2.dp),
            style = MaterialTheme.typography.titleSmall,
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
fun Update_profile_picture_preview() {
    HazardHuntTheme {
        updateprofilepicture(modifier = Modifier)
    }
}
