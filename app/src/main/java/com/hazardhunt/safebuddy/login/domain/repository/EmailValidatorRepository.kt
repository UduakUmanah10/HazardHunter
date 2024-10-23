package com.hazardhunt.safebuddy.login.domain.repository

import com.hazardhunt.safebuddy.login.domain.util.Credentials

interface EmailValidatorRepository {

    suspend fun validateEmail(email: Credentials): Boolean
}
