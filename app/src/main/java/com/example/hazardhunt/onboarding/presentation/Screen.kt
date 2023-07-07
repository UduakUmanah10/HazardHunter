// ktlint-disable filename

package com.example.hazardhunt.onboarding.presentation

sealed class Screen(val route: String) {

    object onboardingScreen : Screen("onboarding")
    object welcomeScreen : Screen("homescreen")
}
