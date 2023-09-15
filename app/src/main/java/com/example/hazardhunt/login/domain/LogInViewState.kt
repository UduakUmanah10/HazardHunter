// ktlint-disable filename
package com.example.hazardhunt.login.domain

import com.example.hazardhunt.core.UIText
import com.example.hazardhunt.login.domain.util.Credentials

/**
 * This class Defines the current and possible state of the log in screen
 * @Param[credentials] the current text entered into the ui text field
 * @param[buttonsEnabled] the current password entered in the password field
 *
 *
 */

sealed class LogInViewState(
    open val credentials: Credentials,
    open val buttonsEnabled: Boolean = true,
) {
    object InitialLoginState : LogInViewState(
        credentials = Credentials(),
    )

    data class Active(
        override val credentials: Credentials,
        val emailInputErrorMessage: UIText? = null,
        val passwordInputErrorMessage: UIText? = null,
    ) : LogInViewState(
        credentials = credentials,
    )

    data class Submitting(
        override val credentials: Credentials,
    ) : LogInViewState(
        credentials = credentials,
        buttonsEnabled = false,
    )

    data class SubmissionError(
        override val credentials: Credentials,
        val errorMessage: UIText,
    ) : LogInViewState(
        credentials = credentials,
    )
    object LoginSuccess : LogInViewState(
        Credentials(),
        buttonsEnabled = false,
    )
}
