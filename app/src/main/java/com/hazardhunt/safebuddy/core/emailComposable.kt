// ktlint-disable filename
package com.hazardhunt.safebuddy.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.hazardhunt.safebuddy.R

@Composable
fun Email(
    text: String,
    onEmailTextChanged: (String) -> Unit,
    errorMessage: String?,
    enabled: Boolean,
    leadingIcon: (@Composable () -> Unit)? = null,
) {
    CustomTextField(
        enabled = enabled,
        text = text,
        onTextChanged = onEmailTextChanged,
        labelText = stringResource(id = R.string.Email),
        errorMessage = errorMessage,
        leadingIcon = leadingIcon,
    )
}
