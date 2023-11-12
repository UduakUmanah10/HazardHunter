// ktlint-disable filename
package com.example.hazardhunt.onboarding.domain.reposirory

import kotlinx.coroutines.flow.Flow

interface OnboardingEventManager {

    suspend fun saveAppEntryState()

    fun readAppEntryState(): Flow<Boolean>
}
