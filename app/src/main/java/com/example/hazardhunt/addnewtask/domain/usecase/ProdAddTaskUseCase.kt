package com.example.hazardhunt.addnewtask.domain.usecase

import com.example.hazardhunt.addnewtask.data.repository.RoomtasklistRepository
import com.example.hazardhunt.home.data.model.SafetyTasks
import com.example.hazardhunt.login.domain.util.CustomResults
import javax.inject.Inject

class ProdAddTaskUseCase @Inject constructor(
    private val addTaskUseCase: RoomtasklistRepository,

) : Addtaskusecase {
    override suspend fun invoke(task: SafetyTasks): CustomResults<Unit> {
        return addTaskUseCase.addTasks(task)
    }
}
