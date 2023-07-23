package com.example.hazardhunt.core

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hazardhunt.ui.theme.HazardHuntTheme

@Composable
fun loadingScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.onSecondaryContainer,
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .wrapContentSize(),

            color = MaterialTheme.colorScheme.secondaryContainer,
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
fun LazyPreview() {
    HazardHuntTheme {
        loadingScreen()
    }
}
