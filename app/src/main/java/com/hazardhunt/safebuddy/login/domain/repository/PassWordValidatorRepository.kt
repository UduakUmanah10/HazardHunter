package com.hazardhunt.safebuddy.login.domain.repository

import com.hazardhunt.safebuddy.login.domain.util.Credentials

interface PassWordValidatorRepository {

    suspend fun validatePassword(password: Credentials): Boolean
}
