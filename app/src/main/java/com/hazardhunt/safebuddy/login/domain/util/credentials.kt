// ktlint-disable filename
package com.hazardhunt.safebuddy.login.domain.util

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@JvmInline
@Parcelize
value class Email(val emailValue: String) : Parcelable

@JvmInline
@Parcelize
value class Password(val passwordValue: String) : Parcelable

@Parcelize
data class Credentials(
    val email: Email = Email(emailValue = ""),
    val password: Password = Password(passwordValue = ""),
) : Parcelable
