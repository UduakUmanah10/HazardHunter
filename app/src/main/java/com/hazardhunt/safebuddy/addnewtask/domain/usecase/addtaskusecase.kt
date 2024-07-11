// ktlint-disable filename
package com.hazardhunt.safebuddy.addnewtask.domain.usecase

import com.hazardhunt.safebuddy.login.domain.util.CustomResults
import com.hazardhunt.safebuddy.savedtaskscreen.data.model.SafetyTasks

interface Addtaskusecase {

    suspend operator fun invoke(task: SafetyTasks):
        CustomResults<Unit>
}
