package com.hazardhunt.safebuddy.savedtaskscreen.domain.repository

import com.hazardhunt.safebuddy.login.domain.util.CustomResults
import com.hazardhunt.safebuddy.savedtaskscreen.data.model.SafetyTasks
import kotlinx.coroutines.flow.Flow

interface SafetyTaskRepository {

    fun fetchAllTasks(): Flow<CustomResults<List<SafetyTasks>>>

    suspend fun addTasks(task: SafetyTasks): CustomResults<Unit>

    suspend fun deletetask(task: SafetyTasks): CustomResults<Unit>
}
