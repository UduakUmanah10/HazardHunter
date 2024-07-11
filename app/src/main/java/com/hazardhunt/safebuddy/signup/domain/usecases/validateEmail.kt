// ktlint-disable filename
package com.hazardhunt.safebuddy.signup.domain.usecases

import android.util.Patterns

class ValidateEmail {

    fun execute(email: String): ValidationResult {
        if (email.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "email field cannot be empty",
            )
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                successful = false,
                errorMessage = "this is not a valid email format",

            )
        }

        return ValidationResult(
            successful = true,
            errorMessage = null,
        )
    }
}
