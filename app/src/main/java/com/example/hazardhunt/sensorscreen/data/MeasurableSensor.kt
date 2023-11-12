package com.example.hazardhunt.sensorscreen.data
/**
 * the measurable sensor class is an abstract class that can be inherited to
 * enable unit testing because it would not contain any android specific
 * code. this behaviour makes it easy to inherit and instantiate different types of sensors
 *
 * */
abstract class MeasurableSensor(
    protected val typeofSensor: Int,
) {

    protected var onSensorValueChanged: ((List<Float>) -> Unit)? = null

    abstract val doesSensorExist: Boolean

    abstract fun startListening()

    abstract fun stopListening()

    fun setOnSensorValueChangedListener(listener: (List<Float>) -> Unit) {
        onSensorValueChanged = listener
    }
}
