package abs.uits.learn.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.Navigator

@Composable
fun Home(modifier: Modifier = Modifier, viewModel: HomeViewModel) {
    Box(
        modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text("Home")
    }
}