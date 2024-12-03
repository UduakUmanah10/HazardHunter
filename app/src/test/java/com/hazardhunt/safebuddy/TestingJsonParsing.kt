package com.hazardhunt.safebuddy

import com.google.common.truth.Truth
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import java.time.ZonedDateTime

class TestingJsonParsing {

    private val givenJson = """{"userId":"uid","dateTime":"2024-09-24T15:29:09Z"}"""

    @Serializable
    data class DateTime(
        val userId: String,
        @Serializable(with = CustomDateTimeSerializer::class)
        val dateTime: ZonedDateTime,
    )

    @Test
    fun parsingDateTime() {
        val result = Json.decodeFromString<DateTime>(givenJson)
        Truth.assertThat(result).isEqualTo(
            DateTime(
                "uid",
                ZonedDateTime.parse("2024-09-24T15:29:09Z"),
            ),
        )
    }

    private class CustomDateTimeSerializer : KSerializer<ZonedDateTime> {

        override val descriptor = PrimitiveSerialDescriptor("DateTime", PrimitiveKind.STRING)

        override fun deserialize(decoder: Decoder): ZonedDateTime {
            val value = decoder.decodeString()
            return ZonedDateTime.parse(value)
        }

        override fun serialize(encoder: Encoder, value: ZonedDateTime) {
            TODO("Not yet implemented")
        }
    }
}
