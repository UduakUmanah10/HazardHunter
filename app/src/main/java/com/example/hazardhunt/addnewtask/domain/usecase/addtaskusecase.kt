// ktlint-disable filename
package com.example.hazardhunt.addnewtask.domain.usecase

import com.example.hazardhunt.login.domain.util.CustomResults
import com.example.hazardhunt.savedtaskscreen.data.model.SafetyTasks

interface Addtaskusecase {

    suspend operator fun invoke(task: SafetyTasks):
        CustomResults<Unit>
}
