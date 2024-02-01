package com.example.hazardhunt.savedtaskscreen.di

import com.example.hazardhunt.savedtaskscreen.domain.usecase.GetTaskUseCase
import com.example.hazardhunt.savedtaskscreen.domain.usecase.ProdSafetyTaskUseCase
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
