// ktlint-disable filename
package com.hazardhunt.safebuddy.login.dependencyinjection

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object CoroutineModule {

    @Provides
    fun provideIoDispatcher(): CoroutineContext = Dispatchers.IO
}
