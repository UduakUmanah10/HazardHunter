package com.example.hazardhunt.login.data.repository

import com.example.hazardhunt.login.domain.repository.TokenRepository
import com.example.hazardhunt.login.domain.util.Token
import javax.inject.Inject

class DemoTokenService @Inject constructor() : TokenRepository {
    override suspend fun storeToken(token: Token) {
        // no impl
    }

    override suspend fun fetchToken(): Token? {
        return null
    }
}
