// ktlint-disable filename
package com.example.hazardhunt.login.presentation

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.hazardhunt.R
import com.example.hazardhunt.core.CustomTextField
import com.example.hazardhunt.core.PrimaryButton
import com.example.hazardhunt.core.SignupAnnotatedString
import com.example.hazardhunt.core.UIText
import com.example.hazardhunt.core.VerticalSpacer
import com.example.hazardhunt.core.getString
import com.example.hazardhunt.login.data.model.LogInViewState
import com.example.hazardhunt.login.domain.util.Credentials
import com.example.hazardhunt.login.domain.util.Email
import com.example.hazardhunt.login.domain.util.Password
import com.example.hazardhunt.ui.theme.HazardHuntTheme
import com.example.hazardhunt.ui.theme.UrbanistMedium

/**
 * This is a composable that maintains the the entire login Screen.
 * @param[viewState] the current state of what your screen renders
 * @param[onLoginClicked] a call back that is invoked when the user clicks the login screen
 * @param[onUserNameChanged]a call back that is invoked when the text field of user name changes
 * @param[onSignupClicked] a call back that is invoked when the the sign ip button is clicked
 * @param[onPasswordChanged] a call back that is invoked when there is changes in the pass word text field
 * */

@Composable
fun LoginPage(

    viewState: LogInViewState,
    onUserNameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    onSignupClicked: () -> Unit,
    signup: () -> Unit,
    modifier: Modifier = Modifier,

) {
    Surface(
        color = MaterialTheme.colorScheme.onBackground,
    ) {
        Box {
            LogoInputColum(
                viewState,
                onUserNameChanged,
                onPasswordChanged,
                onLoginClicked,
                onSignupClicked,
                signup = signup,
            )
        }
    }
}

@Composable
private fun LogoInputColum(
    viewState: LogInViewState,
    onUserNameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    onSignupClicked: () -> Unit,
    signup: () -> Unit,
) {
    Column(
        modifier = Modifier
            .background(
                color = colorResource(id = R.color.background),

            )
            .padding(dimensionResource(id = R.dimen.screen_padding))
            .fillMaxSize()
            .navigationBarsPadding(),

        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        VerticalSpacer(height = 30.dp)
        ImageCard(painter = painterResource(id = R.drawable.login))

        // LoginAnimation()
        VerticalSpacer(height = 10.dp)

        if (viewState is LogInViewState.Submitting) {
            CircularProgressIndicator(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.CenterHorizontally),
                color = MaterialTheme.colorScheme.secondaryContainer,
            )
        }

        Email(
            enabled = viewState.buttonsEnabled,
            text = viewState.credentials.email.emailValue,
            onEmailTextChanged = onUserNameChanged,
            errorMessage = (viewState as? LogInViewState.Active)?.emailInputErrorMessage?.getString(
                LocalContext.current,
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.mail),
                    contentDescription = stringResource(R.string.Password),
                    tint = MaterialTheme.colorScheme.secondaryContainer,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.Icon_height)),
                )
            },

        )

        VerticalSpacer(height = 12.dp)

        Password(
            text = viewState.credentials.password.passwordValue,
            enabled = viewState.buttonsEnabled,
            onPasswordTextChanged = onPasswordChanged,
            errorMessage = (viewState as? LogInViewState.Active)?.passwordInputErrorMessage?.getString(
                LocalContext.current,
            ),
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
        if (viewState is LogInViewState.SubmissionError) {
            Text(
                fontFamily = UrbanistMedium,
                text = viewState.errorMessage.getString(LocalContext.current),
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 12.dp),
            )
        }

        VerticalSpacer(height = 30.dp)

        LoginButton(onClick = onLoginClicked)

        VerticalSpacer(height = 20.dp)

        SignupAnnotatedString(action = signup)

        // SignUpButton(onSignupClicked = onSignupClicked)
    }
}

@Composable
fun Password(
    modifier: Modifier = Modifier,
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
                    tint = MaterialTheme.colorScheme.secondaryContainer,
                )
            }
        },
    )
}

@Composable
fun SignUpButton(onSignupClicked: () -> Unit) {
    PrimaryButton(
        modifier = Modifier.navigationBarsPadding(),
        text = stringResource(id = R.string.sign_up),
        onclick = onSignupClicked,
    )
}

@Composable
fun LoginButton(onClick: () -> Unit) {
    PrimaryButton(
        text = stringResource(id = R.string.Log_in),
        onclick = onClick,
    )
}

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

@Composable
fun ReuseableButtonComposable(
    text: String,
    comp: ((@Composable () -> Unit))?,
    onclick: () -> Unit,
) {
    Button(onClick = onclick) {
        Text(text = text)
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
@Suppress("UnusedPrivateMember")
@Composable
private fun LoginPrev() {
    HazardHuntTheme {
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
@Suppress("UnusedPrivateMember")
@Composable
private fun LoginPreview(
    @PreviewParameter(LoginViewStateProvider::class)
    logInViewState: LogInViewState,
) {
    val viewState = logInViewState
    HazardHuntTheme {
        LoginPage(
            viewState = viewState,
            {},
            {},
            {},
            {},
            {},
        )
    }
}

class LoginViewStateProvider : PreviewParameterProvider<LogInViewState> {

    override val values: Sequence<LogInViewState>
        get() {
            val activeCredentials = Credentials(
                Email("uduakumanah19@gmail.com"),
                Password("1234"),

            )
            return sequenceOf(
                LogInViewState.InitialLoginState,
                LogInViewState.Active(activeCredentials),
                LogInViewState.Submitting(activeCredentials),
                LogInViewState.SubmissionError(
                    activeCredentials,
                    UIText.StringText("Something is wrong"),
                ),
                LogInViewState.Active(
                    credentials = activeCredentials,
                    emailInputErrorMessage = UIText.StringText("please enter email"),
                    passwordInputErrorMessage = UIText.StringText("password"),

                ),

            )
        }
}

@Composable
fun ImageCard(painter: Painter) {
    Box(modifier = Modifier.size(300.dp)) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painter,
            contentDescription = "",
            contentScale = ContentScale.Crop,
        )
    }
}
