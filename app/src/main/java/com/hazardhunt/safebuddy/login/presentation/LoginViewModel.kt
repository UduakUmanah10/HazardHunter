package com.hazardhunt.safebuddy.login.presentation
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hazardhunt.safebuddy.R
import com.hazardhunt.safebuddy.core.UIText
import com.hazardhunt.safebuddy.login.data.model.LogInViewState
import com.hazardhunt.safebuddy.login.data.model.LoginResults
import com.hazardhunt.safebuddy.login.domain.usecase.CredentialsLoginUsecase
import com.hazardhunt.safebuddy.login.domain.util.Credentials
import com.hazardhunt.safebuddy.login.domain.util.Email
import com.hazardhunt.safebuddy.login.domain.util.Password
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val credentialLoginUseCase: CredentialsLoginUsecase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _viewState: MutableStateFlow<LogInViewState> =
        MutableStateFlow(LogInViewState.InitialLoginState)

    val viewState: StateFlow<LogInViewState> =
        savedStateHandle.getStateFlow(LOGIN_SCREEN_STATE, _viewState.value)

    val completedState = Channel<Unit>()

    fun emailChange(email: String) {
        val currentCredentials = viewState.value.credentials
        val currentPasswordErrorMessage =
            (viewState.value as? LogInViewState.Active)?.passwordInputErrorMessage
        savedStateHandle[LOGIN_SCREEN_STATE] = LogInViewState.Active(
            credentials = currentCredentials.withUpdatedEmail(email)
                .withUpdatedEmail(email),
            emailInputErrorMessage = null,
            passwordInputErrorMessage = currentPasswordErrorMessage,
        )
    }

    fun passwordChangeed(password: String) {
        val currentCredentials = viewState.value.credentials
        val currentPasswordErrorMessage =
            (viewState.value as? LogInViewState.Active)?.emailInputErrorMessage

        savedStateHandle[LOGIN_SCREEN_STATE] = LogInViewState.Active(
            credentials = currentCredentials.withUpdatedPassword(password),
            emailInputErrorMessage = null,
            passwordInputErrorMessage = currentPasswordErrorMessage,
        )
    }

    fun signUpButtonClicked() {
        // Todo
    }

    fun signInButtonClicked() {
        val currentCredentials = viewState.value.credentials

        savedStateHandle[LOGIN_SCREEN_STATE] = LogInViewState.Submitting(
            credentials = currentCredentials,

        )

        viewModelScope.launch {
            val loginResult = credentialLoginUseCase(currentCredentials)

            savedStateHandle[LOGIN_SCREEN_STATE] = when (loginResult) {
                is LoginResults.Failure.InvalidCredentials -> {
                    LogInViewState.SubmissionError(
                        credentials = currentCredentials,
                        errorMessage = UIText.ResourceStringText(R.string.error_invalid_credentials),
                    )
                }
                is LoginResults.Failure.Unknown -> {
                    LogInViewState.SubmissionError(
                        credentials = currentCredentials,
                        errorMessage = UIText.ResourceStringText(R.string.err_login_failure),
                    )
                }
                is LoginResults.Failure.EmptyCredentials -> {
                    LogInViewState.Active(
                        credentials = currentCredentials,
                        emailInputErrorMessage = if (loginResult == LoginResults.Failure.EmptyCredentials.EmptyEmail) {
                            UIText.ResourceStringText(R.string.error_empty_email)
                        } else if (loginResult == LoginResults.Failure.EmptyCredentials.EmptyBoth) {
                            UIText.ResourceStringText(R.string.error_empty_email)
                        } else {
                            null
                        },

                        passwordInputErrorMessage = if (loginResult == LoginResults.Failure.EmptyCredentials.EmptyPassword) {
                            UIText.ResourceStringText(R.string.error_empty_password)
                        } else if (loginResult == LoginResults.Failure.EmptyCredentials.EmptyBoth) {
                            UIText.ResourceStringText(R.string.error_empty_password)
                        } else {
                            null
                        },
                    )
                }

                is LoginResults.Success -> {
                    _viewState.value
                    viewModelScope.launch {
                        completedState.send(Unit)
                    }
                    LogInViewState.LoginSuccess
                }
            }
        }
    }

    private fun Credentials.withUpdatedEmail(email: String): Credentials {
        return this.copy(
            email = Email(email),
        )
    }

    private fun Credentials.withUpdatedPassword(password: String): Credentials {
        return this.copy(
            password = Password(password),
        )
    }

    companion object {
        const val LOGIN_SCREEN_STATE = "loginScreenStateKey"
    }
}
