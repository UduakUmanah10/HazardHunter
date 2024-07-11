package com.hazardhunt.safebuddy.login.domain.repository

import com.hazardhunt.safebuddy.login.domain.util.Credentials
import com.hazardhunt.safebuddy.login.domain.util.CustomResults
import com.hazardhunt.safebuddy.login.domain.util.LoginResponse

interface LoginRepository {

    suspend fun login(
        credentials: Credentials,
    ): CustomResults<LoginResponse>
}
