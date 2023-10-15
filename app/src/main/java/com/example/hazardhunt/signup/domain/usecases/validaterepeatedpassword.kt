// ktlint-disable filename
package com.example.hazardhunt.signup.domain.usecases

class ValidateRepeatedPassWord {

    fun execute(password: String, repeatedPassword: String?): ValidationResult {
        if (password != repeatedPassword) {
            return ValidationResult(
                successful = false,
                errorMessage = "the password don't match",
            )
        }

        return ValidationResult(
            successful = true,
            errorMessage = null,
        )
    }
}
