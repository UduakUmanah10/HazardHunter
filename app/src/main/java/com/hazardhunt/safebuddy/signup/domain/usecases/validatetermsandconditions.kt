// ktlint-disable filename
package com.hazardhunt.safebuddy.signup.domain.usecases

class ValidateTermsAndConditions {

    fun execute(acceptedTerms: Boolean): ValidationResult {
        if (!acceptedTerms) {
            return ValidationResult(
                successful = false,
                errorMessage = "Please Accept The Terms",
            )
        }

        return ValidationResult(
            successful = true,
            errorMessage = null,
        )
    }
}
