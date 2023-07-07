// ktlint-disable filename
package com.example.hazardhunt.core

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.hazardhunt.R

@Composable
fun Password(
    keyboardOption: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Password,

    ),
    enabled: Boolean,
    text: String,
    onPasswordTextChanged: (String) -> Unit,
    errorMessage: String?,
    leadingIcon: (@Composable () -> Unit)? = null,
    visualTransformation: VisualTransformation,
) {
    var passwordvisibility by remember { mutableStateOf(false) }
    val passwordIcon = if (passwordvisibility) R.drawable.visibility else R.drawable.visibility_off

    CustomTextField(
        keyboardOption = keyboardOption,
        text = text,
        onTextChanged = onPasswordTextChanged,
        labelText = stringResource(id = R.string.Password),
        errorMessage = errorMessage,
        leadingIcon = leadingIcon,
        enabled = enabled,
        visualTransformation = if (passwordvisibility) VisualTransformation.None else PasswordVisualTransformation('*'),
        trailingIcon = {
            IconButton(onClick = { passwordvisibility = !passwordvisibility }) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(
                        id = passwordIcon,
                    ),
                    contentDescription = stringResource(id = R.string.passwordVisibility),
                    tint = MaterialTheme.colors.secondary,
                )
            }
        },
    )
}
