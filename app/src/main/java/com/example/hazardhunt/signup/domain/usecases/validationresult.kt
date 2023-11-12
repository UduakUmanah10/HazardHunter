// ktlint-disable filename
package com.example.hazardhunt.signup.domain.usecases

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String?,
)
