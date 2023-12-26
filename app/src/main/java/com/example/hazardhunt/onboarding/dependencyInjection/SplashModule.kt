package com.example.hazardhunt.onboarding.dependencyInjection

import android.content.Context
import com.example.hazardhunt.onboarding.data.OnBoardingRepository
import com.example.hazardhunt.onboarding.data.OnboardingEventManagerImpl
import com.example.hazardhunt.onboarding.data.model.OnBoardingUseCases
import com.example.hazardhunt.onboarding.domain.usecases.ReadOnBoardingState
import com.example.hazardhunt.onboarding.domain.usecases.SaveOnBoardingState
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
    fun provideOnBoardingRepository(
        @ApplicationContext context: Context,
    ) = OnBoardingRepository(context = context)

    @Provides
    @Singleton
    fun provideLocalUserManager(
        @ApplicationContext
        context: Context,
    ): OnboardingEventManagerImpl {
        return OnboardingEventManagerImpl(context)
    }

    @Provides
    @Singleton
    fun provideLocalUserManagerUseCase(
        onboardingEvent: OnboardingEventManagerImpl,
    ): OnBoardingUseCases {
        return OnBoardingUseCases(
            readOnBoardingState = ReadOnBoardingState(onboardingEvent),
            saveOnBoardingState = SaveOnBoardingState(onboardingEvent),
        )
    }
}
