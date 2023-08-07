package com.example.hazardhunt.home.di

import com.example.hazardhunt.home.domain.usecase.GetTaskUseCase
import com.example.hazardhunt.home.domain.usecase.ProdSafetyTaskUseCase
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
