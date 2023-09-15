// ktlint-disable filename
package com.example.hazardhunt.sesorsscreen.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hazardhunt.tasklocationhistory.presentation.MapViewModel

@Composable
fun sensorScreen(
    viewmodel: Sensorviewmodel = hiltViewModel(),
    secondViewmodel: MapViewModel = hiltViewModel(),
) {
    val vi = viewmodel.isdark
    val isDark = viewmodel.isRoomDark.collectAsState().value
    var sensorvalue = viewmodel.lightvalue.collectAsState().value

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                if (isDark) Color.Green else Color.Red,

            ),
    ) {
        Column {
            Text("${isDark }, $sensorvalue")

            Button(
                onClick = {},
            ) {
                Text("start service")
            }

            Button(onClick = {}) {
                Text("stop service")
            }

            Button(onClick = {
                viewmodel.showNotification()
            }) {
                Text("show notification")
            }
        }
    }
}
