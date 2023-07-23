package com.example.hazardhunt.home.domain.repository

import com.example.hazardhunt.home.data.model.SafetyTasks
import com.example.hazardhunt.login.domain.util.CustomResults

interface SafetyTaskRepository {

    suspend fun fetchAllTasks(): CustomResults<List<SafetyTasks>>
}
