// ktlint-disable filename
package com.hazardhunt.safebuddy.addnewtask.presentation
import com.hazardhunt.safebuddy.addnewtask.data.model.TaskinputModel
import com.hazardhunt.safebuddy.core.UIText
import java.time.LocalTime

/**
 * this is a class that determines the view state that would be possible in
 * the add task screen.
 *
 * */

sealed class Addtaskviewstate(
    open val taskInput: TaskinputModel = TaskinputModel(),
    open val inputEnabled: Boolean = true,
    open val time: LocalTime? = null,

) {
    object InitialState : Addtaskviewstate(taskInput = TaskinputModel())

    data class ActiveState(
        override val taskInput: TaskinputModel,
    ) : Addtaskviewstate(
        taskInput = taskInput,

    )
    data class SubmittingState(
        override val taskInput: TaskinputModel,
    ) : Addtaskviewstate(
        taskInput = taskInput,
        inputEnabled = false,
    )

    data class SubmittingErrorState(
        override val taskInput: TaskinputModel,
        val errorMessage: UIText,
    ) : Addtaskviewstate(
        taskInput = taskInput,
        inputEnabled = true,
    )

    object Successful : Addtaskviewstate(taskInput = TaskinputModel())
}
