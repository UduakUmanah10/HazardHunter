package com.hazardhunt.safebuddy.login.data.repository

import com.hazardhunt.safebuddy.login.domain.repository.TokenRepository
import com.hazardhunt.safebuddy.login.domain.util.Token
import javax.inject.Inject

class DemoTokenService @Inject constructor() : TokenRepository {
    override suspend fun storeToken(token: Token) {
        // no impl
    }

    override suspend fun fetchToken(): Token? {
        return null
    }
}
