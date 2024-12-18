// ktlint-disable filename
package com.hazardhunt.safebuddy.settingsscreen.presentation.ui
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.view.theme.SafeBuddyTheme
import com.hazardhunt.safebuddy.R
import com.hazardhunt.safebuddy.core.CustomCenterTopAppbar

@Composable
fun settingspage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CustomCenterTopAppbar(
            containerColor = Color.Transparent,

            modifier = Modifier.padding(bottom = 5.dp),

            titleContentColor = MaterialTheme.colorScheme.onSecondary,

            scrollContainerColor = MaterialTheme.colorScheme.error,
            title = "Settings",
            // navIcon = R.drawable.mail,
            onNavigationIconClicked = {},
            navigationIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.chevronleft),
                    contentDescription = stringResource(R.string.Password),
                    tint = MaterialTheme.colorScheme.secondaryContainer,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.centerBarIcon)),
                )
            },
            actionIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.help),
                    contentDescription = stringResource(R.string.Password),
                    tint = MaterialTheme.colorScheme.secondaryContainer,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.centerBarIcon)),
                )
            },
            actionIconAction = {},
        )

        surface()
        // updateprofilepicture(modifier = Modifier.padding(3.dp))

//        Surface(
//            modifier = Modifier.padding(3.dp),
//            shape = RoundedCornerShape(7.dp),
//        ) {
//            Text(
//                text = "update profile picture",
//                modifier = Modifier.padding(4.dp),
//                style = MaterialTheme.typography.titleSmall,
//            )
//        }
        Surface(
            modifier = Modifier.padding(top = 3.dp, bottom = 10.dp, start = 15.dp, end = 15.dp),
            shape = RoundedCornerShape(15.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth().padding(5.dp),
            ) {
                Text(text = "Uduak Umanah", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "UduakUmanah10@gmail.com",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 7.dp),
                )
                // Text(
                //  text = "Registered on Feb 21 2024",
                // style = MaterialTheme.typography.titleMedium,
                // modifier = Modifier.padding(bottom = 7.dp),
                // )
            }
        }

//        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
//            Text(text = "Uduak Umanah", style = MaterialTheme.typography.titleMedium)
//            Text(text = "UduakUmanah10@gmail.com", style = MaterialTheme.typography.titleMedium)
//            Text(
//                text = "Registered at Feb 21 2024",
//                style = MaterialTheme.typography.titleMedium,
//                modifier = Modifier.padding(bottom = 7.dp),
//            )
//        }
        settingsoption()

        Surface(shape = RoundedCornerShape(15.dp), modifier = Modifier.padding(15.dp)) {
            Individualsettingsitem(
                surfaceIcon = R.drawable.delete,
                surfaceColor = Color.Red,
                textDescription = "delete",
                showdivider = false,
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Version 3.1.0 (10)",
                style = MaterialTheme.typography.titleSmall,
                color = Color.White,
                modifier = Modifier.padding(top = 20.dp),
            )
            Text(text = "By Uduak Unmanah", style = MaterialTheme.typography.titleSmall, color = Color.White)
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
fun settingspagepreview() {
    SafeBuddyTheme {
        settingspage()
    }
}
