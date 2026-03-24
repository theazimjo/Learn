package abs.uits.learn.ui.screens.login

import abs.uits.learn.R
import abs.uits.learn.domain.model.UserLogin
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@Composable
fun Login(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = viewModel(),
    navController: NavController
) {
    Box(
        modifier
            .fillMaxSize()
            .padding(20.dp), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            var username by remember { mutableStateOf("emilys") }
            var password by remember { mutableStateOf("emilyspass") }
            var expiresInMins by remember { mutableIntStateOf(30) }
            var scope = rememberCoroutineScope()
            var progress by remember { mutableStateOf(false) }

            var status by remember { mutableStateOf("") }

            Spacer(modifier.height(45.dp))
            Image(
                painter = painterResource(R.drawable.carrot),
                contentDescription = "logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.width(50.dp)
            )
            Spacer(modifier.height(70.dp))
            Column(
                modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = "Loging",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF181725)
                )
                Spacer(modifier.height(15.dp))
                Text(
                    text = "Enter your emails and password",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF7C7C7C)
                )
            }


            Spacer(modifier.height(30.dp))

            TextField(
                value = username,
                onValueChange = {
                    username = it
                },
                modifier.fillMaxWidth(),
                label = { Text("Username") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.Black,
                    errorContainerColor = Color.Black,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                )
            )
            Spacer(modifier.height(15.dp))

            TextField(
                value = password,
                onValueChange = {
                    password = it
                },
                modifier.fillMaxWidth(),
                label = { Text("Password") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.Black,
                    errorContainerColor = Color.Black,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                )
            )
            Spacer(modifier.height(15.dp))

            Text(text = "$status")

            Button(
                onClick = {
                    scope.launch {
                        try {
                            progress = true
                            viewModel.login(UserLogin(username, password, expiresInMins))
                            navController.navigate("main")
                        } catch (e: Exception) {
                            progress = false
                            status = "Email or Password wrong!"
                        }
                    }
                },
                modifier
                    .fillMaxWidth()
                    .height(67.dp),
                shape = RoundedCornerShape(19.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF53B175),
                    contentColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = Color.DarkGray
                )
            ) {

                if (progress) {
                    CircularProgressIndicator(color = Color(0xFFFFFFFF))
                } else {
                    Text("Log in", fontSize = 18.sp)
                }
            }

        }
    }
}


@SuppressLint("ViewModelConstructorInComposable")
@Composable
@Preview(showSystemUi = true)
fun View(modifier: Modifier = Modifier) {
    var navController = rememberNavController()
    Login(modifier, LoginViewModel(), navController)
}