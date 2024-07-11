package com.hazardhunt.safebuddy.savedtaskscreen.data.model

import com.hazardhunt.safebuddy.addnewtask.presentation.formatToDayAndNight
import com.hazardhunt.safebuddy.addnewtask.presentation.touiString
import java.time.LocalDate
import java.time.LocalTime

data class SafetyTasks(
    val taskTitle: String,
    val description: String = "",
    val scheduledDate: String = LocalDate.now().touiString(),
    val scheduledTime: String = LocalTime.now().formatToDayAndNight(),

)
