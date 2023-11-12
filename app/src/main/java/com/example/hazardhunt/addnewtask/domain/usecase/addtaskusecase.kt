// ktlint-disable filename
package com.example.hazardhunt.addnewtask.domain.usecase

import com.example.hazardhunt.home.data.model.SafetyTasks
import com.example.hazardhunt.login.domain.util.CustomResults

interface Addtaskusecase {

    suspend operator fun invoke(task: SafetyTasks):
        CustomResults<Unit>
}
