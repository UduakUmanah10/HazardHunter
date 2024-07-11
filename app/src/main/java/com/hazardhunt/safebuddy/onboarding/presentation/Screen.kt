// ktlint-disable filename

package com.hazardhunt.safebuddy.onboarding.presentation

sealed class Screen(val route: String) {

    object onboardingScreen : Screen("onboarding")
    object welcomeScreen : Screen("homescreen")
}
