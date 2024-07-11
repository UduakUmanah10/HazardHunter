// ktlint-disable filename
package com.hazardhunt.safebuddy.addnewtask.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.hazardhunt.safebuddy.R

@Composable
fun CategorySurface(
    @DrawableRes icon: Int,
    color: Color,

) {
    Surface(
        modifier = Modifier
            .padding(4.dp)
            .width(50.dp)
            .height(50.dp)
            .clip(CircleShape),

        color = color,
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = stringResource(R.string.Password),
                tint = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.Icon_height))
                    .clickable { },
            )
        }
    }
}
