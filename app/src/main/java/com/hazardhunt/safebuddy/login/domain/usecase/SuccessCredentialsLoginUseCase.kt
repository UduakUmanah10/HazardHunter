package com.hazardhunt.safebuddy.login.domain.usecase

import com.hazardhunt.safebuddy.login.data.model.LoginResults
import com.hazardhunt.safebuddy.login.domain.util.Credentials

class SuccessCredentialsLoginUseCase : CredentialsLoginUsecase {

    override suspend fun invoke(credentials: Credentials): LoginResults {
        return LoginResults.Success
    }
}
