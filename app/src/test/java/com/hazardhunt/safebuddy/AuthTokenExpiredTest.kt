package com.hazardhunt.safebuddy

import com.google.common.truth.Truth.assertThat
import com.hazardhunt.safebuddy.login.core.DummyRequest
import com.hazardhunt.safebuddy.login.core.ExpiredTokenInceptor
import com.hazardhunt.safebuddy.login.core.LogoutSignal
import org.junit.jupiter.api.Test
import java.net.HttpURLConnection.HTTP_UNAUTHORIZED

class AuthTokenExpiredTest {

    @Test
    fun callResponseWith401() {
        val request = DummyRequest()

        val interceptor = ExpiredTokenInceptor(signal = LogoutSignal(), HTTP_UNAUTHORIZED)
        interceptor.intercept(request)

        assertThat(interceptor.logOutSignal.forcedLogout.value).isEqualTo(Unit)
    }

    @Test
    fun callResponseWith200() {
        val interceptor = ExpiredTokenInceptor(signal = LogoutSignal(), HTTP_UNAUTHORIZED)

        assertThat(interceptor.logOutSignal.forcedLogout.value).isNull()
    }
}
