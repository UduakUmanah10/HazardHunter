// ktlint-disable filename
package com.example.hazardhunt.signup.presentation

sealed class RegistrationFormViewState {

    data class EmailChanged(val email: String) : RegistrationFormViewState()
    data class PasswordChanged(val password: String) : RegistrationFormViewState()
    data class RepeatedPasswordChanged(val repeatedPassword: String) : RegistrationFormViewState()
    data class TermsAndConditionChanged(val isAccepted: Boolean) : RegistrationFormViewState()
    object Submitting : RegistrationFormViewState()
}
