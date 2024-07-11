// ktlint-disable filename
package com.hazardhunt.safebuddy.insight.presenatation

typealias Currency = Int

// We're using here the specific unit of measure to avoid yet another
// code smell
const val LIGHT_SPEED: Currency = 299792458
const val ONE_THOUSAND: Currency = 1000
const val ONE_MILLION: Currency = 1000_000

// fun energy(mass: Double) = (mass * LIGHT_SPEED).pow(2)
fun formatUnit(value: Float): String {
    return when {
        value >= ONE_THOUSAND && value < ONE_MILLION ->
            String.format("%.1fk", value / ONE_THOUSAND)

        value >= ONE_MILLION ->
            String.format("%.1fM", value / ONE_MILLION)

        else ->
            String.format("%.1f", value)
    }
}
