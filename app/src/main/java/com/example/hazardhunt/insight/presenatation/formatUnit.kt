package com.example.hazardhunt.insight.presenatation

fun formatUnit(value: Float): String {
    return when {
        value >= 1000 && value < 1_000_000 ->
            String.format("%.1fk", value / 1000)

        value >= 1_000_000 ->
            String.format("%.1fM", value / 1000_000)

        else ->
            String.format("%.1f", value)
    }
}
