package com.hazardhunt.safebuddy.login.dependencyinjection

import com.hazardhunt.safebuddy.login.domain.usecase.CredentialsLoginUsecase
import com.hazardhunt.safebuddy.login.domain.usecase.ProdCredentialsLoginUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class Usecasemodule {
    @Binds
    abstract fun bindCredentialsLoginUseCase(credentialsLoginUseCase: ProdCredentialsLoginUseCase):
        CredentialsLoginUsecase
}
