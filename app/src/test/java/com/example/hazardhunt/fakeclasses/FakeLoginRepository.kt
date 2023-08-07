package com.example.hazardhunt.fakeclasses

import com.example.hazardhunt.login.domain.repository.LoginRepository
import com.example.hazardhunt.login.domain.util.Credentials
import com.example.hazardhunt.login.domain.util.CustomResults
import com.example.hazardhunt.login.domain.util.LoginResponse
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
        coVerify(exactly = 0) {
            mock.login(any())
        }
    }
}
