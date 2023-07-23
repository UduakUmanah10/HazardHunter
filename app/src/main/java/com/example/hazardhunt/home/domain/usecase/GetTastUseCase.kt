package com.example.hazardhunt.home.domain.usecase

import com.example.hazardhunt.home.data.model.SafetyTasks
import com.example.hazardhunt.login.domain.util.CustomResults

interface GetTaskUseCase {
    suspend operator fun invoke():
        CustomResults<List<SafetyTasks>>
}
