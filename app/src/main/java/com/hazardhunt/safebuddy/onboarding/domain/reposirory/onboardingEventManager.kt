// ktlint-disable filename
package com.hazardhunt.safebuddy.onboarding.domain.reposirory

import kotlinx.coroutines.flow.Flow

interface OnboardingEventManager {

    suspend fun saveAppEntryState()

    fun readAppEntryState(): Flow<Boolean>
}
