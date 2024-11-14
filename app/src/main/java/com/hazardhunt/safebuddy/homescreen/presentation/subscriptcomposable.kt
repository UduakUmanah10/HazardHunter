// ktlint-disable filename
package com.hazardhunt.safebuddy.homescreen.presentation
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun SuperScriptText(
    normalText: String,
    normalTextFontSize: TextUnit = MaterialTheme.typography.headlineLarge.letterSpacing,
    superText: String,
    superTextFontSize: TextUnit = MaterialTheme.typography.titleLarge.fontSize,
    superTextFontWeight: FontWeight = FontWeight.Normal,
    baselineShift: BaselineShift = BaselineShift.Superscript,
) {
    Row(
        modifier = Modifier.wrapContentSize().height(100.dp),
        verticalAlignment = Alignment.CenterVertically,

    ) {
        subscript(
            normalTextFontSize,
            normalText,
            superTextFontSize,
            superTextFontWeight,
            baselineShift,
            superText,
        )
        VerticalDivider(
            modifier = Modifier
                .padding(start = 8.dp, top = 7.dp)
                .height(20.dp)
                .width(3.dp),
            thickness = 3.dp,
            color = MaterialTheme.colorScheme.onPrimary,
        )

        Text(
            modifier = Modifier
                .padding(start = 10.dp),
            text = "partly cloudy",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimary,
        )
    }
}

@Composable
fun subscript(
    normalTextFontSize: TextUnit,
    normalText: String,
    superTextFontSize: TextUnit,
    superTextFontWeight: FontWeight,
    baselineShift: BaselineShift,
    superText: String,
) {
    Text(
        modifier = Modifier.padding(start = 4.dp),

        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = normalTextFontSize,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary,
                ),
            ) {
                append(normalText)
            }
            withStyle(
                style = SpanStyle(
                    fontSize = superTextFontSize,
                    fontWeight = superTextFontWeight,
                    baselineShift = baselineShift,
                    color = MaterialTheme.colorScheme.onPrimary,
                ),
            ) {
                append(superText)
            }
        },
    )
}
