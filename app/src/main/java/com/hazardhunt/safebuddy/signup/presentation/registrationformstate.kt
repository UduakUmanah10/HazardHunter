// ktlint-disable filename
package com.hazardhunt.safebuddy.signup.presentation

data class RegistrationFormState(
    val email: String = "",
    val emailError: String? = "",
    val password: String = "",
    val passwordError: String? = "",
    val repeatedPassword: String? = null,
    val repeatedPasswordError: String? = null,
    val accetpedTerms: Boolean = false,
    val acceptedTermsError: String? = null,

)
