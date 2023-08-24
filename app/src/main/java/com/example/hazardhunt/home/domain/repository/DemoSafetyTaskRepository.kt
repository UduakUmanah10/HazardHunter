package com.example.hazardhunt.home.domain.repository

import com.example.hazardhunt.home.data.model.SafetyTasks
import com.example.hazardhunt.login.domain.util.CustomResults
import kotlinx.coroutines.delay
import javax.inject.Inject
typealias DELAY =Long
const val TIME_DELAY:DELAY =1000
class DemoSafetyTaskRepository @Inject constructor() : SafetyTaskRepository {

    override suspend fun fetchAllTasks(): CustomResults<List<SafetyTasks>> {
        delay(TIME_DELAY)
        val tasks = (1..10).map { index ->
            SafetyTasks("Task $index")
        }
        return CustomResults.Success(tasks)
    }
}
