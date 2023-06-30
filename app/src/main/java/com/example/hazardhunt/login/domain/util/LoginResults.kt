package com.example.hazardhunt.login.domain.util

sealed class LoginResults {
    /**
     * this is the information we expect to be returned from any successful result
     *
     */

    object Success : LoginResults()

    /**
     * this will be returned if there is no account that match the credentials
     */
    sealed class Failure : LoginResults() {

        object InvalidCredentials : Failure()

        object Unknown : Failure()

        data class EmptyCredentials(
            val emptyEmail: Boolean,
            val emptyPassword: Boolean,
        ) : Failure()
    }
}
