package com.hazardhunt.safebuddy.login.domain.util

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

        data object InvalidCredentials : Failure()

        data object Unknown : Failure()

        sealed class EmptyCredentials: Failure() {

            data object EmptyEmail: EmptyCredentials()

            data object EmptyPassword: EmptyCredentials()

            data object EmptyBoth: EmptyCredentials()
        }

//        data class EmptyCredentials(
//            val emptyEmail: Boolean,
//            val emptyPassword: Boolean,
//        ) : Failure()
    }
}
