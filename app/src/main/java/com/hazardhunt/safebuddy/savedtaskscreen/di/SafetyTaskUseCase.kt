package com.hazardhunt.safebuddy.savedtaskscreen.di

import com.hazardhunt.safebuddy.savedtaskscreen.domain.usecase.GetTaskUseCase
import com.hazardhunt.safebuddy.savedtaskscreen.domain.usecase.ProdSafetyTaskUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SafetyTaskUseCase {
    @Binds
    abstract fun bindCredentialsLoginUseCase(prodSafetyTaskUseCase: ProdSafetyTaskUseCase): GetTaskUseCase
}
