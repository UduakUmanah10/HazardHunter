package com.example.hazardhunt.login.dependencyinjection

import com.example.hazardhunt.login.domain.usecase.CredentialsLoginUsecase
import com.example.hazardhunt.login.domain.usecase.ProdCredentialsLoginUseCase
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
