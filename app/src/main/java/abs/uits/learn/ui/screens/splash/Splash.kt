package abs.uits.learn.ui.screens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay

@Composable
fun Splash(modifier: Modifier = Modifier, navController: NavController) {
    LaunchedEffect(
        Unit
    ) {
        delay(2000)
        navController.navigate("login")
    }

    Box(
        modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text("Splash Screen")
    }
}