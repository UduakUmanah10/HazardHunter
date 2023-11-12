package com.example.hazardhunt.home.data.model

import com.example.hazardhunt.addnewtask.presentation.formatToDayAndNight
import com.example.hazardhunt.addnewtask.presentation.touiString
import java.time.LocalDate
import java.time.LocalTime

data class SafetyTasks(
    val taskTitle: String,
    val description: String = "",
    val scheduledDate: String = LocalDate.now().touiString(),
    val scheduledTime: String = LocalTime.now().formatToDayAndNight(),

)
