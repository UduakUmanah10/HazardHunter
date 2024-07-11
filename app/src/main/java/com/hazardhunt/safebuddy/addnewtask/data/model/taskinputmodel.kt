// ktlint-disable filename
package com.hazardhunt.safebuddy.addnewtask.data.model

import com.hazardhunt.safebuddy.addnewtask.presentation.formatToDayAndNight
import com.hazardhunt.safebuddy.addnewtask.presentation.touiString
import java.time.LocalDate
import java.time.LocalTime

/**
 * This entity Model correspond  to the information that is needed when creating a
 * task.
 * */

data class TaskinputModel(
    val taskTitle: String = "",
    val description: String = "",
    val scheduledDate: String = LocalDate.now().touiString(),
    val scheduledTime: String = LocalTime.now().formatToDayAndNight(),

)
