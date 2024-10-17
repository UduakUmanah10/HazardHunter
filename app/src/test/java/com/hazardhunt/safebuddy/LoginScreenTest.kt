package com.hazardhunt.safebuddy
import androidx.lifecycle.SavedStateHandle
import com.google.common.truth.Truth.assertThat
import com.hazardhunt.safebuddy.core.UIText
import com.hazardhunt.safebuddy.login.data.model.LogInViewState
import com.hazardhunt.safebuddy.login.domain.usecase.CredentialsLoginUsecase
import com.hazardhunt.safebuddy.login.domain.util.Credentials
import com.hazardhunt.safebuddy.login.domain.util.Email
import com.hazardhunt.safebuddy.login.domain.util.LoginResults
import com.hazardhunt.safebuddy.login.domain.util.Password
import com.hazardhunt.safebuddy.login.presentation.LoginViewModel
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(CoroutineTestExtension::class)
class LoginScreenTest {

    @Test
    fun defatltstate() = runTest {
        val viewmodel = LoginViewModel(credentialLoginUseCase = credentialusecase(), savedStateHandle = SavedStateHandle())
        assertThat(viewmodel.viewState.value).isEqualTo(LogInViewState.InitialLoginState)
    }

    @Test
    fun emailEnteredState() = runTest {
        val testEmail = "testy@mactest.com"
        val emailEnteredState = LogInViewState.Active(Credentials(email = Email(testEmail)))
        val viewmodel = LoginViewModel(credentialLoginUseCase = credentiaLoginUsecase(), savedStateHandle = SavedStateHandle())
        viewmodel.emailChange(testEmail)
        assertThat(viewmodel.viewState.value).isEqualTo(emailEnteredState)
    }

    @Test
    fun passwordEnteredState() = runTest {
        val password = "1234"
        val emailEnteredState = LogInViewState.Active(Credentials(password = Password(password)))
        val viewmodel = LoginViewModel(credentialLoginUseCase = credentiaLoginUsecase(), savedStateHandle = SavedStateHandle())

        viewmodel.passwordChangeed(password)

        assertThat(viewmodel.viewState.value).isEqualTo(emailEnteredState)
    }

    @Test
    fun emailAndPasswordEntered() = runTest {
        val testEmail = "testy@mactest.com"
        val testPassword = "12345"

        val passwordEnteredState = LogInViewState.Active(Credentials(email = Email(testEmail), password = Password(testPassword)))
        val viewmodel = LoginViewModel(credentialLoginUseCase = credentialusecase(), savedStateHandle = SavedStateHandle())

        viewmodel.emailChange(testEmail)
        viewmodel.passwordChangeed(testPassword)

        assertThat(viewmodel.viewState.value).isEqualTo(passwordEnteredState)
    }

    @Test
    fun onlyEmailSubmittedTest() = runTest {
        val testEmail = "testy@mactest.com"
        val credentials = Credentials(
            email = Email(testEmail),
        )

        val invalidpasswordInputState = LogInViewState.Active(
            credentials = credentials,
            passwordInputErrorMessage = UIText.ResourceStringText(R.string.error_empty_password),
        )

        val viewmodel = LoginViewModel(credentialLoginUseCase = onlyEmailCredentialEnteredUsecase(), savedStateHandle = SavedStateHandle())
        viewmodel.emailChange(testEmail)
        viewmodel.signInButtonClicked()

        assertThat(viewmodel.viewState.value).isEqualTo(invalidpasswordInputState)
    }

    @Test
    fun onlyPasswordSubmitted() = runTest {
        val testPassword = "12345"
        val credentials = Credentials(password = Password(testPassword))

        val invalidEmailInputState = LogInViewState.Active(
            credentials = credentials,
            emailInputErrorMessage = UIText.ResourceStringText(R.string.error_empty_email),
        )

        val viewmodel = LoginViewModel(
            credentialLoginUseCase = onlyPasswordCredentialEnteredUsecase(),
            savedStateHandle = SavedStateHandle(),
        )

        viewmodel.passwordChangeed(testPassword)
        viewmodel.signInButtonClicked()

        assertThat(viewmodel.viewState.value).isEqualTo(invalidEmailInputState)
    }

    @Test
    fun noEmailandPasswordsnSubmitted() = runTest {
        val credentials = Credentials()

        val invalidInputState = LogInViewState.Active(
            credentials = credentials,
            emailInputErrorMessage = UIText.ResourceStringText(R.string.error_empty_email),
            passwordInputErrorMessage = UIText.ResourceStringText(R.string.error_empty_password),

        )
        val viewmodel = LoginViewModel(
            credentialLoginUseCase = noEmaialAndPasswordCredentialEnteredUsecase(),
            savedStateHandle = SavedStateHandle(),
        )
        viewmodel.signInButtonClicked()

        assertThat(viewmodel.viewState.value).isEqualTo(invalidInputState)
    }

    class credentiaLoginUsecase : CredentialsLoginUsecase {
        override suspend fun invoke(credentials: Credentials): LoginResults {
            TODO("Not yet implemented")
        }
    }

    class onlyEmailCredentialEnteredUsecase : CredentialsLoginUsecase {
        override suspend fun invoke(credentials: Credentials): LoginResults {
            return LoginResults.Failure.EmptyCredentials(false, true)
        }
    }

    class onlyPasswordCredentialEnteredUsecase : CredentialsLoginUsecase {
        override suspend fun invoke(credentials: Credentials): LoginResults {
            return LoginResults.Failure.EmptyCredentials(true, false)
        }
    }

    class noEmaialAndPasswordCredentialEnteredUsecase : CredentialsLoginUsecase {
        override suspend fun invoke(credentials: Credentials): LoginResults {
            return LoginResults.Failure.EmptyCredentials(true, true)
        }
    }

    class credentialusecase : CredentialsLoginUsecase {
        override suspend fun invoke(credentials: Credentials): LoginResults {
            return LoginResults.Failure.EmptyCredentials(false, true)
        }
    }
}
