package com.hazardhunt.safebuddy.login.domain.usecase

import com.hazardhunt.safebuddy.login.data.model.LoginResults
import com.hazardhunt.safebuddy.login.domain.repository.EmailValidatorRepository
import com.hazardhunt.safebuddy.login.domain.repository.LoginRepository
import com.hazardhunt.safebuddy.login.domain.repository.PassWordValidatorRepository
import com.hazardhunt.safebuddy.login.domain.util.Credentials
import com.hazardhunt.safebuddy.login.domain.util.CustomResults
import kotlinx.coroutines.delay
import javax.inject.Inject

/**
 * this is a concrete implementation of a credential login use case
 * that would request logging in through the login repository
 * */

const val DELAYTIME = 2000
class ProdCredentialsLoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
    private val emailValidatorRepository: EmailValidatorRepository,
    private val passwordValidatorRepository: PassWordValidatorRepository,
) : CredentialsLoginUsecase {

    override suspend operator fun invoke(credentials: Credentials): LoginResults {
        val emptyEmail = credentials.email.emailValue.isEmpty()
        val emptyPassword = credentials.password.passwordValue.isEmpty()
        val emailvalidator = emailValidatorRepository.validateEmail(credentials)
        val passwordvalidator = passwordValidatorRepository.validatePassword(credentials)

        if (emptyEmail || emptyPassword) {
            return when {
                emptyEmail && emptyPassword -> LoginResults.Failure.EmptyCredentials.EmptyBoth
                emptyEmail -> LoginResults.Failure.EmptyCredentials.EmptyEmail
                else -> LoginResults.Failure.EmptyCredentials.EmptyPassword
            }
        }

        if (!emailvalidator) {
            return LoginResults.Failure.InvalidCredentials
        }

        if (!passwordvalidator) {
            return LoginResults.Failure.InvalidCredentials
        }

        delay(DELAYTIME.toLong())

        val repositoryResult = loginRepository.login(credentials)

        return when (repositoryResult) {
            is CustomResults.Success<*> -> {
                // store auth token
                return LoginResults.Success
            }

            else -> { return LoginResults.Success }
        }
    }
}
