// ktlint-disable filename
package com.hazardhunt.safebuddy.signup.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.view.theme.SafeBuddyTheme
import com.hazardhunt.safebuddy.R
import com.hazardhunt.safebuddy.core.BoldTExtField
import com.hazardhunt.safebuddy.core.CheckBox
import com.hazardhunt.safebuddy.core.CustomTextField
import com.hazardhunt.safebuddy.core.Email
import com.hazardhunt.safebuddy.core.Password
import com.hazardhunt.safebuddy.core.SignUpButton

@Composable
fun SignUpPage() {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.addpreson),
            contentDescription = stringResource(R.string.Password),
            tint = MaterialTheme.colorScheme.secondaryContainer,
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.CenterHorizontally),
        )
        // NormalTextField(textValue = stringResource(id = R.string.Helo))
        BoldzTextField()
        CustomTextField(
            text = "",
            onTextChanged = {},
            labelText = stringResource(id = R.string.lastName),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.person),
                    contentDescription = stringResource(R.string.Password),
                    tint = MaterialTheme.colorScheme.secondaryContainer,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.Icon_height)),
                )
            },
        )
        Email(
            enabled = true,
            text = "",
            onEmailTextChanged = {},
            errorMessage = null,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.mail),
                    contentDescription = stringResource(R.string.Password),
                    tint = MaterialTheme.colorScheme.secondaryContainer,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.Icon_height)),
                )
            },
        )
        Password(
            text = "",
            enabled = true,
            onPasswordTextChanged = {},
            errorMessage = null,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.shieldlockx),
                    contentDescription = stringResource(R.string.Password),
                    tint = MaterialTheme.colorScheme.secondaryContainer,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.Icon_height)),
                )
            },
            visualTransformation = PasswordVisualTransformation('*'),
        )
        CheckBox() {
        }
        Spacer(modifier = Modifier.padding(20.dp))

        SignUpButton(onSignupClicked = {})

        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = stringResource(id = R.string.already_have_an_account),
            )
        }
    }
}

@Composable
private fun BoldzTextField() {
    BoldTExtField(textValue = stringResource(id = R.string.create_account))
    CustomTextField(
        text = "",
        onTextChanged = {},
        labelText = stringResource(id = R.string.firstname),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.person),
                contentDescription = stringResource(R.string.Password),
                tint = MaterialTheme.colorScheme.secondaryContainer,
                modifier = Modifier.size(dimensionResource(id = R.dimen.Icon_height)),
            )
        },
    )
}

@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Day mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
fun SignupPreview() {
    SafeBuddyTheme() {
        SignUpPage()
    }
}
