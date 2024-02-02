// ktlint-disable filename
package com.example.hazardhunt.homescreen.presentation
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        Text(
            modifier = Modifier.padding(start = 4.dp),

            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = normalTextFontSize,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSecondary,
                    ),
                ) {
                    append(normalText)
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = superTextFontSize,
                        fontWeight = superTextFontWeight,
                        baselineShift = baselineShift,
                        color = MaterialTheme.colorScheme.onSecondary,
                    ),
                ) {
                    append(superText)
                }
            },
        )

        Divider(
            modifier =
            Modifier
                .padding(start = 5.dp, top = 5.dp)
                .height(30.dp)
                .width(3.dp),

            color = Color.Black,
            thickness = 200.dp,
        )

        Text(
            modifier = Modifier
                .padding(start = 10.dp),
            text = "partly cloudy",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.secondaryContainer,
        )
    }
}
