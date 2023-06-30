package com.example.hazardhunt.login.domain.repository

import com.example.hazardhunt.login.domain.util.Credentials
import com.example.hazardhunt.login.domain.util.CustomResults
import com.example.hazardhunt.login.domain.util.LoginResponse

interface LoginRepository {

    suspend fun login(
        credentials: Credentials,
    ): CustomResults<LoginResponse>
}
