package com.hazardhunt.safebuddy

import androidx.lifecycle.SavedStateHandle
import com.google.common.truth.Truth.assertThat
import com.hazardhunt.safebuddy.core.UIText
import com.hazardhunt.safebuddy.login.data.model.LogInViewState
import com.hazardhunt.safebuddy.login.data.model.LoginResults
import com.hazardhunt.safebuddy.login.domain.usecase.CredentialsLoginUsecase
import com.hazardhunt.safebuddy.login.domain.util.Credentials
import com.hazardhunt.safebuddy.login.domain.util.Email
import com.hazardhunt.safebuddy.login.domain.util.Password
import com.hazardhunt.safebuddy.login.presentation.LoginViewModel
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(CoroutineTestExtension::class)
class LoginScreenTest {

    private val savedStateHandle = SavedStateHandle()
    private val loginViewModel = LoginViewModel(
        credentialLoginUseCase = credentiaLoginUsecase(),
        savedStateHandle = savedStateHandle,
    )

    @Test
    fun initialState() = runTest {
        assertThat(loginViewModel.viewState.value).isEqualTo(LogInViewState.InitialLoginState)
    }

    @Test
    fun emailEnteredState() = runTest {
        val testEmail = "testy@mactest.com"
        val emailEnteredState = LogInViewState.Active(Credentials(email = Email(testEmail)))

        loginViewModel.emailChange(testEmail)

        assertThat(loginViewModel.viewState.value).isEqualTo(emailEnteredState)
    }

    @Test
    fun passwordEnteredState() = runTest {
        val password = "1234"
        val emailEnteredState = LogInViewState.Active(Credentials(password = Password(password)))

        loginViewModel.passwordChangeed(password)

        assertThat(loginViewModel.viewState.value).isEqualTo(emailEnteredState)
    }

    @Test
    fun emailAndPasswordEntered() = runTest {
        val testEmail = "testy@mactest.com"
        val testPassword = "12345"
        val passwordEnteredState = LogInViewState.Active(Credentials(email = Email(testEmail), password = Password(testPassword)))

        loginViewModel.emailChange(testEmail)
        loginViewModel.passwordChangeed(testPassword)

        assertThat(loginViewModel.viewState.value).isEqualTo(passwordEnteredState)
    }

    @Test
    fun onlyEmailSubmittedTest() = runTest {
        val testEmail = "testy@mactest.com"
        val invalidPasswordInputState = LogInViewState.Active(
            credentials = Credentials(email = Email(testEmail)),
            passwordInputErrorMessage = UIText.ResourceStringText(R.string.error_empty_password),
        )
        val viewmodel =
            LoginViewModel(credentialLoginUseCase = onlyEmailCredentialEnteredUsecase(), savedStateHandle = savedStateHandle).apply {
                emailChange(testEmail)
            }

        viewmodel.signInButtonClicked()

        assertThat(viewmodel.viewState.value).isEqualTo(invalidPasswordInputState)
    }

    @Test
    fun onlyPasswordSubmitted() = runTest {
        val testPassword = "12345"
        val invalidEmailInputState = LogInViewState.Active(
            credentials = Credentials(password = Password(testPassword)),
            emailInputErrorMessage = UIText.ResourceStringText(R.string.error_empty_email),
        )
        val viewmodel = LoginViewModel(
            credentialLoginUseCase = onlyPasswordCredentialEnteredUsecase(),
            savedStateHandle = savedStateHandle,
        ).apply {
            passwordChangeed(testPassword)
        }

        viewmodel.signInButtonClicked()

        assertThat(viewmodel.viewState.value).isEqualTo(invalidEmailInputState)
    }

    @Test
    fun noEmailAndPasswordSubmitted() = runTest {
        val credentials = Credentials()
        val invalidInputState = LogInViewState.Active(
            credentials = credentials,
            emailInputErrorMessage = UIText.ResourceStringText(R.string.error_empty_email),
            passwordInputErrorMessage = UIText.ResourceStringText(R.string.error_empty_password),
        )
        val viewmodel = LoginViewModel(
            credentialLoginUseCase = ControllableCredentialsLoginUseCase(LoginResults.Failure.EmptyCredentials.EmptyBoth),
            savedStateHandle = savedStateHandle,
        )

        viewmodel.signInButtonClicked()

        assertThat(viewmodel.viewState.value).isEqualTo(invalidInputState)
    }

    @Test
    fun EmailAndPasswordSubmitted() = runTest {
        val testEmail = "testy@mactest.com"
        val testPassword = "12345"
        val credentials = Credentials(Email(testEmail), Password(testPassword))

        val invalidInputState = LogInViewState.SubmissionError(
            credentials = credentials,
            errorMessage = UIText.ResourceStringText(R.string.error_invalid_credentials),
        )
        val viewmodel = LoginViewModel(
            credentialLoginUseCase = ControllableCredentialsLoginUseCase(LoginResults.Failure.InvalidCredentials),
            savedStateHandle = savedStateHandle,
        )

        viewmodel.emailChange(testEmail)
        viewmodel.passwordChangeed(testPassword)
        viewmodel.signInButtonClicked()

        assertThat(viewmodel.viewState.value).isEqualTo(invalidInputState)
    }

    class ControllableCredentialsLoginUseCase(
        private val desiredResults: LoginResults,
    ) : CredentialsLoginUsecase {
        override suspend fun invoke(credentials: Credentials): LoginResults {
            return desiredResults
        }
    }

    class credentiaLoginUsecase : CredentialsLoginUsecase {
        override suspend fun invoke(credentials: Credentials): LoginResults {
            TODO("Not yet implemented")
        }
    }

    class onlyEmailCredentialEnteredUsecase : CredentialsLoginUsecase {
        override suspend fun invoke(credentials: Credentials): LoginResults {
            return LoginResults.Failure.EmptyCredentials.EmptyPassword
        }
    }

    class onlyPasswordCredentialEnteredUsecase : CredentialsLoginUsecase {
        override suspend fun invoke(credentials: Credentials): LoginResults {
            return LoginResults.Failure.EmptyCredentials.EmptyEmail
        }
    }
}
