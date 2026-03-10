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
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun Login(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = viewModel(),
    navController: NavController
) {
    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column() {
            var username by remember { mutableStateOf("emilys") }
            var password by remember { mutableStateOf("emilyspass") }
            var expiresInMins by remember { mutableStateOf(30) }
            var scope = rememberCoroutineScope()

            var status by remember { mutableStateOf("") }

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

            Text(text = "$status")

            Button(
                onClick = {
                    scope.launch {
                        try {

                            viewModel.login(UserLogin(username, password, expiresInMins))
                            navController.navigate("main")
                        } catch (e: Exception) {
                            status = "Email or Password wrong!"
                        }
                    }
                }
            ) {
                Text("Login")
            }

        }
    }
}
