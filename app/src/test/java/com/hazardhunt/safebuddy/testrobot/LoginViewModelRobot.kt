package com.hazardhunt.safebuddy.testrobot

import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.hazardhunt.safebuddy.fakeclasses.FakeCredentialsLoginUseCase
import com.hazardhunt.safebuddy.login.data.model.LogInViewState
import com.hazardhunt.safebuddy.login.domain.util.Credentials
import com.hazardhunt.safebuddy.login.domain.util.LoginResults
import com.hazardhunt.safebuddy.login.presentation.LoginViewModel

class LoginViewModelRobot {

    private val fakeCrekentialsLogInUsecase = FakeCredentialsLoginUseCase()

    private lateinit var viewModel: LoginViewModel

    fun BuildViewModel() = apply {
        viewModel = LoginViewModel(
            credentialLoginUseCase = fakeCrekentialsLogInUsecase.mock,
            savedStateHandle = SavedStateHandle(),

        )
    }

    fun mockLoginResultForCredentials(
        credentials: Credentials,
        result: LoginResults,
    ) = apply {
        fakeCrekentialsLogInUsecase.mockLoginresultForCredentials(credentials, result)
    }

    fun enterEmail(email: String) = apply {
        viewModel.emailChange(email)
    }

    fun enterPassword(password: String) = apply {
        viewModel.passwordChangeed(password)
    }

    fun clickSigninButton() = apply {
        viewModel.signInButtonClicked()
    }

    fun clickSignupButton() = apply {
        viewModel.signUpButtonClicked()
    }

    fun assertViewState(expectedViewState: LogInViewState) = apply {
        val viewmodelState = viewModel.viewState.value
        assertThat(viewmodelState).isEqualTo(expectedViewState)
    }

    suspend fun assertViewStatesAfterActions(
        action: LoginViewModelRobot.() -> Unit,
        viewState: List<LogInViewState>,
    ) = apply {
        viewModel.viewState.test {
            action()

            for (state in viewState) {
                assertThat(awaitItem()).isEqualTo(state)
            }
            // awaitComplete()
            ensureAllEventsConsumed()
        }
    }
}
