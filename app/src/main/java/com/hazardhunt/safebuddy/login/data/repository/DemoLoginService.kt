package com.hazardhunt.safebuddy.login.data.repository

import com.hazardhunt.safebuddy.login.domain.repository.LoginRepository
import com.hazardhunt.safebuddy.login.domain.util.AuthToken
import com.hazardhunt.safebuddy.login.domain.util.Credentials
import com.hazardhunt.safebuddy.login.domain.util.CustomResults
import com.hazardhunt.safebuddy.login.domain.util.LoginResponse
import com.hazardhunt.safebuddy.login.domain.util.RefreshToken
import com.hazardhunt.safebuddy.login.domain.util.Token
import javax.inject.Inject

class DemoLoginService @Inject constructor() : LoginRepository {
    override suspend fun login(credentials: Credentials): CustomResults<LoginResponse> {
        val defaultToken = Token(
            AuthToken(""),
            RefreshToken(""),
        )

        val defaultResponse = LoginResponse(defaultToken)

        return CustomResults.Success(defaultResponse)
    }
}
