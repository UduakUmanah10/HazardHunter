// ktlint-disable filename
package com.hazardhunt.safebuddy.activetasks.presentation

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.core.view.theme.SafeBuddyTheme

@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Day mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
fun activetasksPage() {
    SafeBuddyTheme {
    }
}
