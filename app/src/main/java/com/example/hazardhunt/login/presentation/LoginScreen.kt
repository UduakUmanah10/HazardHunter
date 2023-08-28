package com.example.hazardhunt.login.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hazardhunt.login.domain.viewmodel.LoginViewModel
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    loginCompleted: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel(),
    signup: () -> Unit,

) {
    val viewState = viewModel.viewState.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    SideEffect {
        coroutineScope.launch {
            viewModel.completedState.receive()
            loginCompleted.invoke()
        }
    }

    LoginPage(
        viewState = viewState.value,
        onUserNameChanged = viewModel::emailChange,
        onPasswordChanged = viewModel::passwordChangeed,
        onLoginClicked = viewModel::signInButtonClicked,
        onSignupClicked = viewModel::signInButtonClicked,
        signup = signup,
    )
}
