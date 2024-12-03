package com.hazardhunt.safebuddy.login.dependencyinjection

import com.hazardhunt.safebuddy.login.core.ExpiredTokenInceptor
import com.hazardhunt.safebuddy.login.core.LogoutSignal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import java.net.HttpURLConnection.HTTP_UNAUTHORIZED

@Module
@InstallIn(SingletonComponent::class)
object Networkmodule {

    @Provides
    fun signal(): LogoutSignal {
        return LogoutSignal()
    }

    @Provides
    fun unauthorizedInteceptor(signl: LogoutSignal): ExpiredTokenInceptor {
        return ExpiredTokenInceptor(signl, HTTP_UNAUTHORIZED)
    }

    @Provides
    fun provideHttpClient(interceptor: ExpiredTokenInceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor).build()
    }
}
