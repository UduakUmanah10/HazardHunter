package com.example.hazardhunt.login.data.repository

import com.example.hazardhunt.login.domain.repository.LoginRepository
import com.example.hazardhunt.login.domain.util.AuthToken
import com.example.hazardhunt.login.domain.util.Credentials
import com.example.hazardhunt.login.domain.util.CustomResults
import com.example.hazardhunt.login.domain.util.LoginResponse
import com.example.hazardhunt.login.domain.util.RefreshToken
import com.example.hazardhunt.login.domain.util.Token
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
