package com.example.hazardhunt.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun bathtime() {
    println("going th the bathroom")
    delay(500L)
    println("bath done")
}
suspend fun boilingWater() {
    println("Boiling Water")
    delay(100)
    println("water boiled")
}
suspend fun MakeCoffee() {
    println("starting to Make Coffee")
    delay(500)
    println("Done Making Coffee")
}
suspend fun sequentialMorningRoutine() {
    coroutineScope {
        bathtime()
    }

    coroutineScope {
        boilingWater()
    }
}

/**
 * take a bath
 * start the boiling water
 * after bath => drink coffee
 * */

suspend fun morningRoutineWithCoffee() {
    coroutineScope {
        val bathJob: Job = launch { bathtime() }
        val boilingwaterJob: Job = launch { boilingWater() }

        bathJob.join()
        boilingwaterJob.join()
        launch { MakeCoffee() }
    }
}
suspend fun parallel() {
    coroutineScope {
        launch { bathtime() }
        launch { boilingWater() }
    }
}

suspend fun workingHard() {
    println("working")
    while (true) {
    }
    delay(100L)
    println("workdone")
}

suspend fun takeabreak() {
    println("taking a break")
    delay(1000)
    println("break Done")
}

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun workHArdRoutine() {
    val dispatcher: CoroutineDispatcher = Dispatchers.Default.limitedParallelism(1)
}
fun main() = runBlocking {
    parallel()
}
