package com.example.hazardhunt.onboarding.data

import androidx.datastore.core.Serializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

@Suppress("BlockingMethodInNonBlockingContext")
object OnBoardingSerializer : Serializer<OnboardingSettings> {
    override val defaultValue: OnboardingSettings
        get() = OnboardingSettings()

    override suspend fun readFrom(input: InputStream): OnboardingSettings {
        return try {
            Json.decodeFromString(
                deserializer = OnboardingSettings.serializer(),
                string = input.readBytes().decodeToString(),

            )
        } catch (e: SerializationException) {
            throw Exception(e)
            defaultValue
        }
    }

    override suspend fun writeTo(t: OnboardingSettings, output: OutputStream) {
        output.write(
            Json.encodeToString(
                serializer = OnboardingSettings.serializer(),
                value = t,
            ).encodeToByteArray(),

        )
    }
}
