// ktlint-disable filename
package com.hazardhunt.safebuddy.addnewtask.data.repository

import com.hazardhunt.safebuddy.core.localstorage.Persistedsafetytask
import com.hazardhunt.safebuddy.core.localstorage.Safetaskdao
import com.hazardhunt.safebuddy.login.domain.util.CustomResults
import com.hazardhunt.safebuddy.savedtaskscreen.data.model.SafetyTasks
import com.hazardhunt.safebuddy.savedtaskscreen.domain.repository.SafetyTaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RoomtasklistRepository @Inject constructor(
    private val roomdatabase: Safetaskdao,

) : SafetyTaskRepository {
    override fun fetchAllTasks(): Flow<CustomResults<List<SafetyTasks>>> {
        return roomdatabase
            .fetchallTasks()
            .map { savedSafetyTAsks ->

                val mappedtask = savedSafetyTAsks.map { it ->
                    it.totask()
                }

                CustomResults.Success(
                    data = mappedtask,
                )
            }
    }

    override suspend fun addTasks(task: SafetyTasks): CustomResults<Unit> {
        val currenttask = task.topersistabletask()
        roomdatabase.insert(currenttask)

        return CustomResults.Success(Unit)
    }

    override suspend fun deletetask(task: SafetyTasks): CustomResults<Unit> {
        TODO("Not yet implemented")
    }
}

private fun Persistedsafetytask.totask(): SafetyTasks {
    return SafetyTasks(
        taskTitle = this.taskTitle,
        description = this.description,
        scheduledDate = this.scheduledDate,
        scheduledTime = this.scheduledTime,

    )
}

private fun SafetyTasks.topersistabletask(): Persistedsafetytask {
    return Persistedsafetytask(
        id = null,
        taskTitle = this.taskTitle,
        description = this.description,
        scheduledDate = this.scheduledDate,
        scheduledTime = this.scheduledTime,
        longitude = 11.1111,
        latitude = 11.111,
        completionStatus = "true",
        turnOnLight = true,
        turnOnTemperatureSensor = true,
        turnOnPressureSensor = true,
        turnOnProximitySensor = false,

    )
}
