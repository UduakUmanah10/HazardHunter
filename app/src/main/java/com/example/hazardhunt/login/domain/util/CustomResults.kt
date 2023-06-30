package com.example.hazardhunt.login.domain.util

sealed class CustomResults<out T> {
    data class Success<out T>(val data: T) : CustomResults<T>()
    data class Error(val data: Throwable) : CustomResults<Nothing>()
}
