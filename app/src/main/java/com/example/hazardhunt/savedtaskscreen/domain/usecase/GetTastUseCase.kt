// ktlint-disable filename
package com.example.hazardhunt.savedtaskscreen.domain.usecase

import com.example.hazardhunt.login.domain.util.CustomResults
import com.example.hazardhunt.savedtaskscreen.data.model.SafetyTasks
import kotlinx.coroutines.flow.Flow

interface GetTaskUseCase {
    operator fun invoke(): Flow<CustomResults<List<SafetyTasks>>>
}
