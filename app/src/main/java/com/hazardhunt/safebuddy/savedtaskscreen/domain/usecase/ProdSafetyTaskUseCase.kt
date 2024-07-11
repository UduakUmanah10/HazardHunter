package com.hazardhunt.safebuddy.savedtaskscreen.domain.usecase

import com.hazardhunt.safebuddy.login.domain.util.CustomResults
import com.hazardhunt.safebuddy.savedtaskscreen.data.model.SafetyTasks
import com.hazardhunt.safebuddy.savedtaskscreen.domain.repository.SafetyTaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProdSafetyTaskUseCase @Inject constructor(

    private val safetyTaskListRepository: SafetyTaskRepository,

) : GetTaskUseCase {
    override fun invoke(): Flow<CustomResults<List<SafetyTasks>>> {
        return safetyTaskListRepository.fetchAllTasks()
    }
}
