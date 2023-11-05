// ktlint-disable filename
package com.example.hazardhunt.addnewtask.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Addnewtaskviewmodel : ViewModel() {

    private val _localDate = MutableStateFlow(LocalDate.now().minusDays(1).touiString())
    val currentDate = _localDate.asStateFlow()

    private val _showDatePicker = MutableStateFlow(true)
    val showDatePicker = _showDatePicker.asStateFlow()

    fun shouldShowDatePicker() {
        val toggleValue = _showDatePicker.value
        _showDatePicker.value = !toggleValue
    }

    fun onDateValueChanged(currentDate: String) {
        val dateUpdate = currentDate
        _localDate.value = dateUpdate
    }
}

fun LocalDate.touiString(): String {
    val formatter = DateTimeFormatter.ofPattern("MMM dd,yyyy")
    return formatter.format(this)
}
