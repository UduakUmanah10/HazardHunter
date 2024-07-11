package com.hazardhunt.safebuddy

import android.Manifest
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.hazardhunt.safebuddy.core.services.Boundservice
import com.hazardhunt.safebuddy.core.services.LocationService
import com.hazardhunt.safebuddy.ui.theme.HazardHuntTheme
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class SensorServiceActivity : ComponentActivity() {

    private lateinit var mService: Boundservice
    private var mBound = false

    private val mconnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName?, binder: IBinder?) {
            val service = binder as Boundservice.MyBinder
            mService = service.getService()
            mBound = true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            mBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
            ),
            0,
        )

        Intent(this, Boundservice::class.java).also {
            bindService(it, mconnection, Context.BIND_AUTO_CREATE)
        }

        val scope = MainScope()
        var content = 0f

        if (mBound) {
            scope.launch {
                mService.getProgress().collect {
                    content = it
                }
            }
        }

        setContent {
            HazardHuntTheme {
                Surface {
                    var progress by remember {
                        mutableStateOf(content)
                    }
                    var sprogress by remember {
                        mutableStateOf(content)
                    }
                    val second = rememberCoroutineScope()
                    val applicationcontext = applicationContext

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.DarkGray),
                    ) {
                        Column() {
                            val context = LocalContext.current
                            Button(
                                onClick = {
                                    // if (mBound) {
                                    //   second.launch {
                                    //     mService.getProgress().collect {
                                    //       progress = it
                                    // }
                                    // }
                                    // }

                                    Intent(applicationcontext, LocationService::class.java).apply {
                                        action = LocationService.START_TRACKING
                                        startService(this)
                                    }
                                },
                            ) {
                                Text(text = "Downloading")
                            }
                            Text(text = "$progress")

                            LinearProgressIndicator(progress = progress)
                        }
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(mconnection)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HazardHuntTheme {
        Greeting("Android")
    }
}
