// ktlint-disable filename
package com.hazardhunt.safebuddy.savedtaskscreen.domain.usecase

import com.hazardhunt.safebuddy.login.domain.util.CustomResults
import com.hazardhunt.safebuddy.savedtaskscreen.data.model.SafetyTasks
import kotlinx.coroutines.flow.Flow

interface GetTaskUseCase {
    operator fun invoke(): Flow<CustomResults<List<SafetyTasks>>>
}
