// ktlint-disable filename
package com.example.hazardhunt.signup.presentation

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
import com.example.hazardhunt.R
import com.example.hazardhunt.core.BoldTExtField
import com.example.hazardhunt.core.CheckBox
import com.example.hazardhunt.core.CustomTextField
import com.example.hazardhunt.core.Email
import com.example.hazardhunt.core.Password
import com.example.hazardhunt.core.SignUpButton
import com.example.hazardhunt.ui.theme.HazardHuntTheme
import com.ramcosta.composedestinations.annotation.Destination


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
    HazardHuntTheme() {
        SignUpPage()
    }
}
