package com.hazardhunt.safebuddy.login.core

import okhttp3.Interceptor
import okhttp3.Response

class ExpiredTokenInceptor(private val signal: LogoutSignal, val authorizationCode: Int) : Interceptor {

    val logOutSignal = signal

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        if (response.code() == authorizationCode) {
            signal.onLoggedOut()
        }
        return response
    }
}
