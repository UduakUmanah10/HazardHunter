package com.example.hazardhunt.onboarding.data

import android.content.Context
import androidx.datastore.dataStore
import kotlinx.coroutines.flow.Flow

val Context.datastore by dataStore("onboarding-settings.json", OnBoardingSerializer)
class OnBoardingRepository(context: Context) {
    private val dataStore = context.datastore

    suspend fun saveOnBoardingState(onboardingState: OnboardingState) {
        dataStore.updateData {
            it.copy(
                completed = onboardingState,
            )
        }
    }

    fun readOnBoardingState(): Flow<OnboardingSettings> {
        return dataStore.data
    }
}
