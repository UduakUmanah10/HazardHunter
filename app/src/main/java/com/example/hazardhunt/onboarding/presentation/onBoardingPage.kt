// ktlint-disable filename

package com.example.hazardhunt.onboarding.presentation

import androidx.annotation.RawRes
import com.example.hazardhunt.R

sealed class OnBoardingPage(
    @RawRes
    val image: Int,
    val title: String,
    val description: String,
) {
    object First : OnBoardingPage(
        image = R.raw.men_at_work,
        title = "Real Time Situational Report",
        description = "Get real time Incident data, Respond appropriately to prevent severe Accident.",
    )

    object Second : OnBoardingPage(
        image = R.raw.dataanalysis,
        title = "Data Analysis",
        description = "Analyze incident data, Take necessary Actions, prevent future occurrences .",
    )

    object Third : OnBoardingPage(
        image = R.raw.ambulancia,
        title = "Automated Distress Calls",
        description = " Automate emergency calls, execute emergency action plans, prevent life loss.",
    )
}
