package com.hazardhunt.safebuddy.login.domain.usecase

import com.hazardhunt.safebuddy.login.domain.util.Credentials
import com.hazardhunt.safebuddy.login.domain.util.LoginResults

class SuccessCredentialsLoginUseCase : CredentialsLoginUsecase {

    override suspend fun invoke(credentials: Credentials): LoginResults {
        return LoginResults.Success
    }
}
