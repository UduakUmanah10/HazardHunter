// ktlint-disable filename
package com.hazardhunt.safebuddy.login.data.model

import android.os.Parcelable
import com.hazardhunt.safebuddy.core.UIText
import com.hazardhunt.safebuddy.login.domain.util.Credentials
import kotlinx.parcelize.Parcelize

/**
 * This class Defines the current and possible state of the log in screen
 * @Param[credentials] the current text entered into the ui text field
 * @param[buttonsEnabled] the current password entered in the password field
 *
 */
@Parcelize
sealed class LogInViewState(
    open val credentials: Credentials,
    open val buttonsEnabled: Boolean = true,
) : Parcelable {
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
