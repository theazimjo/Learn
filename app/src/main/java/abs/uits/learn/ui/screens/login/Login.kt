package abs.uits.learn.ui.screens.login

import abs.uits.learn.domain.model.UserLogin
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

@Composable
fun Login(modifier: Modifier = Modifier, viewModel: LoginViewModel = viewModel()) {
    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column() {
            var username by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var expiresInMins by remember { mutableStateOf(30) }
            var scope = rememberCoroutineScope()

            var message by remember { mutableStateOf("") }

            TextField(
                value = username,
                onValueChange = {
                    username = it
                },
                label = { Text("Username") }
            )
            Spacer(modifier.height(15.dp))

            TextField(
                value = password,
                onValueChange = {
                    password = it
                },
                label = { Text("Password") }
            )
            Spacer(modifier.height(15.dp))

            Text(text = "$message")

            Button(
                onClick = {
                    scope.launch {
                        try {
                            var userinfo =
                                viewModel.login(UserLogin(username, password, expiresInMins))

                            message = "$userinfo"
                        } catch (e: Exception) {
                            message = "Login error: $e"
                        }
                    }
                }
            ) {
                Text("Login")
            }

        }
    }
}
