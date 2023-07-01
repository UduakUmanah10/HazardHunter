package com.example.hazardhunt.fakeclasses

import com.example.hazardhunt.login.domain.repository.TokenRepository
import com.example.hazardhunt.login.domain.util.Token
import io.mockk.coVerify
import io.mockk.mockk

class FakeAuthTokenRepository {
    val mock: TokenRepository = mockk()

    fun verifyTokenStored(token: Token) {
        coVerify {
            mock.storeToken(token)
        }
    }

    fun verifyNoTokenStored() {
        coVerify(exactly = 0) {
            mock.storeToken(any())
        }
    }
}
