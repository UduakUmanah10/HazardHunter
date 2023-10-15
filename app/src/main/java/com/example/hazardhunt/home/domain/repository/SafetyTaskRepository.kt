package com.example.hazardhunt.home.domain.repository

import com.example.hazardhunt.home.data.model.SafetyTasks
import com.example.hazardhunt.login.domain.util.CustomResults
import kotlinx.coroutines.flow.Flow

interface SafetyTaskRepository {

    fun fetchAllTasks(): Flow<CustomResults<List<SafetyTasks>>>

    suspend fun addTasks(task: SafetyTasks): CustomResults<Unit>

    suspend fun deletetask(task: SafetyTasks): CustomResults<Unit>
}
