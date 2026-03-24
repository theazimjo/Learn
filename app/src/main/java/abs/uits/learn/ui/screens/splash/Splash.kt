package abs.uits.learn.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import abs.uits.learn.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
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
        modifier
            .fillMaxSize()
            .background(Color(0xFF53B175)),
        contentAlignment = Alignment.Center
    ) {
        Image(modifier = Modifier.fillMaxWidth(0.7f),painter = painterResource(R.drawable.logo), contentDescription = "", contentScale = ContentScale.Crop)
    }
}
