package com.example.hazardhunt.login.domain.usecase

import com.example.hazardhunt.login.domain.repository.LoginRepository
import com.example.hazardhunt.login.domain.repository.TokenRepository
import com.example.hazardhunt.login.domain.util.Credentials
import com.example.hazardhunt.login.domain.util.CustomResults
import com.example.hazardhunt.login.domain.util.LoginResults
import kotlinx.coroutines.delay
import javax.inject.Inject

/**
 * this is a concrete implementation of a credential login use case
 * that would request logging in through the login repository
 * */

const val DELAYTIME = 2000
class ProdCredentialsLoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
    private val authTokenRepository: TokenRepository,
) : CredentialsLoginUsecase {

    override suspend operator fun invoke(credentials: Credentials): LoginResults {
        val emptyEmail = credentials.email.emailValue.isEmpty()
        val emptyPassword = credentials.password.passwordValue.isEmpty()

        if (emptyEmail || emptyPassword) {
            return LoginResults.Failure.EmptyCredentials(
                emptyEmail = emptyEmail,
                emptyPassword = emptyPassword,

            )
        }
        delay(DELAYTIME.toLong())

        val repositoryResult = loginRepository.login(credentials)

        return when (repositoryResult) {
            is CustomResults.Success<*> -> {
                // store auth token
                return LoginResults.Success
            }

            //  is CustomResult.Error{

            // }

            else -> { return LoginResults.Success }
        }
    }

    fun loginResultForError(error: Throwable): LoginResults.Failure {
        return when (error) {
            is InvalidCredentialsException -> {
                LoginResults.Failure.InvalidCredentials
            }
            else -> {
                LoginResults.Failure.Unknown
            }
        }
    }
}
class InvalidCredentialsException : Throwable()
