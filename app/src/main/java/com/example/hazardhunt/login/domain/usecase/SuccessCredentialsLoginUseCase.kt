package com.example.hazardhunt.login.domain.usecase

import com.example.hazardhunt.login.domain.util.Credentials
import com.example.hazardhunt.login.domain.util.LoginResults

class SuccessCredentialsLoginUseCase : CredentialsLoginUsecase {

    override suspend fun invoke(credentials: Credentials): LoginResults {
        return LoginResults.Success
    }
}
