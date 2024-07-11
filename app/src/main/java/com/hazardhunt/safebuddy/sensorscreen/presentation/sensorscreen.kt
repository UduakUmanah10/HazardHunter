// ktlint-disable filename
package com.hazardhunt.safebuddy.sensorscreen.presentation

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.hazardhunt.safebuddy.SensorServiceActivity

@Composable
fun sensorScreen(
    viewmodel: Sensorviewmodel = hiltViewModel(),
) {
    var context1 = LocalContext.current

    val context = LocalContext.current
    val vi = viewmodel.isdark
    val isDark = viewmodel.isRoomDark.collectAsState().value
    val sensorvalue = viewmodel.lightvalue.collectAsState().value

    var state by remember { mutableStateOf(0f) }
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .navigationBarsPadding()
            .background(
                if (isDark) Color.Green else Color.Red,

            ),
    ) {
        val context = LocalContext.current
        Column(modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = {
                },
            ) {
                Text("start service")
            }

            Button(onClick = {}) {
                Text("stop service")
            }

            Button(onClick = {
                Intent(context, SensorServiceActivity::class.java).also {
                    context.startActivity(it)
                }
                viewmodel.showNotification(context)
            }) {
                Text("show notification")
            }
            Text("${isDark }, $sensorvalue")
            LinearProgressIndicator(progress = state)
        }
    }
}
