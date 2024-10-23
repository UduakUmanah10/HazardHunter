package com.hazardhunt.safebuddy.fakeclasses

import com.hazardhunt.safebuddy.login.data.model.LoginResults
import com.hazardhunt.safebuddy.login.domain.usecase.CredentialsLoginUsecase
import com.hazardhunt.safebuddy.login.domain.util.Credentials
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk

class FakeCredentialsLoginUseCase {
    @MockK
    val mock: CredentialsLoginUsecase = mockk()

    fun mockLoginresultForCredentials(
        credentials: Credentials,
        result: LoginResults,
    ) {
        coEvery {
            mock(credentials)
        } returns result
    }
}
