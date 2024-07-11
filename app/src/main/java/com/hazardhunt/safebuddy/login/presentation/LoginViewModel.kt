package com.hazardhunt.safebuddy.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hazardhunt.safebuddy.R
import com.hazardhunt.safebuddy.core.UIText
import com.hazardhunt.safebuddy.login.data.model.LogInViewState
import com.hazardhunt.safebuddy.login.domain.usecase.CredentialsLoginUsecase
import com.hazardhunt.safebuddy.login.domain.util.Credentials
import com.hazardhunt.safebuddy.login.domain.util.Email
import com.hazardhunt.safebuddy.login.domain.util.LoginResults
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
) : ViewModel() {

    private val _viewState: MutableStateFlow<LogInViewState> =
        MutableStateFlow(LogInViewState.InitialLoginState)

    val viewState: StateFlow<LogInViewState> = _viewState

    val completedState = Channel<Unit>()

    fun emailChange(email: String) {
        val currentCredentials = _viewState.value.credentials
        val currentPasswordErrorMessage =
            (_viewState.value as? LogInViewState.Active)?.passwordInputErrorMessage

        _viewState.value = LogInViewState.Active(
            credentials = currentCredentials.withUpdatedEmail(email),
            emailInputErrorMessage = null,
            passwordInputErrorMessage = currentPasswordErrorMessage,
        )
    }

    fun passwordChangeed(password: String) {
        val currentCredentials = _viewState.value.credentials

        val currentPasswordErrorMessage =
            (_viewState.value as? LogInViewState.Active)?.emailInputErrorMessage

        _viewState.value = LogInViewState.Active(
            credentials = currentCredentials.withUpdatedPassword(password),
            emailInputErrorMessage = currentPasswordErrorMessage,
            passwordInputErrorMessage = null,
        )
    }

    fun signUpButtonClicked() {
        // Todo
    }

    fun signInButtonClicked() {
        val currentCredentials = _viewState.value.credentials

        _viewState.value = LogInViewState.Submitting(
            credentials = currentCredentials,
        )

        viewModelScope.launch {
            val loginResult = credentialLoginUseCase(currentCredentials)

            _viewState.value = when (loginResult) {
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
                        emailInputErrorMessage = if (loginResult.emptyEmail) {
                            UIText.ResourceStringText(R.string.error_empty_email)
                        } else {
                            null
                        },

                        passwordInputErrorMessage = if (loginResult.emptyPassword) {
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
                else -> _viewState.value
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
}
