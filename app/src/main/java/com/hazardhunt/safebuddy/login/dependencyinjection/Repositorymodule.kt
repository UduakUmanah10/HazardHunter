package com.hazardhunt.safebuddy.login.dependencyinjection

import com.hazardhunt.safebuddy.login.data.repository.DemoLoginService
import com.hazardhunt.safebuddy.login.data.repository.DemoPasswordValidatorService
import com.hazardhunt.safebuddy.login.data.repository.DemoTokenService
import com.hazardhunt.safebuddy.login.data.repository.DemooEmailValidatorService
import com.hazardhunt.safebuddy.login.domain.repository.EmailValidatorRepository
import com.hazardhunt.safebuddy.login.domain.repository.LoginRepository
import com.hazardhunt.safebuddy.login.domain.repository.PassWordValidatorRepository
import com.hazardhunt.safebuddy.login.domain.repository.TokenRepository
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

    @Binds
    abstract fun bindEmailVakidatorRepository(validator: DemooEmailValidatorService): EmailValidatorRepository

    @Binds
    abstract fun bindPasswordValidatorRepository(validator: DemoPasswordValidatorService): PassWordValidatorRepository
}
