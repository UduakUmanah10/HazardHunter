// ktlint-disable filename
package com.example.hazardhunt.addnewtask.data.model

import java.time.LocalDate
import java.time.LocalDateTime

/**
 * This entity Model correspond  to the information that is needed when creating a
 * task.
 * */

data class TaskinputModel(
    val taskTitle: String = "",
    val description: String = "",
    val scheduledDate: LocalDate = LocalDate.now(),
    val scheduledTime: LocalDateTime? = null,

    )
