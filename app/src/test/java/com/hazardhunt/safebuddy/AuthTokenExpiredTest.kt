package com.hazardhunt.safebuddy

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import okhttp3.Call
import okhttp3.Connection
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import org.junit.jupiter.api.Test
import java.net.HttpURLConnection.HTTP_UNAUTHORIZED
import java.util.concurrent.TimeUnit

class AuthTokenExpiredTest {

    @Test
    fun callResponseWith401() {
        val request = DummyRequest()

        val interceptor = ExpiredTokenInceptor(signal = LogoutSignal(), HTTP_UNAUTHORIZED)
        interceptor.intercept(request)

        assertThat(interceptor.forcedLogout.value).isEqualTo(Unit)
    }

    @Test
    fun callResponseWith200() {
        val interceptor = ExpiredTokenInceptor(signal = LogoutSignal(), HTTP_UNAUTHORIZED)

        assertThat(interceptor.logOutSignal.forcedLogout.value).isNull()
    }

    class DummyRequest : Interceptor.Chain {

        private val request = Request
            .Builder()
            .url("https://dummy.url/")
            .build()

        override fun call(): Call {
            TODO("Not yet implemented")
        }

        override fun connectTimeoutMillis(): Int {
            TODO("Not yet implemented")
        }

        override fun connection(): Connection? {
            TODO("Not yet implemented")
        }

        override fun proceed(request: Request): Response {
            return Response
                .Builder()
                .request(request)
                .protocol(Protocol.HTTP_2)
                .code(401)
                .message("")
                .build()
        }

        override fun readTimeoutMillis(): Int {
            TODO("Not yet implemented")
        }

        override fun request(): Request {
            return request
        }

        override fun withConnectTimeout(timeout: Int, unit: TimeUnit): Interceptor.Chain {
            TODO("Not yet implemented")
        }

        override fun withReadTimeout(timeout: Int, unit: TimeUnit): Interceptor.Chain {
            TODO("Not yet implemented")
        }

        override fun withWriteTimeout(timeout: Int, unit: TimeUnit): Interceptor.Chain {
            TODO("Not yet implemented")
        }

        override fun writeTimeoutMillis(): Int {
            TODO("Not yet implemented")
        }
    }

    class ExpiredTokenInceptor(private val signal: LogoutSignal, val authorizationCode: Int) : Interceptor {

        private val _forcedLogout = MutableStateFlow<Unit?>(null)
        val forcedLogout: StateFlow<Unit?> = _forcedLogout.asStateFlow()

        val logOutSignal = signal

        override fun intercept(chain: Interceptor.Chain): Response {
            val response = chain.proceed(chain.request())
            if (response.code == authorizationCode) {
                _forcedLogout.update {
                    signal.onLoggedOut()
                }
            }
            return response
        }
    }

    class LogoutSignal {

        private val _forcedLogout = MutableStateFlow<Unit?>(null)
        val forcedLogout: StateFlow<Unit?> = _forcedLogout.asStateFlow()

        fun onLoggedOut() {
            _forcedLogout.update { Unit }
        }
    }
}
