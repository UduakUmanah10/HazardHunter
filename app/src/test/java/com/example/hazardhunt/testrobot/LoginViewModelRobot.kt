package com.example.hazardhunt.testrobot

import app.cash.turbine.test
import com.example.hazardhunt.fakeclasses.FakeCredentialsLoginUseCase
import com.example.hazardhunt.login.domain.LogInViewState
import com.example.hazardhunt.login.domain.util.Credentials
import com.example.hazardhunt.login.domain.util.LoginResults
import com.example.hazardhunt.login.domain.viewmodel.LoginViewModel
import com.google.common.truth.Truth.assertThat

class LoginViewModelRobot {

    private val fakeCrekentialsLogInUsecase = FakeCredentialsLoginUseCase()

    private lateinit var viewModel: LoginViewModel

    fun BuildViewModel() = apply {

        viewModel = LoginViewModel(
            credentialLoginUseCase = fakeCrekentialsLogInUsecase.mock,

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
