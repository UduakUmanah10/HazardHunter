package com.example.hazardhunt.home.domain.repository

import com.example.hazardhunt.home.data.model.SafetyTasks
import com.example.hazardhunt.login.domain.util.CustomResults
import kotlinx.coroutines.delay
import javax.inject.Inject

class DemoSafetyTaskRepository @Inject constructor() : SafetyTaskRepository {

    override suspend fun fetchAllTasks(): CustomResults<List<SafetyTasks>> {
        delay(1000)
        val tasks = (1..10).map { index ->
            SafetyTasks("Task $index")
        }
        return CustomResults.Success(tasks)
    }
}
