package com.hazardhunt.safebuddy

import com.google.common.truth.Truth
import com.hazardhunt.safebuddy.login.data.repository.DemoPasswordValidatorService
import com.hazardhunt.safebuddy.login.data.repository.DemooEmailValidatorService
import com.hazardhunt.safebuddy.login.domain.util.Credentials
import com.hazardhunt.safebuddy.login.domain.util.Email
import com.hazardhunt.safebuddy.login.domain.util.Password
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CredentialValidationTest {

    @ParameterizedTest
    @CsvSource(
        " ' ' , false",
        " 'a', false ",
        " 'ab', false ",
        " 'ab@c', false ",
        " 'ab@d', false ",
        " 'ab@de.f', false ",
        " 'ab@de.fe', true ",
    )
    fun validateEmailIsCorrect(email: String, expected: Boolean) = runTest {
        val credentials = Credentials(Email(email))
        val emailValidator = DemooEmailValidatorService()

        val result = emailValidator.validateEmail(credentials)

        Truth.assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        " ' ' , false",
        " 'a', false ",
        " 'ab', false ",
        " 'ab_c', false ",
        " 'password', false ",
        " 'ab@de.f', false ",
        " 'pAssW0rd', true ",
        " 'ab@dE.fe1', true ",
    )
    fun validatePasswordIsCorrect(password: String, expected: Boolean) = runTest {
        val credentials = Credentials(password = Password(password))

        val result = DemoPasswordValidatorService().validatePassword(credentials)

        Truth.assertThat(result).isEqualTo(expected)
    }
}
