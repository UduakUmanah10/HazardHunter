// ktlint-disable filename
package com.example.hazardhunt.signup.domain.usecases

const val ALLOWED_PASSWORD_LENGTH = 8

class ValidatePassWord {

    fun execute(password: String): ValidationResult {
        if (password.length < ALLOWED_PASSWORD_LENGTH) {
            return ValidationResult(
                successful = false,
                errorMessage = "password should contain at least characters",
            )
        }

        val containsLetterAndDigits = password.any { it.isDigit() } && password.any { it.isLetter() }

        if (!containsLetterAndDigits) {
            return ValidationResult(
                successful = false,
                errorMessage = "password needs to contain letter and digit",

            )
        }

        return ValidationResult(
            successful = true,
            errorMessage = null,
        )
    }
}
