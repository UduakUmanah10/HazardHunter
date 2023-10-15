// ktlint-disable filename
package com.example.hazardhunt.home.domain.usecase

import com.example.hazardhunt.home.data.model.SafetyTasks
import com.example.hazardhunt.login.domain.util.CustomResults
import kotlinx.coroutines.flow.Flow

interface GetTaskUseCase {
    operator fun invoke(): Flow<CustomResults<List<SafetyTasks>>>
}
