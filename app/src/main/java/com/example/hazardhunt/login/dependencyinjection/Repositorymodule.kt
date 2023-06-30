package com.example.hazardhunt.login.dependencyinjection

import com.example.hazardhunt.login.data.repository.DemoLoginService
import com.example.hazardhunt.login.data.repository.DemoTokenService
import com.example.hazardhunt.login.domain.repository.LoginRepository
import com.example.hazardhunt.login.domain.repository.TokenRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class Repositorymodule {
    @Binds
    abstract fun bindTokenService(tokenRepository: DemoTokenService): TokenRepository

    @Binds
    abstract fun bindLoginRepository(tokenRepository: DemoLoginService): LoginRepository
}
