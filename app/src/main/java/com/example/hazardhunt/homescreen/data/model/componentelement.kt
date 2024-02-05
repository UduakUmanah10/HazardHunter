// ktlint-disable filename
package com.example.hazardhunt.homescreen.data.model

data class ListElement(
    val main: Main,
    val components: Map<String, Double>,
    val dt: Long,
)
