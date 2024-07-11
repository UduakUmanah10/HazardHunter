// ktlint-disable filename
package com.hazardhunt.safebuddy.core

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.hazardhunt.safebuddy.R

@Composable
fun SignUpButton(onSignupClicked: () -> Unit) {
    PrimaryButton(
        modifier = Modifier.navigationBarsPadding(),
        text = stringResource(id = R.string.sign_up),
        onclick = onSignupClicked,
    )
}
