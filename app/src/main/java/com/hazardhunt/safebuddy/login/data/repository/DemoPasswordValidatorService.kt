package com.hazardhunt.safebuddy.login.data.repository

import com.hazardhunt.safebuddy.login.domain.repository.PassWordValidatorRepository
import com.hazardhunt.safebuddy.login.domain.util.Credentials
import javax.inject.Inject
const val MAXPASSWORDNUMBER = 7

class DemoPasswordValidatorService @Inject constructor() : PassWordValidatorRepository {

    override suspend fun validatePassword(password: Credentials): Boolean {
        val value = password.password.passwordValue.trim()
        return value.count() > MAXPASSWORDNUMBER &&
            value.any { it.isUpperCase() } &&
            value.any { it.isDigit() }
    }
}
