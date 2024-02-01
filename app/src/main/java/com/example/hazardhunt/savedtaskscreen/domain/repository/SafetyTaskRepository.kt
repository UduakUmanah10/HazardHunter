package com.example.hazardhunt.savedtaskscreen.domain.repository

import com.example.hazardhunt.login.domain.util.CustomResults
import com.example.hazardhunt.savedtaskscreen.data.model.SafetyTasks
import kotlinx.coroutines.flow.Flow

interface SafetyTaskRepository {

    fun fetchAllTasks(): Flow<CustomResults<List<SafetyTasks>>>

    suspend fun addTasks(task: SafetyTasks): CustomResults<Unit>

    suspend fun deletetask(task: SafetyTasks): CustomResults<Unit>
}
