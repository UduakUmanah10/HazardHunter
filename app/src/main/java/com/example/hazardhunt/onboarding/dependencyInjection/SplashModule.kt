package com.example.hazardhunt.onboarding.dependencyInjection

import android.content.Context
import com.example.hazardhunt.onboarding.data.DataStoreRepository
import com.example.hazardhunt.onboarding.data.OnBoardingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SplashModule {
    @Provides
    @Singleton
    fun provideDataStoreRepository(
        @ApplicationContext context: Context,
    ) = DataStoreRepository(context = context)

    @Provides
    @Singleton
    fun provideOnBoardingRepository(
        @ApplicationContext context: Context,
    ) = OnBoardingRepository(context = context)
}
