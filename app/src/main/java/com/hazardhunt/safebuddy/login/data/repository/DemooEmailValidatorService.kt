package com.hazardhunt.safebuddy.login.data.repository

import com.hazardhunt.safebuddy.login.domain.repository.EmailValidatorRepository
import com.hazardhunt.safebuddy.login.domain.util.Credentials
import java.util.regex.Pattern
import javax.inject.Inject

class DemooEmailValidatorService @Inject constructor() : EmailValidatorRepository {

    private val emailPattern = Pattern.compile(EMAIL_REGEX)

    override suspend fun validateEmail(email: Credentials): Boolean {
        return emailPattern.matcher(email.email.emailValue).matches()
    }

    companion object {

        private const val EMAIL_REGEX = """[a-zA-Z0-9+._%\-]{1,64}@[a-zA-Z0-9][a-zA-Z0-9\-]{1,64}(\.[a-zA-Z0-9][a-zA-Z0-9\-]{1,25})"""
    }
}
