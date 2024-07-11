// ktlint-disable filename
package com.hazardhunt.safebuddy.addnewtask.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SimpleOutlinedTextFieldSample(
    enableTextField: Boolean = true,
    textContent: String,
    modifier: Modifier,
    textFieldLabel: String,
    numberOfLines: Int,
    onvalueChanged: (String) -> Unit,
    trailingIcon: (@Composable () -> Unit)? = null,
) {
    OutlinedTextField(
        enabled = enableTextField,
        modifier = modifier,
        value = textContent,
        onValueChange = onvalueChanged,
        minLines = numberOfLines,

        label = {
            Text(
                textFieldLabel,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.bodySmall,
            )
        },

        trailingIcon = trailingIcon,
        singleLine = false,
        textStyle = MaterialTheme.typography.bodySmall,

    )
}
