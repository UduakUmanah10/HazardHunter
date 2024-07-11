package com.hazardhunt.safebuddy.login.domain.repository

import com.hazardhunt.safebuddy.login.domain.util.Token

interface TokenRepository {

    suspend fun storeToken(
        token: Token,
    )
    suspend fun fetchToken(): Token?
}
