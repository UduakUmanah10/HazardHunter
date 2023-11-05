// ktlint-disable filename
package com.example.hazardhunt.addnewtask.presentation
import com.example.hazardhunt.addnewtask.data.model.TaskinputModel
import com.example.hazardhunt.core.UIText
import java.time.LocalDateTime

/**
 * this is a class that determines the view state that would be possible in
 * the add task screen.
 *
 * */

sealed class Addtaskviewstate(
    open val taskInput: TaskinputModel = TaskinputModel(),
    open val inputEnabled: Boolean = true,
    open val time: LocalDateTime? = null,

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
