// ktlint-disable filename
package com.hazardhunt.safebuddy.weatherdatailsscreen.presentation

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.view.theme.SafeBuddyTheme
import com.hazardhunt.safebuddy.R
import com.hazardhunt.safebuddy.core.CustomCenterTopAppbar

@Composable
fun weatherdetailsTopappbar(
    titleContentColor: Color = MaterialTheme.colorScheme.onSecondary,
    containerColor: Color = MaterialTheme.colorScheme.outline,
    titleText: String = "Today",
    onClick: () -> Unit = {},
    @DrawableRes icon: Int = R.drawable.chevronleft,
    iconColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    clickable: () -> Unit = {},

) {
    CustomCenterTopAppbar(
        titleContentColor = titleContentColor,
        containerColor = containerColor,
        scrollContainerColor = MaterialTheme.colorScheme.error,
        title = titleText,
        // navIcon = R.drawable.mail,
        onNavigationIconClicked = onClick,
        navigationIcon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = stringResource(R.string.Password),
                tint = iconColor,
                modifier = Modifier.height(200.dp).width(100.dp),
            )
        },

        actionIcon = {},
        actionIconAction = {},
    )
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
fun weathecentertopbarpreview() {
    SafeBuddyTheme {
        weatherdetailsTopappbar()
    }
}
