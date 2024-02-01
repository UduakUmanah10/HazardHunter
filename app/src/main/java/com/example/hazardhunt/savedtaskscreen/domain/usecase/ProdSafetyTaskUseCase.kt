package com.example.hazardhunt.savedtaskscreen.domain.usecase

import com.example.hazardhunt.login.domain.util.CustomResults
import com.example.hazardhunt.savedtaskscreen.data.model.SafetyTasks
import com.example.hazardhunt.savedtaskscreen.domain.repository.SafetyTaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProdSafetyTaskUseCase @Inject constructor(

    private val safetyTaskListRepository: SafetyTaskRepository,

) : GetTaskUseCase {
    override fun invoke(): Flow<CustomResults<List<SafetyTasks>>> {
        return safetyTaskListRepository.fetchAllTasks()
    }
}
