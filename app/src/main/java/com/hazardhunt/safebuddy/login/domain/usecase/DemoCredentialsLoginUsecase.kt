// ktlint-disable filename
package com.hazardhunt.safebuddy.login.domain.usecase

import com.hazardhunt.safebuddy.login.domain.util.Credentials
import com.hazardhunt.safebuddy.login.domain.util.LoginResults
import kotlinx.coroutines.delay

class DemoCredentialsLoginUsecase : CredentialsLoginUsecase {
    @Suppress("MagicNumber")
    override suspend fun invoke(credentials: Credentials): LoginResults {
        delay(2000)
        return LoginResults.Failure.InvalidCredentials
    }
}
