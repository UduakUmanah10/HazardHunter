package com.example.hazardhunt

import com.example.hazardhunt.core.UIText
import com.example.hazardhunt.fakeclasses.FakeAuthTokenRepository
import com.example.hazardhunt.fakeclasses.FakeLoginRepository
import com.example.hazardhunt.login.data.model.LogInViewState
import com.example.hazardhunt.login.domain.usecase.ProdCredentialsLoginUseCase
import com.example.hazardhunt.login.domain.util.Credentials
import com.example.hazardhunt.login.domain.util.Email
import com.example.hazardhunt.login.domain.util.LoginResults
import com.example.hazardhunt.login.domain.util.Password
import com.example.hazardhunt.testrobot.LoginViewModelRobot
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginViewModelTest {
    private lateinit var loginRepository: FakeLoginRepository
    private lateinit var tokenRepository: FakeAuthTokenRepository

    // val uncaughtExceptionHandlerRule = ThreadExceptionHandler()
    // val dispatcher = StandardTestDispatcher()
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Before
    fun setUp() {
        loginRepository = FakeLoginRepository()
        tokenRepository = FakeAuthTokenRepository()
        testRobot = LoginViewModelRobot()
    }

    @After
    fun tearDown() {
        //  Dispatchers.resetMain()
    }

    private lateinit var testRobot: LoginViewModelRobot

    private val defaultCredantials = Credentials(
        Email("uduakumanah10@gmail.com"),
        Password("Umanah4"),
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun updateCredentials() = runTest {
        val testEmail = "testy@mactest.com"
        val testPassword = "12345"

        val initialState = LogInViewState.InitialLoginState

        val emailEnteredState = LogInViewState.Active(
            Credentials(email = Email(testEmail)),
        )

        val emailPasswordEnteredState = LogInViewState.Active(
            Credentials(
                email = Email(testEmail),
                password = Password(testPassword),
            ),
        )

        testRobot
            .BuildViewModel()
            .assertViewStatesAfterActions(
                action = {
                    this.enterEmail(testEmail)
                    this.enterPassword(testPassword)
                },
                viewState = listOf(
                    initialState,
                    emailEnteredState,
                    emailPasswordEnteredState,
                ),

            )
    }

    @Test
    fun submitInvalidCredentials() = runTest {
        val testEmail = "testy@mactest.com"
        val testPassword = "1234"
        val completedCredentials = Credentials(
            email = Email(testEmail),
            password = Password(testPassword),
        )

        val initialState = LogInViewState.InitialLoginState

        val emailEnteredState = LogInViewState.Active(
            Credentials(email = Email(testEmail)),
        )

        val emailPasswordEnteredState = LogInViewState.Active(
            completedCredentials,
        )
        val submittingState = LogInViewState.Submitting(
            credentials = completedCredentials,
        )
        val submissionErrorState = LogInViewState.SubmissionError(
            completedCredentials,
            UIText.ResourceStringText(R.string.error_invalid_credentials),
        )

        testRobot
            .BuildViewModel()
            .mockLoginResultForCredentials(
                credentials = completedCredentials,
                LoginResults.Failure.InvalidCredentials,
            )
            .assertViewStatesAfterActions(
                action = {
                    this.enterEmail(testEmail)
                    this.enterPassword(testPassword)
                    this.clickSigninButton()
                },
                viewState = listOf(
                    initialState,
                    emailEnteredState,
                    emailPasswordEnteredState,
                    submittingState,
                    submissionErrorState,
                ),

            )
    }

    @Test
    fun unknownError() = runTest {
        val testEmail = "testy@mactest.com"
        val testPassword = "12345"
        val completedCredentials = Credentials(
            email = Email(testEmail),
            password = Password(testPassword),
        )

        val initialState = LogInViewState.InitialLoginState

        val emailEnteredState = LogInViewState.Active(
            Credentials(email = Email(testEmail)),
        )

        val emailPasswordEnteredState = LogInViewState.Active(
            completedCredentials,
        )
        val submittingState = LogInViewState.Submitting(
            credentials = completedCredentials,
        )
        val submissionErrorState = LogInViewState.SubmissionError(
            completedCredentials,
            UIText.ResourceStringText(R.string.err_login_failure),
        )

        testRobot
            .BuildViewModel()
            .mockLoginResultForCredentials(
                credentials = completedCredentials,
                LoginResults.Failure.Unknown,
            )
            .assertViewStatesAfterActions(
                action = {
                    this.enterEmail(testEmail)
                    this.enterPassword(testPassword)
                    this.clickSigninButton()
                },
                viewState = listOf(
                    initialState,
                    emailEnteredState,
                    emailPasswordEnteredState,
                    submittingState,
                    submissionErrorState,
                ),

            )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testSubmitWithoutCredentials() = runTest {
        // Thread.setDefaultUncaughtExceptionHandler { _, Throwable ->
        //   throw Throwable
        // }
        val credentials = Credentials()
        val initialState = LogInViewState.InitialLoginState
        val submitting = LogInViewState.Submitting(
            credentials = credentials,
        )
        val InvalidInputState = LogInViewState.Active(
            credentials = Credentials(),
            emailInputErrorMessage = UIText.ResourceStringText(R.string.error_empty_email),
            passwordInputErrorMessage = UIText.ResourceStringText(R.string.error_empty_password),
        )
        testRobot
            .BuildViewModel()
            .mockLoginResultForCredentials(
                credentials = credentials,
                LoginResults.Failure.EmptyCredentials(emptyEmail = true, emptyPassword = true),
            )
            .assertViewStatesAfterActions(
                action = {
                    clickSigninButton()
                },
                listOf(initialState, submitting, InvalidInputState),
            )
    }

    @Test
    fun testClearErrorsAfterInput() = runTest {
        val credentials = Credentials()
        val testEmail = "testy@mctestface.com"
        val testPassword = ""

        val initialState = LogInViewState.InitialLoginState
        val submittingState = LogInViewState.Submitting(
            credentials = credentials,
        )
        val invalidInputState = LogInViewState.Active(
            credentials = credentials,
            emailInputErrorMessage = UIText.ResourceStringText(R.string.error_empty_email),
            passwordInputErrorMessage = UIText.ResourceStringText(R.string.error_empty_password),
        )
        val emailInputState = LogInViewState.Active(
            credentials = Credentials(email = Email(testEmail)),
            emailInputErrorMessage = null,
            passwordInputErrorMessage = UIText.ResourceStringText(R.string.error_empty_password),
        )
        val passwordInputState = LogInViewState.Active(
            credentials = Credentials(email = Email(testEmail), password = Password(testPassword)),
            emailInputErrorMessage = null,
            passwordInputErrorMessage = null,
        )

        testRobot
            .BuildViewModel()
            .mockLoginResultForCredentials(
                credentials = credentials,
                LoginResults.Failure.EmptyCredentials(emptyEmail = true, emptyPassword = true),
            )
            .assertViewStatesAfterActions(
                action = {
                    clickSigninButton()
                },
                viewState = listOf(
                    initialState,
                    submittingState,
                    invalidInputState,
                ),
            )
    }

    @Test
    fun testEmptyCredentialsLogin() = runTest {
        val emptyCredentials = Credentials()
        val useCase = ProdCredentialsLoginUseCase(
            loginRepository = loginRepository.mock,
            authTokenRepository = tokenRepository.mock,
        )
        val result = useCase(emptyCredentials)
        assertThat(result).isEqualTo(LoginResults.Failure.EmptyCredentials(true, true))
        loginRepository.vreifyLoginCall()
        tokenRepository.verifyNoTokenStored()
    }
}
