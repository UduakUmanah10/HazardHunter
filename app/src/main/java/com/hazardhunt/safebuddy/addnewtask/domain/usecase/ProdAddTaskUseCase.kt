package com.hazardhunt.safebuddy.addnewtask.domain.usecase

import com.hazardhunt.safebuddy.addnewtask.data.repository.RoomtasklistRepository
import com.hazardhunt.safebuddy.login.domain.util.CustomResults
import com.hazardhunt.safebuddy.savedtaskscreen.data.model.SafetyTasks
import javax.inject.Inject

class ProdAddTaskUseCase @Inject constructor(
    private val addTaskUseCase: RoomtasklistRepository,

) : Addtaskusecase {
    override suspend fun invoke(task: SafetyTasks): CustomResults<Unit> {
        return addTaskUseCase.addTasks(task)
    }
}
