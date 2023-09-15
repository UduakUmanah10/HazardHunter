// ktlint-disable filename
package com.example.hazardhunt.sesorsscreen.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ViewModel
import com.example.hazardhunt.sesorsscreen.data.MeasurableSensor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

typealias  threshHold = Float
const val LIGHTTHRESHHOLD:threshHold =60f
@HiltViewModel
class Sensorviewmodel @Inject constructor(

    private val lightSensor: MeasurableSensor,
    private val notificationBuilder: NotificationCompat.Builder,
    private val notificationManager: NotificationManagerCompat,

) : ViewModel() {

    var isdark by mutableStateOf(false)

    private var _isRoomDark = MutableStateFlow<Boolean>(false)
    val isRoomDark: StateFlow<Boolean> = _isRoomDark

    private var _lightvalue = MutableStateFlow<Float>(0f)
    val lightvalue: StateFlow<Float> = _lightvalue

    init {
        lightSensor.startListening()
        lightSensor.setOnSensorValueChangedListener { value ->
            val lux = value[0]
            isdark = lux < LIGHTTHRESHHOLD

            _lightvalue.value = value[0]
            _isRoomDark.value = lux < LIGHTTHRESHHOLD
        }
    }


}
