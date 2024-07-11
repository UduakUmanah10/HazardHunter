// ktlint-disable filename
package com.hazardhunt.safebuddy.core

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.hazardhunt.safebuddy.R

@Composable
fun SignupAnnotatedString(action: () -> Unit) {
    val initialText = stringResource(id = R.string.dont_have_an_account)
    val privatePolicy = stringResource(id = R.string.Click_toCreate_account)

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.secondary)) {
            pushStringAnnotation(tag = privatePolicy, annotation = privatePolicy)
            append(privatePolicy)
        }
    }
    ClickableText(text = annotatedString, onClick = { offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
            if (span.item == privatePolicy) {
                action()
            }
        }
    })
}
