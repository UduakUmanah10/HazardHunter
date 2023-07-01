package com.example.hazardhunt

import org.junit.rules.TestWatcher
import org.junit.runner.Description

class ThreadExceptionHandler : TestWatcher() {

    private var previousHandler: Thread.UncaughtExceptionHandler? = null

    override fun starting(description: Description) {
        previousHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { _, throwable ->
            throw throwable
        }
    }

    override fun finished(description: Description) {
        Thread.setDefaultUncaughtExceptionHandler(previousHandler)
    }
}
