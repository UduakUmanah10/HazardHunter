package com.example.hazardhunt.onboarding.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

private val Context.onBoardingdataStore: DataStore<Preferences> by preferencesDataStore("onboarding")
