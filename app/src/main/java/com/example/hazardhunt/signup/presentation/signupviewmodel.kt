// ktlint-disable filename
package com.example.hazardhunt.signup.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hazardhunt.signup.domain.usecases.ValidateEmail
import com.example.hazardhunt.signup.domain.usecases.ValidatePassWord
import com.example.hazardhunt.signup.domain.usecases.ValidateRepeatedPassWord
import com.example.hazardhunt.signup.domain.usecases.ValidateTermsAndConditions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignupViewModel(
    private val validatePassword: ValidatePassWord = ValidatePassWord(),
    private val validateEmail: ValidateEmail = ValidateEmail(),
    private val validatedRepeatedPassword: ValidateRepeatedPassWord = ValidateRepeatedPassWord(),
    private val validateTermsAndCondition: ValidateTermsAndConditions = ValidateTermsAndConditions(),
) : ViewModel() {

    private val _credential = MutableStateFlow<RegistrationFormState>(RegistrationFormState())
    val credentials = _credential.asStateFlow()

    var state by mutableStateOf(RegistrationFormState())

    fun onSignUpEvent(event: RegistrationFormViewState) {
        when (event) {
            is RegistrationFormViewState.EmailChanged -> {
                state = state.copy(
                    email = event.email,
                )
            }
            is RegistrationFormViewState.PasswordChanged -> {
                state = state.copy(
                    password = event.password,
                )
            }
            is RegistrationFormViewState.RepeatedPasswordChanged -> {
                state = state.copy(
                    repeatedPassword = event.repeatedPassword,
                )
            }
            is RegistrationFormViewState.TermsAndConditionChanged -> {
                state = state.copy(
                    accetpedTerms = event.isAccepted,
                )
            }
            is RegistrationFormViewState.Submitting -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val emailResult = validateEmail.execute(state.email)
        val passwordResult = validatePassword.execute(state.password)
        val repeatedPassWordResult = validatedRepeatedPassword
            .execute(
                state.password,
                state.repeatedPassword,
            )
        val termsResult = validateTermsAndCondition.execute(state.accetpedTerms)

        val hasError = listOf(
            emailResult,
            passwordResult,
            repeatedPassWordResult,
            termsResult,
        ).any { !it.successful }

        if (hasError) {
            state = state.copy(
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage,
                repeatedPasswordError = repeatedPassWordResult.errorMessage,
                acceptedTermsError = termsResult.errorMessage,

            )
            return
        }

        viewModelScope.launch {
        }
    }
}
