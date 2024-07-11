// ktlint-disable filename
package com.hazardhunt.safebuddy.signup.domain.usecases

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String?,
)
