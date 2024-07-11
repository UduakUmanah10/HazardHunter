// ktlint-disable filename
package com.hazardhunt.safebuddy.login.domain.util

@JvmInline
value class Email(val emailValue: String)

@JvmInline
value class Password(val passwordValue: String)

data class Credentials(
    val email: Email = Email(emailValue = ""),
    val password: Password = Password(passwordValue = ""),
)
