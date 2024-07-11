// ktlint-disable filename
package com.hazardhunt.safebuddy.core

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomCenterTopAppbar(
    iconmodifier: Modifier = Modifier,
    titleContentColor: Color,
    scrollContainerColor: Color,
    containerColor: Color,
    modifier: Modifier = Modifier,
    title: String,
    navigationIcon: (@Composable () -> Unit),
    // @DrawableRes navIcon:Int,
    onNavigationIconClicked: () -> Unit,
    actionIcon: (@Composable () -> Unit),
    actionIconAction: (() -> Unit),
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            titleContentColor = titleContentColor,
            scrolledContainerColor = scrollContainerColor,
            containerColor = containerColor,
        ),

        modifier = modifier,

        scrollBehavior = scrollBehavior,
        title = {
            Text(
                title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        navigationIcon = {
            IconButton(
                modifier = iconmodifier,
                onClick = onNavigationIconClicked,
                content = navigationIcon,
            )
        },
        actions = {
            IconButton(
                onClick = actionIconAction,
                content = actionIcon,
            )
        },
    )
}
