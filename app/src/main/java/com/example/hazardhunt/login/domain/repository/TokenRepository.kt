package com.example.hazardhunt.login.domain.repository

import com.example.hazardhunt.login.domain.util.Token

interface TokenRepository {

    suspend fun storeToken(
        token: Token,
    )
    suspend fun fetchToken(): Token?
}
