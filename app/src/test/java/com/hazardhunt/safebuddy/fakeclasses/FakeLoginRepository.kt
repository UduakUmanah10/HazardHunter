package com.hazardhunt.safebuddy.fakeclasses

import com.hazardhunt.safebuddy.login.domain.repository.LoginRepository
import com.hazardhunt.safebuddy.login.domain.util.Credentials
import com.hazardhunt.safebuddy.login.domain.util.CustomResults
import com.hazardhunt.safebuddy.login.domain.util.LoginResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk

class FakeLoginRepository {
    val mock: LoginRepository = mockk()

    fun mockLoginWithCredentials(
        credentials: Credentials,
        result: CustomResults<LoginResponse>,
    ) {
        coEvery {
            mock.login(credentials)
        } returns result
    }

    fun vreifyLoginCall() {
        coVerify(exactly = 1) {
            mock.login(any())
        }
    }
}
