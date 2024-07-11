package com.hazardhunt.safebuddy.onboarding.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.hazardhunt.safebuddy.core.util.Constants
import com.hazardhunt.safebuddy.core.util.Constants.ON_BOARDING_SETTINGS
import com.hazardhunt.safebuddy.onboarding.domain.reposirory.OnboardingEventManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OnboardingEventManagerImpl(
    private val context: Context,
) : OnboardingEventManager {

    override suspend fun saveAppEntryState() {
        context.On_boarding_datastore.edit { settings ->
            settings[PreferencesKey.APP_ENTRY] = true
        }
    }

    override fun readAppEntryState(): Flow<Boolean> {
        return context.On_boarding_datastore.data.map { preferences ->
            preferences[PreferencesKey.APP_ENTRY] ?: false
        }
    }
}

private val Context.On_boarding_datastore: DataStore<Preferences> by preferencesDataStore(name = ON_BOARDING_SETTINGS)

private object PreferencesKey {
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}
