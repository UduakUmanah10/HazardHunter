package com.example.hazardhunt.home.domain.usecase

import com.example.hazardhunt.home.data.model.SafetyTasks
import com.example.hazardhunt.home.domain.repository.SafetyTaskRepository
import com.example.hazardhunt.login.domain.util.CustomResults
import javax.inject.Inject

class ProdSafetyTaskUseCase @Inject constructor(

    private val safetyTaskListRepository: SafetyTaskRepository,

) : GetTaskUseCase {

    override suspend fun invoke(): CustomResults<List<SafetyTasks>> {
        return safetyTaskListRepository.fetchAllTasks()
    }
}
